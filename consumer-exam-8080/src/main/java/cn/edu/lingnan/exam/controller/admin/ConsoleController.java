package cn.edu.lingnan.exam.controller.admin;


import cn.edu.lingnan.exam.common.LoginSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ConsoleController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping("/admin")
    public String index( HttpServletRequest request) {

        /*System.out.println(111);
        Integer check= (Integer) request.getAttribute("tocheck");
        System.out.println(check);
        logger.info(LoginSession.getCurrentUser().getUsername());
        if (!LoginSession.getCurrentUser().getTocheck().equals(1)) {
            System.out.println(222);
            return "client/html/index";
        }
        System.out.println(333);*/
        return "admin/index";
    }


    @RequestMapping("/home/console")
    public String console() {
        if (!LoginSession.getCurrentUser().getTocheck().equals(1)) {
            return "client/html/index";
        }
        return "admin/home/console";
    }
}
