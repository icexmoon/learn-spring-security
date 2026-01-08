package cn.icexmoon.learnspringsecurity.jwt.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName User
 * @Description Spring Security 默认的用户实体结构
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
