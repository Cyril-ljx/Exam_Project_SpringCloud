package cn.edu.lingnan.exam.controller.admin;

import cn.edu.lingnan.exam.common.ServerLayResult;
import cn.edu.lingnan.exam.entity.Leacot;
import cn.edu.lingnan.exam.service.LeacotFeignService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Author: chen_man_cheng
 * @Description: //TODO
 * @Date: Create in 20:24 2020/6/20
 */
@Controller
@RequestMapping("feign")
public class LeacotsController {

    @Autowired
    private LeacotFeignService leacotFeignService;

    @RequestMapping("/leacotsView")
    public String leacotUi() {
        return "admin/leacots/leacotsList";
    }


//    @RequestMapping("/list")
//    @ResponseBody
//    public ServerLayResult leacotsList(@RequestParam(value = "page", defaultValue = "1") Integer page,
//                                       @RequestParam(value = "limit", defaultValue = "10") Integer limit, String keyword1){
//
//        if (keyword1 != null){
//            List<Leacot> leacots = leacotFeignService.leacotsList(page,limit,keyword1);
//
//            ServerLayResult result = new ServerLayResult(0, "", leacots.size(), leacots);
//            return result;
//        }
//        ServerLayResult result = new ServerLayResult(0, "", leacotFeignService.count(), leacotFeignService.selectAll(page,limit));
//        return result;
//    }

    @RequestMapping("/list")
    @ResponseBody
    public Object leacotsList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                       @RequestParam(value = "limit", defaultValue = "10") Integer limit, String keyword1) {

        return leacotFeignService.leacotsList(page,limit,keyword1);
    }


    @RequestMapping("/del")
    @ResponseBody
    public Map<String, Object> del(@RequestParam("id") int id){
        return leacotFeignService.del(id);
    }

    @RequestMapping("/update")
    @ResponseBody
    Map<String, Object> update(@RequestBody JSONObject json){
        return leacotFeignService.update(json);
    }


}
