package com.jinjiang.web.back.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by W on 2016/8/25.
 */
@Configuration
@ComponentScan(basePackages = {"com.jinjiang.web.back","com.jinjiang.web.back.controller","com.jinjiang.web.service","com.jinjiang.web.bean"},excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)})
@MapperScan("com.jinjiang.web.dao.mapper")
public class RootConfig {
}
