package es;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import net.learn.es.helper.IndexHelper;
import net.learn.es.helper.SearchHelper;
import net.learn.es.pojo.Book;

public class Test1  extends SearchHelper{

	public Class entityClass;

	@Test
	public void testGetAcccountById() throws UnknownHostException {

		TransportClient client = null;

		client = new PreBuiltTransportClient(Settings.EMPTY)
				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300))
				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));

		IndexHelper indexHelper = new IndexHelper.Build().index("index").type("type").build();

		 Book b = new Book();
		// b.setId("qweq");
		 b.setName("123123123131231");
		 b.setPrice(22L);
		 b.setVersion(22);
		 String source = JSON.toJSONString(b);
		/**
		 * 插入数据，单条
		 */
//		 IndexRequest request = indexHelper.document(source);// 插入
	     IndexRequest request = Requests.indexRequest("index").type("type").source(source);
		 IndexResponse response = client.index(request).actionGet(5, TimeUnit.SECONDS);
		 System.err.println(response.getId());

		/**
		 * 查询，根据id查询
		 */
//		GetRequest request1 = indexHelper.findDocumentById("AVjS6_Hsy43LiIn1egfr");// 查询
//		GetResponse response1 = client.get(request1).actionGet(5, TimeUnit.SECONDS);
//		System.out.println("source1=====" + response1.getSourceAsString());

		/**
		 * 删除数据，根据id
		 */

		// DeleteRequest drequest =
		// indexHelper.deleteDocumentById("AVjR--kQy43LiIn1egfX");
		// DeleteResponse dresponse = client.delete(drequest).actionGet(5,
		// TimeUnit.SECONDS);
		// System.out.println(dresponse.getId());

		/**
		 * 更新搜索数据，根据实体id
		 */

//		 UpdateRequest request = indexHelper.update("AVjS6_Hsy43LiIn1egfr",
//		 source);
		// UpdateResponse response = client.update(request).actionGet(5,
		// TimeUnit.SECONDS);
		// System.out.println(response.getId());

		/**
		 * 查询所有数据
		 */

		//SearchHelper searchHelper = new SearchHelper();
		SearchRequestBuilder builder = client.prepareSearch().setIndices("index").setTypes("type");
		//System.out.println("=================="+searchHelper.limit());
		builder.setFrom(0);//查询开始
		builder.setTerminateAfter(50);//结束位子
		builder.setSize(50);//查询多少条
////		 builder.internalBuilder(searchHelper.build());
//		SearchResponse sresponse = builder.execute().actionGet(10, TimeUnit.SECONDS);
//		SearchHits hits = sresponse.getHits();
//		int k = 0;
//		for (SearchHit hit : hits) {
//			String ssource = hit.getSourceAsString();
//			// jsons.add(source);
//			System.out.println("k=="+(k++)+ssource);
//		}
            
	 /**
	  * 前缀查询
	  */
//		 PrefixQueryBuilder builder1 = QueryBuilders.prefixQuery("name", "j");
//		 builder.setQuery(builder1);
//		 SearchResponse qsresponse = builder.execute().actionGet(10, TimeUnit.SECONDS);
//			SearchHits hits = qsresponse.getHits();
//			int k = 0;
//			for (SearchHit hit : hits) {
//				String ssource = hit.getSourceAsString();
//				// jsons.add(source);
//				System.out.println("k=="+(k++)+ssource);
//			}
	            
 
 		
		
		/**
		 * 	前缀查询呢
		 */
//		 MatchPhrasePrefixQueryBuilder query = QueryBuilders.matchPhrasePrefixQuery("name", "j");
//		 builder.setQuery(query);
//		 SearchResponse qsresponse = builder.execute().actionGet(10, TimeUnit.SECONDS);
//			SearchHits hits = qsresponse.getHits();
//			int k = 0;
//			for (SearchHit hit : hits) {
//				String ssource = hit.getSourceAsString();
//				// jsons.add(source);
//				System.out.println("k=="+(k++)+ssource);
//			}
// 

//		 CommonTermsQueryBuilder query = QueryBuilders.
//		 builder.setQuery(query);
//		 SearchResponse qsresponse = builder.execute().actionGet(10, TimeUnit.SECONDS);
//			SearchHits hits = qsresponse.getHits();
//			int k = 0;
//			for (SearchHit hit : hits) {
//				String ssource = hit.getSourceAsString();
//				// jsons.add(source);
//				System.out.println("k=="+(k++)+ssource);
//			}
// 
		String[] strs={"d"}; 
		QueryBuilder  query = QueryBuilders.termsQuery("name", strs);
		//query.field("name");
//		query.
		 builder.setQuery(query);
		 SearchResponse qsresponse = builder.execute().actionGet(10, TimeUnit.SECONDS);

		SearchHits hits = qsresponse.getHits();
		int k = 0;
		for (SearchHit hit : hits) {
			String ssource = hit.getSourceAsString();
			// jsons.add(source);
			System.out.println("k=="+(k++)+ssource);
		}
		client.close();

	}

}
