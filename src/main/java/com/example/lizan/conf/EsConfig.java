package com.example.lizan.conf;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class EsConfig {

	@Value("${elasticsearch.host}")
	private String address;

	private static final String schema = "http";

	@Bean
	public RestClientBuilder restClientBuilder() {
		HttpHost[] hosts = parseHttpHost();
		return RestClient.builder(hosts);
	}

	@Bean
	@DependsOn("restClientBuilder")
	public RestHighLevelClient restHighLevelClient(@Qualifier("restClientBuilder") RestClientBuilder restClientBuilder) {
		return new RestHighLevelClient(restClientBuilder);
	}



	private HttpHost[] parseHttpHost() {
		String[] hosts = address.split(";");
		HttpHost[] httpHosts = new HttpHost[hosts.length];
		for (int i = 0; i < hosts.length; i++) {
			String[] address = hosts[i].split(":");
			if (address.length == 2) {
				String ip = address[0];
				int port = Integer.parseInt(address[1]);
				httpHosts[i] = new HttpHost(ip, port, schema);
			}
		}
		return httpHosts;
	}
}
