package cn.edu.lingnan.exam.controller;



import cn.edu.lingnan.exam.entity.User;
import cn.edu.lingnan.exam.service.UserFeignService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
@RequestMapping("user/feign")
public class UserFeignController {

    @Resource
    private UserFeignService userFeignService;
    @RequestMapping("queryAll")
    @ResponseBody
    public Object queryAll(){
        return userFeignService.queryAll();
    }


    @RequestMapping("toLogin")
    public String toLogin(){
        return "admin/login";
    }

/*
    @PostMapping("login")
    public String login(String username, String password, Model model){
        User bean = userFeignService.login(username, password);
        model.addAttribute("loginusername","username");
        model.addAttribute("loginpassword","password");
        if(bean == null){
            return "admin/login";
        }
        return "admin/index";
    }
*/





}
