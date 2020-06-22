package cn.edu.lingnan.exam.service;


import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Component
@FeignClient(value = "provider-pgtest-8010")
public interface PgtestFeignService {
    @GetMapping("/admin/pgtest/list")
    Object queryAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                    @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                    @RequestParam(value = "keyword", defaultValue = "") String keyword1);

    @GetMapping("/admin/pgtest/del")
    Object deletePgtest(@RequestParam("id") Integer id);
}