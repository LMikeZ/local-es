package com.example.lizan.repository.mapper;

import com.example.lizan.repository.model.TestUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lizan
 * @since 2022-05-16
 */
@Mapper
public interface TestUserMapper extends BaseMapper<TestUser> {

    void save(@Param("user") TestUser user);

    TestUser queryById(Long id);
}
