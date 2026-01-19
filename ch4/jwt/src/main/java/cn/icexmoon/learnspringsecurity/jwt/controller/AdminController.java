package cn.icexmoon.learnspringsecurity.jwt.controller;

import cn.icexmoon.learnspringsecurity.jwt.entity.Result;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName AdminController
 * @Description
 * @Author icexmoon@qq.com
 * @Date 2026/1/16 17:14
 * @Version 1.0
 */
@RequestMapping("/admin")
@RestController
public class AdminController {
    @RequestMapping("/index")
    public Result<String> index() {
        return Result.success("Hello, Admin");
    }
}
