package cn.icexmoon.learnspringsecurity.jwt.entity;

import cn.hutool.core.util.BooleanUtil;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName User
 * @Description Spring Security 默认的用户实体结构
 * @Author icexmoon@qq.com
 * @Date 2026/1/5 11:03
 * @Version 1.0
 */
@Data
@TableName("user")
public class CustomUser implements UserDetails {
    private Integer id;
    private String username;
    private String password;
    private Boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public boolean isEnabled() {
        return BooleanUtil.isTrue(enabled);
    }
}
