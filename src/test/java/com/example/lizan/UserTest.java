package com.example.lizan;

import com.alibaba.fastjson.JSON;
import com.example.lizan.design.strategy.EventTaskTypeFactory;
import com.example.lizan.design.strategy.ProcessOperateHandler;
import com.example.lizan.enums.TaskTypeEnum;
import com.example.lizan.repository.mapper.TestUserMapper;
import com.example.lizan.repository.model.TestUser;
import com.example.lizan.util.ChangeBefAftUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lizan
 * @version $Id: ProxyTest.java, v 0.1 2022年06月13日 15:56 lizan Exp $$
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LocalEsApplication.class)
public class UserTest {

    @Resource
    TestUserMapper testUserMapper;
    //
    // @Autowired
    // EventTaskTypeFactory eventTaskTypeFactory;



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
    public void testQuery() throws Exception {
        List<TestUser> list = new ArrayList<>();
        TestUser user = new TestUser();
        user.setName("刘书豪");
        user.setSex("男");
        user.setPassword("1234567");
        list.add(user);
        List<TestUser> list2 = new ArrayList<>();
        TestUser user2 = new TestUser();
        user2.setName("刘书豪");
        user2.setSex("女");
        user2.setPassword("12345");
        list2.add(user2);
        Map<String, Object> stringObjectMap = ChangeBefAftUtil.changeBefAft(list, list2);
        System.out.println(JSON.toJSONString(stringObjectMap));

    }

}