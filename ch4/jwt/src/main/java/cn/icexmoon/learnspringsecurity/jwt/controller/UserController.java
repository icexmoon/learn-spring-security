package cn.icexmoon.learnspringsecurity.jwt.controller;

import cn.icexmoon.learnspringsecurity.jwt.entity.CustomUser;
import cn.icexmoon.learnspringsecurity.jwt.entity.dto.UserDTO;
import cn.icexmoon.learnspringsecurity.jwt.util.UserUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description
 * @Author icexmoon@qq.com
 * @Date 2026/1/16 14:50
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
//    @GetMapping("/info")
    public UserDTO getUserInfo() {
        CustomUser currentUser = UserUtil.getCurrentUser();
        return UserDTO.builder()
                .id(currentUser.getId())
                .username(currentUser.getUsername())
                .enabled(currentUser.isEnabled())
                .build();
    }

    @GetMapping("/info")
    public UserDTO getUserInfo2(@AuthenticationPrincipal CustomUser currentUser) {
        return UserDTO.builder()
                .id(currentUser.getId())
                .username(currentUser.getUsername())
                .enabled(currentUser.isEnabled())
                .build();
    }
}
