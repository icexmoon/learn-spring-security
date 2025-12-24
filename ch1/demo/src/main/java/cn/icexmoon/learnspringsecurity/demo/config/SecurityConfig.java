package cn.icexmoon.learnspringsecurity.demo.config;

import cn.icexmoon.learnspringsecurity.demo.filter.TenantFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

/**
 * @ClassName SecurityConfig
 * @Description
 * @Author icexmoon@qq.com
 * @Date 2025/12/23 下午4:28
 * @Version 1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        httpSecurity.csrf(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .authorizeHttpRequests(authorize ->
                        authorize.anyRequest().authenticated());
        httpSecurity.addFilterAfter(new TenantFilter(), AnonymousAuthenticationFilter.class);
        return httpSecurity.build();
    }
}
