package com.gch.druidmodule1.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by Administrator on 2018/1/15.
 */
@Configuration
@MapperScan(basePackages = "com.gch.druidmodule1.mapper",sqlSessionTemplateRef = "SqlSessionTemplateOne")
public class DataSourceOneConfig {

    @ConfigurationProperties(prefix = "spring.datasource.druid.datasource1")
    @Bean(name = "datasource1")
    @Primary
    public DataSource dataSource1() throws SQLException {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "sessionFactory1")
    @Primary
    public SqlSessionFactory sqlSessionFactory1(@Qualifier(value = "datasource1") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "transactionManager1")
    @Primary
    public DataSourceTransactionManager dataSourceTransactionManager1(@Qualifier("datasource1") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "SqlSessionTemplateOne")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("sessionFactory1") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
