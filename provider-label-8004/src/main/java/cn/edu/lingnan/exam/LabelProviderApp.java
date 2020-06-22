package cn.edu.lingnan.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: chen_man_cheng
 * @Description: //TODO
 * @Date: Create in 0:29 2020/6/21
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LabelProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(LabelProviderApp.class,args);
    }
}
