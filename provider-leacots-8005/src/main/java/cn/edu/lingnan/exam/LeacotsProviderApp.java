package cn.edu.lingnan.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: chen_man_cheng
 * @Description: //TODO
 * @Date: Create in 12:52 2020/6/20
 */
@SpringBootApplication
@EnableDiscoveryClient //开启注册客户端
@EnableCircuitBreaker //开启服务熔断
public class LeacotsProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(LeacotsProviderApp.class,args);
    }
}
