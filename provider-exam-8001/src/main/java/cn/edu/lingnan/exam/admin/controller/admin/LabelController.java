package cn.edu.lingnan.exam.admin.controller.admin;

import cn.edu.lingnan.exam.entity.Label;
import cn.edu.lingnan.exam.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: chen_man_cheng
 * @Description: //TODO
 * @Date: Create in 16:17 2020/6/17
 */
@RestController
public class LabelController {
    @Autowired
    private LabelService labelService;

    @RequestMapping("/admin/label/list")
    public List<Label> list() {
        List<Label> labels = labelService.selectAll();
        return labels;
    }
}
