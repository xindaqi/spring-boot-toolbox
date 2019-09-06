package high.level.rest;


import com.sun.org.apache.xml.internal.security.Init;
import org.apache.http.HttpHost;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.*;
import org.elasticsearch.action.support.replication.ReplicationResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;


import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.Scroll;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.util.*;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

public class HighAPITestV1 {
    public boolean existsIndex(){
        try(RestHighLevelClient client = InitDemo.getClient()){
            GetIndexRequest request = new GetIndexRequest();
            request.indices("twitter");
            boolean exists = client.indices().exists(request);
            return exists;
        }catch (IOException e){
            return false;
        }
    }



    public boolean createIndex(){
        try (RestHighLevelClient client = InitDemo.getClient()){
            // creating index with name twitter
            CreateIndexRequest request = new CreateIndexRequest("twitter");
            // setting for shards and replication
            request.settings(Settings.builder()
                    // shards:分片,replicas:副本
                    .put("index.number_of_shards", 3)
                    .put("index.number_of_replicas", 2));
            // mapping:
//        request.mapping("info",
//                "{\n"+
//                        "\"info\":{\n"+
//                        "\"properties\":{\n"+
//                        "\"message\":{\n"+
//                        "\"type\":\"text\"\n"+
//                        "}\n"+
//                        "}\n"+
//                        "}\n"+
//                        "}",
//                        XContentType.JSON);
            Map properties = new HashMap();
            properties.put("name", new HashMap(){
                {
                    put("type", "text");
                }
            });
            properties.put("address", new HashMap(){
                {
                    put("type", "text");
                }
            });

            Map jsonMap = new HashMap();
            Map mapping = new HashMap();
            // properties:type:type-name, e.g:type:text
            mapping.put("properties", properties);
            // type-name: info
            jsonMap.put("info", mapping);
            request.mapping("info", jsonMap);

//        CreateIndexResponse createIndexResponse = client.indices().create(request);
            CreateIndexResponse createIndexResponse = client.indices()
                    .create(request);
//        IndexResponse indexResponse = client.index(request);
            boolean acknowledged = createIndexResponse.isAcknowledged();
            return acknowledged;

        }catch(IOException e){
            e.printStackTrace();
            return false;
        }

    }

    public String insertData(){
        try(RestHighLevelClient client = InitDemo.getClient()){
//            IndexRequest request = new IndexRequest("twitter", "info", "1");
            Map<String, Object> jsonMap = new HashMap<>();
            String insertStatus="test";
            jsonMap.put("name", "小三三");
            jsonMap.put("address", "沈阳");
            IndexRequest request = new IndexRequest("twitter", "info", "3")
                                                .source(jsonMap);

            IndexResponse indexResponse = client.index(request);

            String index = indexResponse.getIndex();
            String type = indexResponse.getType();
            String id = indexResponse.getId();
            long version = indexResponse.getVersion();
            if (indexResponse.getResult() == DocWriteResponse.Result.CREATED){
                insertStatus = "created data";
            } else if (indexResponse.getResult() == DocWriteResponse.Result.UPDATED){
                insertStatus = "updated data";
            }
            return insertStatus;
        }catch (IOException e){
            return "insert error";
        }
    }



    public boolean delIndex(){
        try(RestHighLevelClient client = InitDemo.getClient()){
            DeleteIndexRequest request = new DeleteIndexRequest("twitter");
            DeleteIndexResponse deleteIndexResponse = client.indices().delete(request);
            boolean acknowledged = deleteIndexResponse.isAcknowledged();
            return acknowledged;
        }catch (IOException e){
            return false;
        }

    }

    public String updateData(){
        try(RestHighLevelClient client = InitDemo.getClient()){
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("name", "小黑嘿嘿");
            jsonMap.put("address", "沈阳");
            UpdateRequest request = new UpdateRequest("twitter", "info", "2")
                                        .doc(jsonMap);
            UpdateResponse updateResponse = client.update(request);
            String index = updateResponse.getIndex();
            String type = updateResponse.getType();
            String id = updateResponse.getId();
            long version = updateResponse.getVersion();
            String updateStatus="test";
            if (updateResponse.getResult() == DocWriteResponse.Result.CREATED){
                updateStatus = "created data";

            }else if (updateResponse.getResult() == DocWriteResponse.Result.UPDATED){
                updateStatus = "update data";

            }else if (updateResponse.getResult() == DocWriteResponse.Result.DELETED){
                updateStatus = "delete data";

            }else if (updateResponse.getResult() == DocWriteResponse.Result.NOOP){
                updateStatus = "no operation";
            }

            return updateStatus;

        }catch (IOException e){
            return "update error";
        }
    }

