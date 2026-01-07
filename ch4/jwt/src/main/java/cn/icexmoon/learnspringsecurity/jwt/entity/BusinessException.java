package cn.icexmoon.learnspringsecurity.jwt.entity;

import lombok.Builder;
import lombok.Getter;

/**
 * @ClassName BusinessException
 * @Description MVC 层产生的业务异常
 * @Author icexmoon@qq.com
 * @Date 2026/1/7 13:57
 * @Version 1.0
 */
@Builder
@Getter
public class BusinessException extends RuntimeException{
    private final Integer httpStatusCode;
    private final String code;
    private final String message;
    private final Object data;
    private final Exception sourceException;
}
