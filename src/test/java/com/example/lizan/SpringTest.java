package com.example.lizan;

import com.alibaba.fastjson.JSON;
import com.example.lizan.repository.model.TestUser;
import com.example.lizan.spring.SpringUtils;
import com.example.lizan.spring.selftag.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author lizan
 * @version $Id: SpringTest.java, v 0.1 2023年03月24日 13:57 lizan Exp $$
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@MapperScan(basePackages = "com.example.lizan")
public class SpringTest {


    @Test
    public void test1() {
        User bean = SpringUtils.getContext().getBean(User.class);
        bean.setAge("11");
        System.out.println(JSON.toJSONString(bean));
    }
}
