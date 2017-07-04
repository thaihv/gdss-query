package com.uitgis.ubps.gdssquery;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Slf4j
@EnableAutoConfiguration(exclude = {DataSourceTransactionManagerAutoConfiguration.class})
@EnableElasticsearchRepositories(basePackages = "com.uitgis.ubps.gdssquery.searchrepository")
@EnableJpaRepositories(basePackages = "com.uitgis.ubps.gdssquery.repository")
public class QueryApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(QueryApplication.class, args);
		log.info("Lombok is a good thing");
	}
}
