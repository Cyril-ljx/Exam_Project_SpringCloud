package cn.edu.lingnan.exam.service;

import cn.edu.lingnan.exam.entity.User;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: chen_man_cheng
 * @Description: //TODO
 * @Date: Create in 0:48 2020/6/19
 */
@Component
@FeignClient(value = "provider-login")
public interface LoginFeignService {

    @RequestMapping("/login_do")
    String loginDo(@RequestBody User user);

    @RequestMapping("admin/logout")
    String invalidate(Session session);
}
