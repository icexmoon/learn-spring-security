package cn.icexmoon.learnspringsecurity.jwt.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.icexmoon.learnspringsecurity.jwt.entity.RoleAuthority;
import cn.icexmoon.learnspringsecurity.jwt.mapper.RoleAuthorityMapper;
import cn.icexmoon.learnspringsecurity.jwt.service.RoleAuthorityService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.SortedSet;

/**
 * @ClassName RoleAuthorityServiceImpl
 * @Description
 * @Author icexmoon@qq.com
 * @Date 2026/1/19 08:36
 * @Version 1.0
 */
@Service
public class RoleAuthorityServiceImpl extends ServiceImpl<RoleAuthorityMapper, RoleAuthority> implements RoleAuthorityService {
    @Override
    public List<RoleAuthority> listByRole(String role) {
        return baseMapper.selectList(new QueryWrapper<RoleAuthority>().eq("role", role));
    }

    @Override
    public List<RoleAuthority> listByRole(@NonNull List<String> roles) {
        if (!CollectionUtil.isEmpty(roles)){
            return baseMapper.selectList(new QueryWrapper<RoleAuthority>().in("role", roles));
        }
        return List.of();
    }

    @Override
    public SortedSet<String> getAuthoritiesByRole(List<String> roles) {
        List<RoleAuthority> roleAuthorities = listByRole(roles);
        if (!CollectionUtil.isEmpty(roleAuthorities)){
            return roleAuthorities.stream().map(RoleAuthority::getAuthority).sorted().collect(java.util.stream.Collectors.toCollection(java.util.TreeSet::new));
        }
        return java.util.Collections.emptySortedSet();
    }
}
