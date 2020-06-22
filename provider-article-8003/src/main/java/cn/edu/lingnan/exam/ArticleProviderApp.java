package cn.edu.lingnan.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: chen_man_cheng
 * @Description: //TODO
 * @Date: Create in 21:34 2020/6/20
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ArticleProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(ArticleProviderApp.class,args);
    }
}
