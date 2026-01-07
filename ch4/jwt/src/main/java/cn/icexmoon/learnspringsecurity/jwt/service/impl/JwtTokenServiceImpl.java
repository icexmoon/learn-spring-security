package cn.icexmoon.learnspringsecurity.jwt.service.impl;

import cn.icexmoon.learnspringsecurity.jwt.config.JwtProperties;
import cn.icexmoon.learnspringsecurity.jwt.controller.AuthController;
import cn.icexmoon.learnspringsecurity.jwt.entity.BusinessException;
import cn.icexmoon.learnspringsecurity.jwt.service.JwtTokenService;
import cn.icexmoon.learnspringsecurity.jwt.util.JwtTokenProvider;
import cn.icexmoon.learnspringsecurity.jwt.util.RefreshTokenRedis;
import io.jsonwebtoken.JwtException;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName JwtTokenServiceImpl
 * @Description
 * @Author icexmoon@qq.com
 * @Date 2026/1/7 12:40
 * @Version 1.0
 */
@Service
public class JwtTokenServiceImpl implements JwtTokenService {
    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private RefreshTokenRedis refreshTokenRedis;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public AuthController.LoginResponse generateToken(@NonNull UserDetails userDetails) {
        // 生成 access token
        String accessToken = tokenProvider.generateToken(userDetails);
        // 生成 refresh token
        String refreshToken = tokenProvider.generateRefreshToken(userDetails);
        // 将 refresh token 保存到 Redis
        refreshTokenRedis.save(userDetails.getUsername(), refreshToken);
        return new AuthController.LoginResponse(accessToken, refreshToken);
    }

    @Override
    public AuthController.LoginResponse validateToken(@NonNull String refreshToken) {
        // 验证 JWT 加密是否正确
        String username;
        try {
            username = tokenProvider.getUsernameFromJWT(refreshToken);
        } catch (JwtException e) {
            // 不正确的 JWT 令牌，可能是伪造的，返回错误信息
            throw BusinessException.builder()
                    .httpStatusCode(HttpStatus.UNAUTHORIZED.value())
                    .code("refresh.token.invalid")
                    .message("refresh token 无效，请重新登录")
                    .sourceException(e)
                    .build();
        }
        if (!StringUtils.hasText(username)) {
            // 格式正确，但缺少用户名，可能是系统 bug
            throw BusinessException.builder()
                    .httpStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .code("refresh.token.invalid")
                    .message("refresh token 无效，请重新登录")
                    .build();
        }
        // 检查 redis 中是否有效
        boolean validate = refreshTokenRedis.validate(username, refreshToken);
        if (!validate) {
            // 不是在 redis 中记录的有效 refresh token，可能是黑客窃取并进行了重放攻击
            // 清除 redis 中记录的 refresh token 以防被利用
            refreshTokenRedis.delete(username);
            throw BusinessException.builder()
                    .httpStatusCode(HttpStatus.UNAUTHORIZED.value())
                    .code("refresh.token.invalid")
                    .message("refresh token 无效，请重新登录")
                    .build();
        }
        // 刷新令牌验证通过，生成新的刷新令牌和访问令牌，并返回
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null// 密码在此处不需要
                );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return generateToken(userDetails);
    }
}
