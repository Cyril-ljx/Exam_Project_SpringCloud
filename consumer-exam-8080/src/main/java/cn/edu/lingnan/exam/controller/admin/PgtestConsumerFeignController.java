package cn.edu.lingnan.exam.controller.admin;


import cn.edu.lingnan.exam.common.LoginSession;
import cn.edu.lingnan.exam.service.PgtestFeignService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
@RequestMapping
public class PgtestConsumerFeignController {

    @Resource
    private PgtestFeignService pgtestFeignService;


    //去到测评管理页面
    @RequestMapping("/admin/pgtest/pgtestView")
    public String pgtestView() {
        /*if (!LoginSession.getCurrentUser().getTocheck().equals(1)) {
        }*/
        return "admin/topic/pgtestList";
    }

    /**
     * 显示数据，但是模糊查询有问题
     * @param page
     * @param limit
     * @param keyword
     * @return
     */
    @RequestMapping("/admin/pgtest/list")
    @ResponseBody
    public Object queryAll(Integer page, Integer limit, String keyword){
        return pgtestFeignService.queryAll(page, limit, keyword);
    }


    @RequestMapping("/admin/pgtest/del")
    @ResponseBody
    public Object deletePgtest(Integer id){
        return pgtestFeignService.deletePgtest(id);
    }
}
