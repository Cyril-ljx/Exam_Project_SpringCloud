package cn.edu.lingnan.exam.service;

import cn.edu.lingnan.exam.entity.Label;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: chen_man_cheng
 * @Description: //TODO
 * @Date: Create in 0:23 2020/6/21
 */
@Component
@FeignClient(value = "provider-label")
public interface LabelFeignService {

    @RequestMapping("/admin/label/list")
    List<Label> list();
}
