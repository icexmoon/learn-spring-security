package cn.icexmoon.learnspringsecurity.jwt.service.impl;

import cn.icexmoon.learnspringsecurity.jwt.entity.CustomUser;
import cn.icexmoon.learnspringsecurity.jwt.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserDetailServiceImpl
 * @Description 重写 UserDetailsService，获取用户信息
 * @Author icexmoon@qq.com
 * @Date 2026/1/5 17:50
 * @Version 1.0
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 从数据库获取用户信息
     * @param username 用户名
     * @return 用户信息
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<CustomUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        CustomUser user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在" + username);
        }
        return user;
    }
}