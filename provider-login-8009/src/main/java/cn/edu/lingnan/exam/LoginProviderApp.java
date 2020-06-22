package cn.edu.lingnan.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: chen_man_cheng
 * @Description: //TODO
 * @Date: Create in 1:18 2020/6/19
 */
@SpringBootApplication
@EnableDiscoveryClient //开启注册客户端
@EnableCircuitBreaker //开启服务熔断
public class LoginProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(LoginProviderApp.class,args);
    }
}
