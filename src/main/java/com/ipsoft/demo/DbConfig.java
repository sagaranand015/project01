package com.ipsoft.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "authEntityManager",
        transactionManagerRef = "authTransactionManager",
        basePackages = "com.ipsoft.demo")
public class DbConfig {
    @Autowired
    private Environment env;


    @Bean
    public PlatformTransactionManager authTransactionManager() {
        return new JpaTransactionManager(authEntityManager().getObject());
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean authEntityManager() {
        final HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(authDataSource());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPackagesToScan(DbConfig.class.getPackage().getName() + ".models");

        /*final HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        factoryBean.setJpaPropertyMap(properties);*/

        return factoryBean;
    }

    @Bean
    public DataSource authDataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("db.jdbc.url"));
        dataSource.setUsername(env.getProperty("db.jdbc.user"));
        dataSource.setPassword(env.getProperty("db.jdbc.pass"));
        return dataSource;
    }


}