package com.spring.mvc.architect.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

import java.util.Properties;

@EnableWebMvc
@EnableTransactionManagement
public class myConfig {
    @Bean
    public DataSource dataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/my_db?allowPublicKeyRetrieval=true");
            //dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/my_db?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=UTF-8");

            //dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/my_db?useSSL=false");
            dataSource.setUser("bestuser");
            dataSource.setPassword("Bestuser2022+");

        } catch (PropertyVetoException e){
            e.printStackTrace();
        }
        return dataSource;
    }
    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.myspring.rest.entity");

        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        hibernateProperties.setProperty("hibernate.show.dialect","true");

        hibernateProperties.setProperty("testOnBorrow","true");
        hibernateProperties.setProperty("validationQuery","select 1");

        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }
    @Bean
    public HibernateTransactionManager transactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());

        return transactionManager;
    }

//    @Bean
//    public GroupedOpenApi publicUserApi() {
//        return GroupedOpenApi.builder()
//                .group("Users")
//                .pathsToMatch("/users/**")
//                .build();
//    }

//    @Bean
//    public OpenAPI customOpenApi(@Value("${application-description}")String appDescription,
//                                 @Value("${application-version}")String appVersion) {
//        return new OpenAPI().info(new Info().title("Application API")
//                        .version(appVersion)
//                        .description(appDescription)
//                        .license(new License().name("Apache 2.0")
//                                .url("http://springdoc.org"))
//                        .contact(new Contact().name("username")
//                                .email("test@gmail.com")))
//                .servers(List.of(new Server().url("http://localhost:8080")
//                                .description("Dev service"),
//                        new Server().url("http://localhost:8082")
//                                .description("Beta service")));
//    }

}
