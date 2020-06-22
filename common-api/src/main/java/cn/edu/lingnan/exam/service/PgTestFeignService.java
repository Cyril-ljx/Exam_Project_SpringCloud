package cn.edu.lingnan.exam.service;

import cn.edu.lingnan.exam.entity.Pgtest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Component
@FeignClient(value = "provider-pgtest")
public interface PgTestFeignService {
    @RequestMapping("/pgtest/findExamRadio")
    List<Map<String,Object>> findExamRadioQuestions(int id);

    @RequestMapping("/pgtest/findExamCheckbox")
    List<Map<String,Object>> findExamCheckboxQuestions(int id);
    @RequestMapping("/pgtest/insert")
    boolean insert(Pgtest pgtest);
}
