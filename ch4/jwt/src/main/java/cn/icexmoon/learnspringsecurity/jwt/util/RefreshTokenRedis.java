package cn.icexmoon.learnspringsecurity.jwt.util;

import cn.icexmoon.learnspringsecurity.jwt.config.JwtProperties;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName RefreshTokenRedis
 * @Description
 * @Author icexmoon@qq.com
 * @Date 2026/1/7 13:08
 * @Version 1.0
 */
@Component
public class RefreshTokenRedis {
    public static final String REFRESH_TOKEN_KEY_PREFIX = "refresh-token:";
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private JwtProperties jwtProperties;

    public void save(@NonNull String username, @NonNull String refreshToken) {
        redisTemplate.opsForValue().set(
                REFRESH_TOKEN_KEY_PREFIX + username,
                refreshToken,
                jwtProperties.getRefreshTokenExpirationHours(),
                TimeUnit.HOURS
        );
    }

    public String get(@NonNull String username) {
        return redisTemplate.opsForValue().get(REFRESH_TOKEN_KEY_PREFIX + username);
    }

    public boolean validate(@NonNull String username, @NonNull String refreshToken){
        return refreshToken.equals(get(username));
    }

    public void delete(String username) {
        redisTemplate.delete(REFRESH_TOKEN_KEY_PREFIX + username);
    }
}
