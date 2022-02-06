package com.example.assess;

import com.example.assess.Es.ESClient;
import com.example.assess.entity.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Demo {
    ObjectMapper mapper=new ObjectMapper();
    RestHighLevelClient client= ESClient.getClient();
    String index="assess";
    String type="man";

    @Test
    public void createDoc() throws IOException {
        //准备json数据
        Person person=new Person(1,"张三",23,new Date());
        String json = mapper.writeValueAsString(person);
        //准备一个request对象(手动指定id)
        IndexRequest request=new IndexRequest(index,type,person.getId().toString());
        request.source(json, XContentType.JSON);

        //通过client对象执行添加
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        //输出返回结果
        System.out.println(response.getResult().toString());
    }
    @Test
    public void updateDoc() throws IOException {
        //创建一个Map,指定需要修改的内容
        Map<String,Object> doc=new HashMap<>();
        doc.put("name","张大三");
        String docId="1";

        //创建client对象执行
        UpdateRequest request=new UpdateRequest(index,type,docId);
        request.doc(doc);

        //通过client对象执行
        UpdateResponse update =client.update(request,RequestOptions.DEFAULT);

        System.out.println(update.getResult().toString());
    }

    @Test
    public  void deleteDoc() throws IOException {

        DeleteRequest request=new DeleteRequest(index,type,"1");

        DeleteResponse resp=client.delete(request,RequestOptions.DEFAULT);

        System.out.println(resp.getResult().toString());
    }

    @Test
   /* 批量添加数据*/
    public  void  add() throws Exception {
        Person p1=new Person(1,"张三",23,new Date());
        Person p2=new Person(2,"李四",23,new Date());
        Person p3=new Person(3,"王五",23,new Date());

        String json1=mapper.writeValueAsString(p1);
        System.out.println(p1+"=============");
        String json2=mapper.writeValueAsString(p2);
        String json3=mapper.writeValueAsString(p3);

        BulkRequest request=new BulkRequest();
        request.add(new IndexRequest(index,type,p1.getId().toString()).source(json1,XContentType.JSON));
        request.add(new IndexRequest(index,type,p2.getId().toString()).source(json2,XContentType.JSON));
        request.add(new IndexRequest(index,type,p3.getId().toString()).source(json3,XContentType.JSON));

        BulkResponse resp = client.bulk(request, RequestOptions.DEFAULT);

        System.out.println(resp.toString());
    }

    @Test
  /*  批量删除数据*/
    public  void DeleteDoc() throws Exception {
//封装对象
        BulkRequest request=new BulkRequest();

        request.add(new DeleteRequest(index,type,"1"));
        request.add(new DeleteRequest(index,type,"2"));
        request.add(new DeleteRequest(index,type,"3"));

        BulkResponse resp=client.bulk(request,RequestOptions.DEFAULT);

        System.out.println(resp);
    }
}
