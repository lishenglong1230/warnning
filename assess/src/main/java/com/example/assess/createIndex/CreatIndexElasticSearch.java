package com.example.assess.createIndex;

import com.alibaba.fastjson.JSON;
import com.example.assess.Es.ESClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@Component
public class CreatIndexElasticSearch {
    ObjectMapper mapper=new ObjectMapper();
    RestHighLevelClient client= ESClient.getClient();
    String index="assess";
/*    @Autowired
    private SelectRecruitment selectRecruitment;*/
    //每天凌晨1点执行一次
@Scheduled(cron = "0 0 23 * * ?")

    @PostConstruct()
    public void createIndex() throws IOException {
        //准备关于索引的seetings
        Settings.Builder settings=Settings.builder()
                .put("number_of_shards",10)
                .put("number_of_replicas",1);

        //2准备关于索引的结构mappings
        XContentBuilder mappings= JsonXContent.contentBuilder()
                .startObject()
                .startObject("properties")
                .startObject("model")
                .field("type","text")
                .endObject()
                .startObject("date")
                .field("type","keyword")
                .endObject()
                .startObject("place")
                .field("type","text")
                .endObject()
                .startObject("kilometers")
                .field("type","text")
                .endObject()
                .startObject("telephone")
                .field("type","keyword")
                .endObject()
                .startObject("code")
                .field("type","keyword")
                .endObject()
                .startObject("invoice")
                .field("type","keyword")
                .endObject()
                .startObject("certificate")
                .field("type","keyword")
                .endObject()
                .startObject("accidentIdentification")
                .field("type","keyword")
                .endObject()
                .startObject("maintenanceList")
                .field("type","keyword")
                .endObject()
                .endObject()
                .endObject();

        //3、将settings和mappings封装到一个Request对象
        CreateIndexRequest request = new CreateIndexRequest(index)
                .settings(settings)
                .mapping(mappings);
        //4、通过client对象ES并执行创建索引
        CreateIndexResponse response=client.indices().create(request, RequestOptions.DEFAULT);
    }
/*    @PostConstruct()
    public void CreateIndex() throws IOException {
        BulkRequest bulkRequest=new BulkRequest();
        bulkRequest.timeout("30s");
        List<Recruit> byUserId = selectRecruitment.selectrecruitment();
        for (int i=0;i< byUserId.size();i++){
            bulkRequest.add(
                    new IndexRequest(index)
                            .id(""+(i+1))
                            .source(JSON.toJSONString(byUserId.get(i)), XContentType.JSON));
        }
        BulkResponse bulkResponse=client.bulk(bulkRequest,RequestOptions.DEFAULT);

        System.out.println(bulkResponse.hasFailures());

    }*/
}
