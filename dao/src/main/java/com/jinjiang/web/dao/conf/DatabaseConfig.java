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
public class DatabaseConfig {

     //   private static final Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);

        @Value("${jdbc.driver}")
        private String jdbcDriver;

        @Value("${db.url}")
        private String dbUrl;

        @Value("${db.username}")
        private String username;

        @Value("${db.password}")
        private String password;

        @Value("${db.maxtotal}")
        private String maxTotal;

        @Value("${db.minidle}")
        private String minIdle;

        @Value("${db.maxidle}")
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

