package cn.edu.lingnan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: chen_man_cheng
 * @Description: //TODO
 * @Date: Create in 17:16 2020/6/18
 */
@SpringBootApplication
@EnableEurekaServer //注明这是Eureka注册中心
public class EurekaServerApp {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApp.class,args);
    }
}
