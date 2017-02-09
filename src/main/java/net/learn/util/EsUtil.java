package net.learn.util;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import com.alibaba.fastjson.JSON;

public class EsUtil  extends BaseService{
	public static void main(String[] args) throws Exception {
		TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
		        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
//		        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9200));
		System.out.println("什么鬼");

//		Map<String, Object> allMap = new HashMap<String, Object>();
//		allMap.put("code", 200);
//		allMap.put("msg", "success");
//		if (null != mapObject) {
//			allMap.put("data", mapObject);
//		}
//		String json = JSON.toJSONString(allMap,s).replaceAll(":null", ":\"\"");
//		
//		
//		
//		IndexResponse response = client.prepareIndex("twitter", "tweet")
//		        .setSource(json)
//		        .get();
//		
		
//		Settings settings = Settings.builder()
//		        .put("cluster.name", "elasticsearch").build();
//		TransportClient client = new PreBuiltTransportClient(settings);
	}
	
	
	
	
//	public void update(){
//		
//		Settings settings = Settings.builder()
//		        .put("cluster.name", "elasticsearch").build();
//		TransportClient client = new PreBuiltTransportClient(settings);
//		
//		UpdateRequest updateRequest = new UpdateRequest();
//		updateRequest.index("index");
//		updateRequest.type("type");
//		updateRequest.id("1");
//		updateRequest.doc(jsonBuilder()
//		        .startObject()
//		            .field("gender", "male")
//		        .endObject());
//		client.update(updateRequest).get();
//	}
}
