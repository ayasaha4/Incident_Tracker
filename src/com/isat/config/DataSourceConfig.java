package com.isat.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.isat.service.PropertyService;

@Configuration
public class DataSourceConfig {
	
	private static final Logger logger = Logger.getLogger(DataSourceConfig.class);

	@Autowired
	PropertyService propertyService;

	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(propertyService.readValues("eai.driverClassName"));
		driverManagerDataSource.setUrl(propertyService.readValues("eai.url"));
		driverManagerDataSource.setUsername(propertyService.readValues("eai.username"));
		driverManagerDataSource.setPassword(propertyService.readValues("eai.password"));
		return driverManagerDataSource;
	}

}