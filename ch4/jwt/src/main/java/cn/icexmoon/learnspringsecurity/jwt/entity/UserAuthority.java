package cn.icexmoon.learnspringsecurity.jwt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;

/**
 * @ClassName Authority
 * @Description
 * @Author icexmoon@qq.com
 * @Date 2026/1/16 16:41
 * @Version 1.0
 */
@TableName("user_authority")
@Data
public class UserAuthority implements GrantedAuthority {
    public static final String ROLE_PREFIX = "ROLE_";
    private String username;
    private String authority;
}
