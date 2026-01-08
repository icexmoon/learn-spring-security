package cn.icexmoon.learnspringsecurity.jwt.core;

import cn.icexmoon.learnspringsecurity.jwt.entity.BusinessException;
import cn.icexmoon.learnspringsecurity.jwt.entity.Result;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 全局异常处理
 * @Author icexmoon@qq.com
 * @Date 2026/1/7 14:03
 * @Version 1.0
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 处理业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public Result<Object> handleBusinessException(BusinessException ex, HttpServletResponse response) {
        log.debug("handleBusinessException: {}", ex.getMessage(), ex);
        // 如果异常指定了HTTP状态码，重写响应状态码
        if (ex.getHttpStatusCode() != null){
            response.setStatus(ex.getHttpStatusCode());
        }
        return Result.error(ex.getCode(), ex.getMessage(), ex.getData());
    }

    /**
     * 处理其他未预期的异常，作为一个保底方案
     */
    @ExceptionHandler(Exception.class)
    public Result<Void> handleAllExceptions(Exception ex) {
        log.debug("handleBusinessException: {}", ex.getMessage(), ex);
        return Result.error("error.unknow", ex.getMessage());
    }
}
