package cn.icexmoon.learnspringsecurity.jwt.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName User
 * @Description
 * @Author icexmoon@qq.com
 * @Date 2026/1/5 11:03
 * @Version 1.0
 */
@Data
@TableName("user")
public class User {
    private Integer id;
    private String username;
    private String password;
    private Boolean enabled;
}
