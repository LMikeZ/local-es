package com.example.lizan;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.lizan.repository.mapper.TestUserMapper;
import com.example.lizan.repository.model.TestUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author lizan
 * @version $Id: ProxyTest.java, v 0.1 2022年06月13日 15:56 lizan Exp $$
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LocalEsApplication.class)
public class UserTest {

    @Resource
    TestUserMapper testUserMapper;

    @Test
    public void testSave(){
        TestUser user = new TestUser();
        user.setName("刘书豪");
        user.setSex("女");
        user.setPassword("12345");
        user.setGmtCreate(LocalDateTime.now());
        List<TestUser> testUsers = testUserMapper.selectList(null);
        System.out.println(testUsers);
        ThreadLocal local = new ThreadLocal();
        local.set(testUsers);

    }
    @Test
    public void testQuery(){
        LambdaQueryWrapper<TestUser> queryWrapper = new LambdaQueryWrapper<>();

        testUserMapper.queryById(1L);

    }

}