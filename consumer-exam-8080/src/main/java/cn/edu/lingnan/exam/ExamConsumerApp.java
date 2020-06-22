package cn.edu.lingnan.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: chen_man_cheng
 * @Description: //TODO
 * @Date: Create in 17:35 2020/6/18
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients //支持feign
public class ExamConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(ExamConsumerApp.class,args);
    }
}
