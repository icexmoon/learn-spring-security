package cn.icexmoon.learnspringsecurity.jwt.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName JwtProperties
 * @Description JWT 令牌的自定义配置
 * @Author icexmoon@qq.com
 * @Date 2026/1/7 12:49
 * @Version 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtProperties {
    // access token 的有效时长
    private long expirationMs;
    // refresh token 的有效时长
    private long refreshTokenExpirationHours;
}
