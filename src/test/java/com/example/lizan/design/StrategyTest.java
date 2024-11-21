package com.example.lizan.design;

import com.example.lizan.LocalEsApplication;
import com.example.lizan.design.strategy.EventTaskTypeFactory;
import com.example.lizan.design.strategy.ProcessOperateHandler;
import com.example.lizan.enums.TaskTypeEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lizan
 * @version $Id: StrategyTest.java, v 0.1 2024年11月06日 09:36 lizan Exp $$
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LocalEsApplication.class)
public class StrategyTest {
    @Test
    public void test(){
        ProcessOperateHandler handler = EventTaskTypeFactory.getHandler(TaskTypeEnum.ACCEPT.getType());
        handler.operate(null);
    }
}
