package com.example.lizan.controller;


import com.alibaba.fastjson.JSON;
import com.example.lizan.aspect.ann.TestAuthAnn;
import com.example.lizan.bean.UserTestDTO;
import com.example.lizan.eventBus.EventBus;
import com.example.lizan.req.TranslateRequestParams;
import com.example.lizan.util.PageResult;
import com.example.lizan.util.Result;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

    private void testV2(Object obj) {
        if (obj instanceof TranslateRequestParams) {
            TranslateRequestParams requestParams = (TranslateRequestParams) obj;
            log.info("[TranslateRequestParams] requestParams:{}", JSON.toJSONString(requestParams));
            log.info("[TranslateRequestParams] path:{}", requestParams.path());
        }
    }
}

