package cn.edu.lingnan.exam.controller.client;

import cn.edu.lingnan.exam.Util.MD5Util;
import cn.edu.lingnan.exam.entity.User;
import cn.edu.lingnan.exam.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-06-15 17:21:06
 */
@Controller
@RequestMapping("user")
public class ClientUserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     *
     * @return 单条数据
     */
//    @GetMapping("selectOne")
//    public User selectOne(Integer id) {
//        return this.userService.queryById(id);
//    }

    @RequestMapping("/userinfoView")
    public String userInfoView(){

        return "client/html/userinfo";
    }

    @RequestMapping("/register")
    public String register(){
        return "admin/user/userRegister";
    }


    @ResponseBody
    @RequestMapping("/register_do")
    public String registerDo(@RequestBody User user, HttpServletRequest request) {
        String vrifyCode = (String) request.getSession().getAttribute("vrifyCode");
        if (user.getId() == null) {
            String password = MD5Util.string2MD5(user.getPassword());
            user.setPassword(password);
            User users = userService.insert(user);
            return "successInsert";
        } else if (!vrifyCode.equals(user.getVercode())){
            return "vrifyCodeErroe";
        } else {
            return "userExit";
        }
    }

    //注销处理
    @RequestMapping("/cancel")
    public String invalidate(HttpSession session) {
        session.invalidate();
        return "client/html/index";
    }

}