package com.nys.demo.config;

import org.neo4j.ogm.config.ClasspathConfigurationSource;
import org.neo4j.ogm.config.ConfigurationSource;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author NingYaShu
 * @version V1.0
 * @program: spring_neo4jTest
 * @Package com.nys.demo.config
 * @Description: TODO
 * @date 2018/7/19 下午9:22
 */

@Configuration
@EnableNeo4jRepositories("com.nys.demo.respository")
@EnableTransactionManagement
public class Neo4jConfig {//extends Neo4jConfiguration {

    @Bean
    public org.neo4j.ogm.config.Configuration configuration(){
        ConfigurationSource properties = new ClasspathConfigurationSource("ogm.properties");
        return new org.neo4j.ogm.config.Configuration.Builder(properties).build();
    }

    @Bean
    public SessionFactory sessionFactory() {

        //return new SessionFactory(getConfiguration(),"com.nys.demo.entity");
        return new SessionFactory(configuration(),"com.nys.demo.entity");
    }

    @Bean
    public Neo4jTransactionManager transactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }
}
