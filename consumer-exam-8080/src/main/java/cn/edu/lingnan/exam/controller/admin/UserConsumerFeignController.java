package cn.edu.lingnan.exam.controller.admin;



import cn.edu.lingnan.exam.common.LoginSession;
import cn.edu.lingnan.exam.entity.User;
import cn.edu.lingnan.exam.service.UserFeignService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;


@Controller
@RequestMapping
public class UserConsumerFeignController {

    @Resource
    private UserFeignService userFeignService;


    //去到用户管理页面
    @RequestMapping("userUi")
    public String userUI() {
        /*if (!LoginSession.getCurrentUser().getTocheck().equals(1)) {
            return "client/html/index";
        }*/
        return "admin/user/userList";
    }

    /**
     * 显示数据，但是模糊查询有问题
     * @param page
     * @param limit
     * @param keyword
     * @return
     */
    @RequestMapping("admin/user/tableList")
    @ResponseBody
    public Object queryAll(Integer page, Integer limit, String keyword){
        return userFeignService.queryAll(page, limit, keyword);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("admin/user/del")
    @ResponseBody
    public Object deleteUser(Integer id){
        return userFeignService.deleteUser(id);
    }


    /**
     * 更新用户信息，但是无法传对象到后端
     * @param user
     * @return
     */
    @PostMapping("admin/user/update")
    @ResponseBody
    public Map<String, Object> updateUser(@RequestBody User bean){

        System.out.println("进入feigncontroller的update");
        System.out.println(bean);
        return userFeignService.updateUser(bean);
    }


    /**
     * 跳转到修改密码页面
     * @return
     */
    @RequestMapping("updatePwdViwe")
    public String updatePwd() {
        /*if (!LoginSession.getCurrentUser().getUsername().equals("admin")) {
            return "client/html/index";
        }*/
        return "admin/system/pwdUpdate";
    }

    @RequestMapping("admin/sysPwd/update")
    public Object updatePwd(JSONObject json){
        System.out.println(111);
        return userFeignService.updatePwd(json);
    }








}
