package es;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.PrefixQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import net.learn.es.pojo.Book;

public class Test3 {

	@Test
	public void elasticsearch() throws UnknownHostException{
		TransportClient client = null;
		client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),9300));
		Book b = new Book();
		b.setName("莫可波罗");
		b.setPrice(22L);
		b.setVersion(22L);
		String source = JSON.toJSONString(b);
		/**
		 * 插入数据
		 */
//		IndexRequest request = Requests.indexRequest("index").type("type").source(source);
//		IndexResponse response = client.index(request).actionGet(5,TimeUnit.SECONDS);
//		System.err.println(response.getId());
		
		/**
		 * 查询数据
		 */
//		GetRequest request = Requests.getRequest("index").type("type").id("AVk-Pbcno11GH-QQXFJm");
//		GetResponse response = client.get(request).actionGet(5, TimeUnit.SECONDS);
//		String result = response.getSourceAsString();
//		System.err.println(result);
		
		/**
		 * 删除
		 */
//		DeleteRequest request = Requests.deleteRequest("index").type("type").id("AVk-Pbcno11GH-QQXFJm");
//		DeleteResponse response = client.delete(request).actionGet(5, TimeUnit.SECONDS);
//		System.err.println(response.getId());
		/**
		 * 更新数据
		 */
//		UpdateRequest request = new UpdateRequest("index", "type", "AVk-Pbcno11GH-QQXFJm").doc(source);
//		UpdateResponse response = client.update(request).actionGet(5, TimeUnit.SECONDS);
//		System.err.println(response.getId());
		
		/**
		 * 查询所有数据
		 */
//		SearchRequestBuilder builder = client.prepareSearch().setIndices("index").setTypes("type");
//		builder.setFrom(0);
//		builder.setTerminateAfter(50);
//		builder.setSize(50);
//		SearchResponse response = builder.execute().actionGet(5, TimeUnit.SECONDS);
//		SearchHits hits = response.getHits();
//		for(SearchHit hit :hits){
//			System.err.println(hit.getSourceAsString());
//			
//		}
		
		/**
		 * 根据名字插叙你数据
		 */
		SearchRequestBuilder builder = client.prepareSearch().setIndices("index").setTypes("type");
	//	QueryStringQueryBuilder query = QueryBuilders.queryStringQuery("3");
	//	builder.setQuery(query);
		builder.setFrom(0);
		builder.setTerminateAfter(50);
		builder.setSize(50);
		builder.setQuery(QueryBuilders.rangeQuery("name"));
		SearchResponse response =    builder.execute().actionGet(5, TimeUnit.SECONDS);
		SearchHits hits = response.getHits();
		for(SearchHit hit : hits){
			System.err.println(hit.getSourceAsString());
		}
	
		
	}
}
