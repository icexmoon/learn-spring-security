package cn.icexmoon.learnspringsecurity.jwt.mapper;

import cn.icexmoon.learnspringsecurity.jwt.entity.CustomUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName UserMapper
 * @Description
 * @Author icexmoon@qq.com
 * @Date 2026/1/5 17:50
 * @Version 1.0
 */
@Mapper
public interface CustomUserMapper extends BaseMapper<CustomUser> {
}