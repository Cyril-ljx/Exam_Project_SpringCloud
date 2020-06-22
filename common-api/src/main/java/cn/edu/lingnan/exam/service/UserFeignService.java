package cn.edu.lingnan.exam.service;

import cn.edu.lingnan.exam.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient("provider-user-8002")
public interface UserFeignService {

    @GetMapping("/user/queryAll")
    Object queryAll();
    @PostMapping("/student/login")
    User loginByUser(@RequestParam("username")String username, @RequestParam("password") String password);
}
