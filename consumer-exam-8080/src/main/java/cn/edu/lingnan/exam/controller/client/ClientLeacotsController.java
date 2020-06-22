package cn.edu.lingnan.exam.controller.client;

import cn.edu.lingnan.exam.entity.Leacot;
import cn.edu.lingnan.exam.service.LeacotFeignService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: chen_man_cheng
 * @Description: //TODO
 * @Date: Create in 12:31 2020/6/20
 */
@Controller
//@RequestMapping("feign")
public class ClientLeacotsController {

    @Autowired
    private LeacotFeignService leacotFeignService;
    /**
     * 留言列表
     *
     * @param page 页数
     * @param limit 条数
     * @param model
     * @return
     */
    @RequestMapping("/leacots/leacotsUi")
    public String clientArticleUi(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                  @RequestParam(value = "limit", defaultValue = "10") Integer limit, Model model) {

//        return leacotFeignService.clientArticleUi(page,limit);
        List<Leacot> leacots = leacotFeignService.clientArticleUi(page,limit);
        PageInfo info = new PageInfo(leacots);
        model.addAttribute("leacotsInfo", info);
        model.addAttribute("leacots", info.getList());
        //共享数据
        return "client/html/leacots";
    }

    @ResponseBody
    @PostMapping(value = "/leacots/save")
    Map<String, Object> saveLeacot(@RequestBody JSONObject data){
        return leacotFeignService.saveLeacot(data);
    }

}
