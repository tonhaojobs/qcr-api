package br.com.antonio.qcrapi.configuration;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"local"})
public class DatabaseLocalConfig {
	
	@Primary
	@Bean(name = "projetoDataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource esocialDataSource() {
		return DataSourceBuilder.create().build();
	}

}