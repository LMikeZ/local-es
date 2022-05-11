package com.example.lizan;

import com.alibaba.fastjson.JSON;
import com.example.lizan.test.UserTest;
import com.shinemo.chinamobile.common.elasticsearch.core.ElasticsearchHelper;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LocalEsApplication.class)
public class LocalEsApplicationTests {
    @Resource
    ElasticsearchHelper elasticsearchHelper;
    @Resource
    RestHighLevelClient restHighLevelClient;

    @Test
    public void helloEs() throws IOException {
        /* CreateIndexRequest createIndexRequest = new CreateIndexRequest("user");
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse.isAcknowledged());
        restHighLevelClient.close();*/
        boolean b = elasticsearchHelper.createIndex(UserTest.class);
        System.out.println(b);
    }

    @Test
    public void helloSaveEs() throws IOException {

        IndexRequest request = new IndexRequest();
        request.index("user").id("1001");
        UserTest userTest = new UserTest();
        userTest.setName("张三");
        userTest.setSex("男");
        userTest.setAge(30);
        String userJson = JSON.toJSONString(userTest);
        request.source(userJson, XContentType.JSON);
        IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        DocWriteResponse.Result result = response.getResult();

        System.out.println(result);
    }

}
