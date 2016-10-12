package com.jinjiang.web.dao.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by W on 2016/8/25.
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
     //   private static final Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);

        @Value("${jdbc.driver}")//驱动
        private String jdbcDriver;

        @Value("${db.url}")//数据库连接
        private String dbUrl;

        @Value("${db.username}")//用户名
        private String username;

        @Value("${db.password}")//密码
        private String password;

        @Value("${db.maxtotal}")//最大活动连接数
        private String maxTotal;

        @Value("${db.minidle}")//最小连接数
        private String minIdle;

        @Value("${db.maxidle}")//最大连接数
        private String maxIdle;

        @Bean(destroyMethod = "close")
        public DataSource dataSource() {
   //         logger.info("mysql url:"+dbUrl);
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName(jdbcDriver);
            dataSource.setUrl(dbUrl);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            dataSource.setMaxTotal(Integer.parseInt(maxTotal));
            dataSource.setMinIdle(Integer.parseInt(minIdle));
            dataSource.setMaxIdle(Integer.parseInt(maxIdle));
            return dataSource;
        }

        @Bean
        public DataSourceTransactionManager txManager() {
            return new DataSourceTransactionManager(dataSource());
        }

        @Bean
        public SqlSessionFactory sqlSessionFactory() throws Exception {
            SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
            sessionFactory.setDataSource(dataSource());
            return sessionFactory.getObject();
        }
    }

