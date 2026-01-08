package cn.icexmoon.learnspringsecurity.jwt.core;

import cn.icexmoon.learnspringsecurity.jwt.entity.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @ClassName CustomAccessDeniedHandler
 * @Description 重写请求拒绝访问处理器
 * @Author icexmoon@qq.com
 * @Date 2026/1/6 13:58
 * @Version 1.0
 */
@Component
@Slf4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException {
        log.error("权限不足，无法访问该资源", accessDeniedException);

        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        // 返回统一的JSON错误响应
        Result<String> errorResp = Result.error("error.accessDenied", "权限不足，无法访问该资源", request.getRequestURI());

        new ObjectMapper().writeValue(response.getOutputStream(), errorResp);
    }
}