    public String searchData(){
        try(RestHighLevelClient client = InitDemo.getClient()){
            // index and type
            SearchRequest searchRequest = new SearchRequest("twitter");
            searchRequest.types("info");

            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            // query in certain term
//            searchSourceBuilder.query(QueryBuilders.termQuery("name", "小黄"));
            searchSourceBuilder.query(matchQuery("name", "小三三"));
            // query all
//            searchSourceBuilder.query(QueryBuilders.matchAllQuery());
            // show query number
//            searchSourceBuilder.from(0);
            searchSourceBuilder.size(1);
            searchRequest.source(searchSourceBuilder);


            SearchResponse searchResponse = client.search(searchRequest);
            RestStatus status = searchResponse.status();

            SearchHits hits = searchResponse.getHits();
            long totalHits = hits.getTotalHits();
            float maxScore = hits.getMaxScore();

            SearchHit[] searchHits = hits.getHits();
            for(SearchHit hit :searchHits){
                System.out.println("hit: "+hit);
                String index = hit.getIndex();
                String type = hit.getType();
                String id = hit.getId();
                float score = hit.getScore();
                String source = hit.getSourceAsString();
                System.out.println("index:"+index+","+"source:"+source);
            }

            return "search result";
        }catch (IOException e){
            return "search error";
        }
    }

    public boolean searchScrollData(){
        try(RestHighLevelClient client = InitDemo.getClient()){
            final Scroll scroll = new Scroll(TimeValue.timeValueMinutes(1L));
            // index and type
            SearchRequest searchRequest = new SearchRequest("twitter");
            searchRequest.scroll(scroll);
//            searchRequest.types("info");
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            searchSourceBuilder.query(matchQuery("name", "小三三"));
            searchSourceBuilder.size(2);
            searchRequest.source(searchSourceBuilder);

            searchRequest.scroll(TimeValue.timeValueMinutes(1L));

            SearchResponse searchResponse = client.search(searchRequest);
            String scrollId = searchResponse.getScrollId();
            SearchHit[] searchHits = searchResponse.getHits().getHits();

            while(searchHits != null && searchHits.length > 0){
                SearchScrollRequest scrollRequest = new SearchScrollRequest(scrollId);
                scrollRequest.scroll(scroll);
                searchResponse = client.searchScroll(scrollRequest);
                scrollId = searchResponse.getScrollId();
                searchHits = searchResponse.getHits().getHits();
            }

            ClearScrollRequest clearScrollRequest = new ClearScrollRequest();
            clearScrollRequest.addScrollId(scrollId);
            ClearScrollResponse clearScrollResponse = client.clearScroll(clearScrollRequest);
            boolean succeeded = clearScrollResponse.isSucceeded();
//            MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("name", "小三三");
//            QueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", "小三三");
            return succeeded;
        }catch (IOException e){
            return false;
        }
    }



//    public static void main(String[] args) {
//        System.out.println("Starting create index...");
//        // initialize object
//        HighAPITestV1 indexOperations = new HighAPITestV1();
//        // index exists or not
//        boolean existsIndex;
//        existsIndex = indexOperations.existsIndex();
//        if(existsIndex){
//            System.out.println("Index already exists, please change index name and try again!");
//        }else{
//            // create index
//            boolean createIndexStatus;
//            createIndexStatus = indexOperations.createIndex();
//            System.out.println("Create index status: "+createIndexStatus);
//        }
//
//        // delete index
////        boolean delIndexStatus;
////        delIndexStatus = indexOperations.delIndex();
////        System.out.println("Del index status: "+ delIndexStatus);
////        // insert data
////        String insertStatus;
////        insertStatus = indexOperations.insertData();
////        System.out.println("Insert data status: "+insertStatus);
//
////        // update data
////        String updateStatus;
////        updateStatus = indexOperations.updateData();
////        System.out.println("Update data status: "+updateStatus);
//        // search data
//        String searchStatus;
//        searchStatus = indexOperations.searchData();
//        System.out.println("Search data status: "+ searchStatus);
//
//    }
}


