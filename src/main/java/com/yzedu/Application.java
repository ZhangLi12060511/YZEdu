package com.yzedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author zhangbenben on 2018/5/25 0025
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Application extends SpringBootServletInitializer{
    public  static void main(String[] args){
        SpringApplication.run(Application.class,args);

    }

}
