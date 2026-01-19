package cn.icexmoon.learnspringsecurity.jwt.mapper;

import cn.icexmoon.learnspringsecurity.jwt.entity.RoleAuthority;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName RoleAuthorityMapper
 * @Description
 * @Author icexmoon@qq.com
 * @Date 2026/1/19 08:34
 * @Version 1.0
 */
@Mapper
public interface RoleAuthorityMapper extends BaseMapper<RoleAuthority> {
}
