package com.bj58.spring.di.config;


import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import java.io.File;


@Configuration
public class PropertyConfig {
       @Bean
        public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(){
            PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
            FileSystemResource   mysqlConfig = new FileSystemResource(new File(""));
            return configurer;
       }
}
