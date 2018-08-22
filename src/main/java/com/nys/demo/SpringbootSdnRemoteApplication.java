package com.nys.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author NingYaShu
 * @version V1.0
 * @program: spring_neo4jTest
 * @Package com.nys.demo
 * @Description: TODO
 * @date 2018/7/20 下午4:24
 */

@SpringBootApplication
@EntityScan(basePackages = "com.nys")
public class SpringbootSdnRemoteApplication {
    public static void main(String[] args){
        SpringApplication.run(SpringbootSdnRemoteApplication.class, args);
    }
}
