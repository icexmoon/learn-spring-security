package cn.icexmoon.learnspringsecurity.jwt.mapper;

import cn.icexmoon.learnspringsecurity.jwt.entity.UserAuthority;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName UserAuthorityMapper
 * @Description
 * @Author icexmoon@qq.com
 * @Date 2026/1/16 16:57
 * @Version 1.0
 */
@Mapper
public interface UserAuthorityMapper extends BaseMapper<UserAuthority> {
}
