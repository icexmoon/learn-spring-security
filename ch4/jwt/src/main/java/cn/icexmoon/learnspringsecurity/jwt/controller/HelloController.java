package cn.icexmoon.learnspringsecurity.jwt.controller;

import cn.icexmoon.learnspringsecurity.jwt.entity.Result;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description
 * @Author icexmoon@qq.com
 * @Date 2026/1/6 08:09
 * @Version 1.0
 */
@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/hello")
    public Result<String> hello() {
        return Result.success("hello");
    }

    @GetMapping("/index")
    @PreAuthorize("hasRole('ADMIN') || hasAuthority('/api/index:read')")
    public Result<String> index() {
        return Result.success("index");
    }

    @GetMapping("/userIndex")
    @PreAuthorize("hasAuthority('/api/userIndex:read')")
    public Result<String> userIndex(){
        return Result.success("userIndex");
    }
}
