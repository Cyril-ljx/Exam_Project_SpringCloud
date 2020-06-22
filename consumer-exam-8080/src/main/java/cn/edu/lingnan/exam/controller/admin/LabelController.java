package cn.edu.lingnan.exam.controller.admin;

import cn.edu.lingnan.exam.entity.Label;
import cn.edu.lingnan.exam.service.LabelFeignService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: chen_man_cheng
 * @Description: //TODO
 * @Date: Create in 0:23 2020/6/21
 */
@Controller
@RequestMapping("feign")
public class LabelController {

    private LabelFeignService labelFeignService;

    @RequestMapping("/label/list")
    public List<Label> list() {
        System.out.println("到了");
        List<Label> labels = labelFeignService.list();
        System.out.println(labels);
        return labels;
    }
}
