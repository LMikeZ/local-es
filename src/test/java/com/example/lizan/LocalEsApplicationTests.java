package com.example.lizan;

import com.alibaba.fastjson.JSON;
import com.example.lizan.test.UserTest;
import com.shinemo.chinamobile.common.elasticsearch.core.ElasticsearchHelper;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.MaxAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ReflectionUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.lang.reflect.Field;

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
        request.index("user").id("1004");
        UserTest userTest = new UserTest();
        userTest.setName("??????2");
        userTest.setSex("???");
        userTest.setAge(30);
        String userJson = JSON.toJSONString(userTest);
        request.source(userJson, XContentType.JSON);
        IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        DocWriteResponse.Result result = response.getResult();

        System.out.println(result);
    }

    @Test
    public void helloUpdateEs() throws IOException {

        UpdateRequest request = new UpdateRequest();
        request.index("user").id("1001");
        request.doc(XContentType.JSON, "sex", "???");
        UpdateResponse response = restHighLevelClient.update(request, RequestOptions.DEFAULT);
        DocWriteResponse.Result result = response.getResult();

        System.out.println(result);
    }

    @Test
    public void helloGetEs() throws IOException {
        GetRequest request = new GetRequest();
        request.index("user").id("1001");
        GetResponse response = restHighLevelClient.get(request, RequestOptions.DEFAULT);
        System.out.println(response.getSourceAsString());
    }

    @Test
    public void helloDeleteEs() throws IOException {
        DeleteRequest request = new DeleteRequest();
        request.index("user").id("1003");
        DeleteResponse response = restHighLevelClient.delete(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());
    }

    @Test
    public void helloBatchSaveEs() throws IOException {

        BulkRequest request = new BulkRequest();
        IndexRequest indexRequest = new IndexRequest();
        indexRequest.index("user").id("1002");
        UserTest userTest = new UserTest();
        userTest.setName("??????");
        userTest.setSex("???");
        userTest.setAge(20);
        String userJson = JSON.toJSONString(userTest);
        indexRequest.source(userJson, XContentType.JSON);
        request.add(indexRequest);

        IndexRequest indexRequest2 = new IndexRequest();
        indexRequest2.index("user").id("1003");
        UserTest userTest2 = new UserTest();
        userTest2.setName("?????????");
        userTest2.setSex("???");
        userTest2.setAge(18);
        String userJson2 = JSON.toJSONString(userTest2);
        indexRequest2.source(userJson2, XContentType.JSON);
        request.add(indexRequest2);
        BulkResponse response = restHighLevelClient.bulk(request, RequestOptions.DEFAULT);

        System.out.println(JSON.toJSONString(response));
    }

    @Test
    public void helloQueryEs() throws IOException, IllegalAccessException {
        //????????????
        /* SearchRequest request = new SearchRequest();
        request.indices("user");
        request.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
        
        
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        System.out.println(response.getHits());
        System.out.println(response.getHits().getTotalHits());
        
        for (SearchHit hit : response.getHits()) {
            System.out.println(hit.getSourceAsString());
        }*/
        //????????????
        /* SearchRequest request = new SearchRequest();
        request.indices("user");
        request.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("age",30)));
        
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        System.out.println(response.getHits());
        System.out.println(response.getHits().getTotalHits());
        
        for (SearchHit hit : response.getHits()) {
            System.out.println(hit.getSourceAsString());
        }*/
        //????????????
        /* SearchRequest request = new SearchRequest();
        request.indices("user");
        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        
        builder.from(0);//(?????????-1)*????????????
        builder.size(2);
        request.source(builder);
        
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(response.getHits()));
        System.out.println(response.getHits().getTotalHits());
        
        for (SearchHit hit : response.getHits()) {
            System.out.println(hit.getSourceAsString());
        }*/
        //??????
        /* SearchRequest request = new SearchRequest();
        request.indices("user");
        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        
        builder.from(0);//(?????????-1)*????????????
        builder.size(2);
        builder.sort("age", SortOrder.DESC);
        request.source(builder);
        
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(response.getHits()));
        System.out.println(response.getHits().getTotalHits());
        
        for (SearchHit hit : response.getHits()) {
            System.out.println(hit.getSourceAsString());
        }*/

        //????????????
        /*SearchRequest request = new SearchRequest();
        request.indices("user");
        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        
        String[] excludes = {};
        String[] includes = {"name"};
        builder.fetchSource(includes,excludes);
        request.source(builder);
        
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(response.getHits()));
        System.out.println(response.getHits().getTotalHits());
        
        for (SearchHit hit : response.getHits()) {
            System.out.println(hit.getSourceAsString());
        }*/
        //????????????
        /*SearchRequest request = new SearchRequest();
        request.indices("user");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        //????????? and
        //        boolQueryBuilder.must(QueryBuilders.matchQuery("age",30));
        //        boolQueryBuilder.must(QueryBuilders.matchQuery("sex","???"));
        
        //???????????????
        boolQueryBuilder.should(QueryBuilders.matchQuery("age",30));
        boolQueryBuilder.should(QueryBuilders.matchQuery("age",20));
        
        builder.query(boolQueryBuilder);
        request.source(builder);
        
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(response.getHits()));
        System.out.println(response.getHits().getTotalHits());
        
        for (SearchHit hit : response.getHits()) {
            System.out.println(hit.getSourceAsString());
        }*/

        //????????????
        /* SearchRequest request = new SearchRequest();
        request.indices("user");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");
        rangeQuery.gte(30).lte(40);
        
        builder.query(rangeQuery);
        request.source(builder);
        
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(response.getHits()));
        System.out.println(response.getHits().getTotalHits());
        
        for (SearchHit hit : response.getHits()) {
            System.out.println(hit.getSourceAsString());
        }*/

        //????????????
        /* SearchRequest request = new SearchRequest();
        request.indices("user");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        FuzzyQueryBuilder queryBuilder = QueryBuilders.fuzzyQuery("name", "??????").fuzziness(Fuzziness.ONE);
        
        
        builder.query(queryBuilder);
        request.source(builder);
        
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(response.getHits()));
        System.out.println(response.getHits().getTotalHits());
        
        for (SearchHit hit : response.getHits()) {
            System.out.println(hit.getSourceAsString());
        }*/

        //????????????
        /*SearchRequest request = new SearchRequest();
        request.indices("user");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        //        //????????? and
        boolQueryBuilder.must(QueryBuilders.termsQuery("sex", "???"));
        //        TermsQueryBuilder termsQueryBuilder = QueryBuilders.termsQuery("name", "??????");
        
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<font color = 'red'>");
        highlightBuilder.postTags("</font>");
        highlightBuilder.field("sex");
        builder.highlighter(highlightBuilder);
        builder.query(boolQueryBuilder);
        request.source(builder);
        
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(response.getHits()));
        System.out.println(JSON.toJSONString(response));
        
        for (SearchHit hit : response.getHits()) {
            System.out.println(hit.getSourceAsString());
        }*/

        //??????????????????????????????
    /*    UserTest userTest = new UserTest();
        userTest.setName("??????");
        userTest.setSex("???");
        userTest.setAge(20);
        Field[] fields = userTest.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
            System.out.println(JSON.toJSONString(field.getAnnotations()));
            System.out.println(JSON.toJSONString(field.getAnnotatedType()));
            ReflectionUtils.makeAccessible(field);
            Object o = field.get(userTest);
            System.out.println(JSON.toJSONString(o));
        }*/

        //????????????
      /*  SearchRequest request = new SearchRequest();
        request.indices("user");
        SearchSourceBuilder builder = new SearchSourceBuilder();

        MaxAggregationBuilder aggregationBuilder = AggregationBuilders.max("maxAge").field("age");
        builder.aggregation(aggregationBuilder);

//        builder.query(aggregationBuilder);
        request.source(builder);

        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(response.getHits()));
        System.out.println(JSON.toJSONString(response));

        for (SearchHit hit : response.getHits()) {
            System.out.println(hit.getSourceAsString());
        }*/

        //????????????
        SearchRequest request = new SearchRequest();
        request.indices("user");
        SearchSourceBuilder builder = new SearchSourceBuilder();

        TermsAggregationBuilder aggregationBuilder = AggregationBuilders.terms("ageGroup").field("name");
        builder.aggregation(aggregationBuilder);

        request.source(builder);

        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(response.getHits()));
        System.out.println(JSON.toJSONString(response));

        for (SearchHit hit : response.getHits()) {
            System.out.println(hit.getSourceAsString());
        }

        restHighLevelClient.close();

    }

}
