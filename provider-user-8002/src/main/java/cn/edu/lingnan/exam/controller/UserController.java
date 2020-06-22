package cn.edu.lingnan.exam.controller;


import cn.edu.lingnan.exam.entity.User;
import cn.edu.lingnan.exam.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @PostMapping("login")
    @ResponseBody
    public User login(String username, String password){
        User bean = userService.loginByUser(username,password);
        return bean;
    }


}
