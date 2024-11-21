package com.example.lizan.controller;


import com.alibaba.fastjson.JSON;
import com.example.lizan.aspect.ann.TestAuthAnn;
import com.example.lizan.bean.UserTestDTO;
import com.example.lizan.eventBus.EventBus;
import com.example.lizan.req.TranslateRequestParams;
import com.example.lizan.util.ErpResult;
import com.example.lizan.util.PageResult;
import com.example.lizan.util.Result;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.IdGenerator;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lizan
 * @since 2022-05-16
 */
@RestController
@Slf4j
@RequestMapping("/test-user")
public class TestUserController {

    @Autowired
    EventBus eventBus;



    @GetMapping("/{id}")
    public Result translate(@PathVariable String id) {
//        testV2(requestParams);
        UserTestDTO userTestDTO = new UserTestDTO().setName("dfsaf").setUrl("fdsagsgs").setUid("fdsaf");
        eventBus.dispatchSubscriber(userTestDTO);
     
        return Result.success(PageResult.builder().result(Lists.newArrayList(userTestDTO)).build());
    }

    @PostMapping("/test")
    public ErpResult upload(@RequestBody String params) throws Exception {
        log.info("[test] time:{}, params:{}", LocalDateTime.now(), params);
        Random random = new Random();
        return new ErpResult("", "success",String.valueOf(random.nextInt()) , true);
        // return new ErpResult("", "用于测试报错保存记录", null, false);
    }

    private void testV2(Object obj) {
        if (obj instanceof TranslateRequestParams) {
            TranslateRequestParams requestParams = (TranslateRequestParams) obj;
            log.info("[TranslateRequestParams] requestParams:{}", JSON.toJSONString(requestParams));
            log.info("[TranslateRequestParams] path:{}", requestParams.path());
        }
    }
}

