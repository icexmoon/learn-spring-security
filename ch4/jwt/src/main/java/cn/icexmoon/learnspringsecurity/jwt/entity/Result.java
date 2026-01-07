package cn.icexmoon.learnspringsecurity.jwt.entity;

import lombok.Data;

/**
 * @ClassName Result
 * @Description
 * @Author icexmoon@qq.com
 * @Date 2026/1/6 08:11
 * @Version 1.0
 */
@Data
public class Result<T> {
    private String code;
    private String message;
    private T data;
    private boolean success;
    public static final String DEFAULT_ERROR_CODE = "error.unknow";

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode("200");
        result.setMessage("成功");
        result.setData(data);
        result.setSuccess(true);
        return result;
    }

    public static Result<Void> success() {
        return success(null);
    }

    public static Result<Void> error(String code, String message) {
        return error(code, message, null);
    }

    public static <T> Result<T> error(String code, String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        result.setSuccess(false);
        result.setData(data);
        return result;
    }

    public static Result<Void> error(String message) {
        return error(DEFAULT_ERROR_CODE, message);
    }
}
