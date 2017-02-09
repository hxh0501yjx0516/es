package es;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.PrefixQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import net.learn.es.pojo.Book;

public class Test2 {

	@Test
	public void go() throws UnknownHostException{
		TransportClient client = null;
		client = new PreBuiltTransportClient(Settings.EMPTY).
				addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),9300));
		
		
		/**
		 * 插入数据，单条插入
		 */
		
		Book b = new Book();
		b.setName("j领导人");
		b.setPrice(22L);
		b.setVersion(22L);
		String source = JSON.toJSONString(b);
//		IndexRequest request = Requests.indexRequest("index").type("type").source(source);
//		IndexResponse response = client.index(request).actionGet(5, TimeUnit.SECONDS);
//		System.err.println(response.getId());
		
		/**
		 * 查询，根据id查询
		 * 
		 */
//		GetRequest request = Requests.getRequest("index").type("type").id("AVkVDiBKWzq84E0gl_p-");
//		GetResponse response = client.get(request).actionGet(5,TimeUnit.SECONDS);
//		System.err.println(response.getSourceAsString());
		
		/**
		 * 更改数据，根据id
		 */
//		UpdateRequest  request = new UpdateRequest("index","type","AVkVDiBKWzq84E0gl_p-").doc(source);
//		UpdateResponse response = client.update(request).actionGet(5, TimeUnit.SECONDS);
//	    System.err.println(response.getGetResult());
		
		/**
		 * 删除数据，根据id
		 */
//		DeleteRequest request = Requests.deleteRequest("index").type("type").id("AVkVDiBKWzq84E0gl_p-");
//		DeleteResponse response = client.delete(request).actionGet(5, TimeUnit.SECONDS);
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
//		int i = 0 ;
//		for(SearchHit hit: hits){
//		
//			System.err.println("i="+(i ++)+hit.getSourceAsString());
//		}
		
		/**
		 * 前缀查询
		 */
		SearchRequestBuilder builder = client.prepareSearch().setIndices("index").setTypes("type");
		PrefixQueryBuilder prefix = QueryBuilders.prefixQuery("name", "j");
		builder.setQuery(prefix);
		builder.setFrom(0);
		builder.setTerminateAfter(50);
		builder.setSize(50);
		SearchResponse response = builder.execute().actionGet(5, TimeUnit.SECONDS);
		SearchHits hits  =response.getHits();
		int i = 1;
		for(SearchHit hit:hits){
			
			
			System.err.println((i++)+hit.getSourceAsString());
		}
//		
		
		
		
	}
}
