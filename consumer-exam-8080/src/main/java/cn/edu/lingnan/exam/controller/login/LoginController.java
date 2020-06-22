package cn.edu.lingnan.exam.controller.login;

import cn.edu.lingnan.exam.common.LoginSession;
import cn.edu.lingnan.exam.entity.User;
//import cn.edu.lingnan.exam.service.LoginFeignService;
import cn.edu.lingnan.exam.service.LoginFeignService;
import cn.edu.lingnan.exam.service.UserService;
import com.google.code.kaptcha.Producer;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * @Author: chen_man_cheng
 * @Description: //TODO
 * @Date: Create in 20:49 2020/6/18
 */
@Controller
@RequestMapping("feign")
public class LoginController {

//    @Autowired
//    private LoginFeignService loginFeignService;


   @Autowired
   private Producer producer;


    @Autowired
    private LoginFeignService loginFeignService;

    @RequestMapping("/login")
    public String loginView() {
        return "admin/login";
    }


    @RequestMapping("/login_do")
    @ResponseBody
    public String login_do(@RequestBody User user,HttpServletRequest request){
        HttpSession session=request.getSession();
        session.setAttribute("user",user);
//        User users = userService.loginByUser(user.getUsername(), user.getPassword());
//        LoginSession.setUserInSession(users);
//        request.getSession().setAttribute("loginName", users.getUsername());
        System.out.println(user);

//        String a= loginFeignService.loginDo(user);
//        System.out.println(a);
//        return a;
        return loginFeignService.loginDo(user);
    }

    @GetMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws Exception {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = producer.createText();
            httpServletRequest.getSession().setAttribute("vrifyCode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = producer.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }
}
