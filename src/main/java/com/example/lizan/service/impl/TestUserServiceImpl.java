package com.example.lizan.service.impl;

import com.example.lizan.repository.model.TestUser;
import com.example.lizan.repository.mapper.TestUserMapper;
import com.example.lizan.service.ITestUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lizan
 * @since 2022-05-16
 */
@Service
public class TestUserServiceImpl extends ServiceImpl<TestUserMapper, TestUser> implements ITestUserService {

}
