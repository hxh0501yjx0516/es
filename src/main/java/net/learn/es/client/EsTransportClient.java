package net.learn.es.client;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author shoumiao_yao
 * @date 2016-09-23
 */
@Component(value = "transportClient")
public class EsTransportClient implements EsClient {
    @Value("${elasticsearch.host}")
    private String host;
    @Value("${elasticsearch.port}")
    private Integer port;
    @Value("${cluster.name}")
    private String clusterName;
    @Value("${client.transport.sniff}")
    private Boolean clientTransportSniff;
    private TransportClient client;


    @PostConstruct
    public Client init() throws UnknownHostException {
        Settings.Builder build = Settings.builder();
        if (StringUtils.isNotEmpty(clusterName)) {
            build.put("cluster.name", clusterName);
        }
        if (clientTransportSniff != null) {
            build.put("client.transport.sniff", clientTransportSniff);
        }
//        Settings settings = build.build();
//        this.client = TransportClient.builder().settings(settings).build();
//        client.addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress(host, port)));
        
        
          client = new PreBuiltTransportClient(Settings.EMPTY)
		        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        return client;
    }

    public Client getClient() {
        return client;
    }
    
  
}
