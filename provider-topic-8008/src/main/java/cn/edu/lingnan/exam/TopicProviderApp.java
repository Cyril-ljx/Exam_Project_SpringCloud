package cn.edu.lingnan.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //开启注册客户端
@EnableCircuitBreaker //开启服务熔断
public class TopicProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(TopicProviderApp.class,args);
    }
}
