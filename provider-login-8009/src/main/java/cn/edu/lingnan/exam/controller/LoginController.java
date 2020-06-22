package cn.edu.lingnan.exam.controller;

import cn.edu.lingnan.exam.common.LoginSession;
import cn.edu.lingnan.exam.entity.User;
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
 * 登入控制器
 */
@Controller
public class LoginController {

    //private Logger logger = LoggerFactory.getLogger(this.getClass());
    //注入
//    @Autowired
//    private Producer producer;

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String loginView() {
        return "admin/login";
    }

    @ResponseBody
    @RequestMapping("/login_do")
    public String loginDo(@RequestBody User user) {
        System.out.println("调用到了");
        System.out.println(user);
      //  String vrifyCode = (String) request.getSession().getAttribute("vrifyCode");
        if (user != null) {
            System.out.println("进来了");
            System.out.println(user.getUsername() + "-----------" + user.getPassword());
            User users = userService.loginByUser(user.getUsername(), user.getPassword());
            System.out.println(users);
            if (users == null) {
                return "passwordError";}
//            } else if (!vrifyCode.equals(user.getVercode())) {
//                System.out.println("我是验证码");
//                return "vrifyCodeErroe";
//            }
       //     LoginSession.setUserInSession(users);
           // request.getSession().setAttribute("loginName", users.getUsername());
            System.out.println("快要成功了");
            if(users.getTocheck() == 1){
                System.out.println("跳到后台了");
                return "adminsuccessls";
            }else{
            return "success";}
        } else {
            return "userNull";
        }

    }

    /**
     * 生成验证码
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws Exception
     */
//    @GetMapping("/defaultKaptcha")
//    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
//            throws Exception {
//        byte[] captchaChallengeAsJpeg = null;
//        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
//        try {
//            //生产验证码字符串并保存到session中
//            String createText = producer.createText();
//            httpServletRequest.getSession().setAttribute("vrifyCode", createText);
//            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
//            BufferedImage challenge = producer.createImage(createText);
//            ImageIO.write(challenge, "jpg", jpegOutputStream);
//        } catch (IllegalArgumentException e) {
//            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
//            return;
//        }
//        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
//        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
//        httpServletResponse.setHeader("Cache-Control", "no-store");
//        httpServletResponse.setHeader("Pragma", "no-cache");
//        httpServletResponse.setDateHeader("Expires", 0);
//        httpServletResponse.setContentType("image/jpeg");
//        ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
//        responseOutputStream.write(captchaChallengeAsJpeg);
//        responseOutputStream.flush();
//        responseOutputStream.close();
//    }

    //注销处理
    @RequestMapping("/logout")
    public String invalidate(HttpSession session) {
        session.invalidate();
        return "redirect:login.jsp";
    }

}
