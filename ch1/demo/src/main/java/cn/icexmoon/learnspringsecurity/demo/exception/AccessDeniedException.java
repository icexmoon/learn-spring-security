package cn.icexmoon.learnspringsecurity.demo.exception;

/**
 * @ClassName AccessDeniedException
 * @Description
 * @Author icexmoon@qq.com
 * @Date 2025/12/23 下午4:42
 * @Version 1.0
 */
public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException(String accessDenied) {
        super(accessDenied);
    }
}
