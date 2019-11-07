package com.gch.druidmodule2.config;

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
 * Created by Administrator on 2028/2/25.
 */
@Configuration
@MapperScan(basePackages = "com.gch.druidmodule2.mapper",sqlSessionTemplateRef = "SqlSessionTemplateTow")
public class DataSourceTowConfig {

    @ConfigurationProperties(prefix = "spring.datasource.druid.datasource2")
    @Bean(name = "datasource2")
    public DataSource dataSource2() throws SQLException {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "sessionFactory2")
    public SqlSessionFactory sqlSessionFactory2(@Qualifier(value = "datasource2") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "transactionManager2")
    public DataSourceTransactionManager dataSourceTransactionManager2(@Qualifier("datasource2") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "SqlSessionTemplateTow")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("sessionFactory2") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
