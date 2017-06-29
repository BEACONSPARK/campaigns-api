package com.engageya.models.sqlserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * Created by DANIEL on 1/8/2017
 */
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "sqlserverEntityManagerFactory",
        transactionManagerRef = "sqlserverTransactionManager")
public class SqlserverDatasourceConfig {

    @Value("${sqlserverHibernateDialect}")
    private String sqlServerHibernateDialect;

    @Bean(name = "sqlserverTransactionManager")
    PlatformTransactionManager sqlserverTransactionManager() {
        return new JpaTransactionManager(sqlserverEntityManagerFactory().getObject());
    }

    @Bean(name = "sqlserverEntityManagerFactory")
    LocalContainerEntityManagerFactoryBean sqlserverEntityManagerFactory() {

        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(false);

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(sqlserverdatasource());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPackagesToScan(SqlserverDatasourceConfig.class.getPackage().getName());


        HashMap<String, String> properties = new HashMap<>();
        properties.put("hibernate.dialect", sqlServerHibernateDialect);
//        properties.put("hibernate.format_sql", "true");
//        properties.put("hibernate.generate_statistics", "true");

        factoryBean.setJpaPropertyMap(properties);

        return factoryBean;
    }

    @Bean(name = "sqlserverDataSource")
    @ConfigurationProperties(prefix = "spring.sqlserverdatasource")
    public DataSource sqlserverdatasource() {
        return DataSourceBuilder.create().build();
    }
}
