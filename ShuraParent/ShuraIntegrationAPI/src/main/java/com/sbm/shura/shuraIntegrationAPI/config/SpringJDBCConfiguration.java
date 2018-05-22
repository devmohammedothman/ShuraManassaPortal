package com.sbm.shura.shuraIntegrationAPI.config;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SpringJDBCConfiguration {
   @Bean
   public DataSource dataSource() {
       DriverManagerDataSource dataSource = new DriverManagerDataSource();
       dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
       dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");//change url
       dataSource.setUsername("shura");//change userid
       dataSource.setPassword("java");//change pwd
       
       return dataSource;
   }

}