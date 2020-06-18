package cn.edu.lingnan.exam.admin.controller.admin;

import cn.edu.lingnan.exam.common.LoginSession;
import cn.edu.lingnan.exam.entity.CommonResult;
import cn.edu.lingnan.exam.entity.User;
import cn.edu.lingnan.exam.service.UserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-06-15 17:21:06
 */
@Controller
@RequestMapping()
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    //@RequestMapping("queryById/{id}")
    @PostMapping("queryById")
    @ResponseBody
    public User queryById(Integer id) {
        return this.userService.queryById(id);
    }


    @PostMapping("deleteById")
    @ResponseBody
    public Boolean deleteById(Integer[] ids) {
        if (ids == null || ids.length == 0) {
            return false;
        }
        userService.deleteById(Arrays.asList(ids));
        return true;
    }


    //去到用户管理页面
    @RequestMapping("userUi")
    public String userUI() {
        if (!LoginSession.getCurrentUser().getTocheck().equals(1)) {
            return "client/html/index";
        }
        return "admin/user/userList";
    }

    /**
     * 显示数据
     * @param page
     * @param limit
     * @param keyword
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/user/tableList")
    public CommonResult userList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                 @RequestParam(value = "keyword", defaultValue = "") String keyword) {
        if (keyword == null || keyword.equals("")) {
            //封装Json数据对象
            CommonResult result = new CommonResult(0, "", userService.count(), userService.selectAll(page, limit));
            return result;
        } else if (keyword != null) {
            String t = String.valueOf(userService.selectByUsername(keyword, page, limit).size());
            long b = Long.parseLong(t);

            CommonResult result = new CommonResult(0, "", b, userService.selectByUsername(keyword, page, limit));
            return result;
        }
        return null;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/user/del")
    public Map<String, Object> del(@RequestParam("id") Integer id) {
        Map<String, Object> dataMap = new HashMap<>();
        Boolean isSuccess = false;
        if (id != null && id != 0) {
            int del = userService.deleteByPrimaryKey(id);
            if (del > 0) {
                isSuccess = true;
                dataMap.put("success", isSuccess);
                return dataMap;
            }
        }
        dataMap.put("success", isSuccess);
        return dataMap;
    }

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/admin/user/update", method = RequestMethod.POST)
    public Map<String, Object> updateUser(@RequestBody User user) {
        Map<String, Object> dataMap = new HashMap<>();
        Boolean isSuccess = false;
        if (user != null) {
            //根据用户对象的id 查询用户的密码，防止密码丢失
            User user1 = userService.queryById(user.getId());
            //再次封装进对象中
            if (user1 != null) {
                user.setPassword(user1.getPassword());
                //更新对象
                int update = userService.updateByPrimaryKey(user);
                if (update > 0) {
                    isSuccess = true;
                    dataMap.put("success", isSuccess);
                    return dataMap;
                }
            }
        }
        dataMap.put("success", isSuccess);
        return dataMap;
    }

    /**
     * 跳转到修改密码页面
     * @return
     */
    @RequestMapping("/updatePwdViwe")
    public String updatePwd() {
        /*if (!LoginSession.getCurrentUser().getUsername().equals("admin")) {
            return "client/html/index";
        }*/
        return "admin/system/pwdUpdate";
    }

    /**
     * 修改个人密码
     * @param json
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/sysPwd/update")
    public Map<String, Object> updatePwd(@RequestBody JSONObject json) {
        Map<String, Object> dataMap = new HashMap<>();
        boolean isSuccess = false;
        JSONObject data = JSON.parseObject(json.toJSONString());
        String oldPassword = data.getString("oldPassword");
        String password = data.getString("password");
        String repassword = data.getString("repassword");
        logger.info("====>" + oldPassword + "--" + password + "--" + repassword);
        //这里默认只能修改管理员密码
        User byUsername = userService.queryByUserName(LoginSession.getCurrentUser().getUsername());

        logger.info("---->" + byUsername);
        if (byUsername != null) {
            //校验旧密码是否正确
            if (!byUsername.getPassword().equals(DigestUtils.md5DigestAsHex(oldPassword.getBytes()))) {
                dataMap.put("scueess", isSuccess);
                return dataMap;
            }
            //校验两次输入的密码是否匹配
            if (!password.equals(repassword)) {
                dataMap.put("scueess", isSuccess);
                return dataMap;
            }
            //更新数据库密码
            //创建用户对象
            User user = new User();
            user.setId(byUsername.getId());
            user.setUsername(byUsername.getUsername());
            user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
            user.setAddress(byUsername.getAddress());
            user.setEmail(byUsername.getEmail());
            user.setPhone(byUsername.getPhone());
            user.setTocheck(byUsername.getTocheck());
            user.setUserType(byUsername.getUserType());
            user.setName(byUsername.getName());
            if (userService.updateByPrimaryKey(user) > 0) {
                isSuccess = true;
                dataMap.put("success", isSuccess);
                return dataMap;
            }
        }
        dataMap.put("success", isSuccess);
        return dataMap;
    }



}