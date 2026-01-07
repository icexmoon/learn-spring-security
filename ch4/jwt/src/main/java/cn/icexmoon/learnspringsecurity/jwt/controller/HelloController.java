package cn.icexmoon.learnspringsecurity.jwt.controller;

import cn.icexmoon.learnspringsecurity.jwt.entity.Result;
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
}
