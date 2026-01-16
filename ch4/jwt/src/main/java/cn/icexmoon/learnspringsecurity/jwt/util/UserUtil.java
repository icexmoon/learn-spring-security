package cn.icexmoon.learnspringsecurity.jwt.util;

import cn.icexmoon.learnspringsecurity.jwt.entity.BusinessException;
import cn.icexmoon.learnspringsecurity.jwt.entity.CustomUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @ClassName UserUtil
 * @Description
 * @Author icexmoon@qq.com
 * @Date 2026/1/16 14:59
 * @Version 1.0
 */
public class UserUtil {
    public static CustomUser getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw BusinessException.builder()
                    .code("NOT_LOGIN")
                    .message("用户未登录")
                    .httpStatusCode(401)
                    .build();
        }
        return (CustomUser) authentication.getPrincipal();
    }
}
