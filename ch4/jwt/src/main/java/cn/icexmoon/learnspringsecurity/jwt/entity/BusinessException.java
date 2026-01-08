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
    // 如果需要修改响应的 http 状态码，可以设置
    private final Integer httpStatusCode;
    // 错误码
    private final String code;
    // 错误信息
    private final String message;
    // 数据
    private final Object data;
    // 异常来源（如果有的话）
    private final Exception sourceException;
}
