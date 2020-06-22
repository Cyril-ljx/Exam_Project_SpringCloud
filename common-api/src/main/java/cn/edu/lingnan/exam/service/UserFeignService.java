package cn.edu.lingnan.exam.service;


import cn.edu.lingnan.exam.entity.User;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Component
@FeignClient(value = "provider-user-8002")
public interface UserFeignService {
    /**
     * 显示user
     * @param page
     * @param limit
     * @param keyword
     * @return
     */
    @GetMapping("/admin/user/tableList")
    Object queryAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                    @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                    @RequestParam(value = "keyword", defaultValue = "") String keyword);


    @GetMapping("/admin/user/del")
    Object deleteUser(@RequestParam("id") Integer id);

    @PostMapping("/admin/user/update")
    Map<String, Object> updateUser(@SpringQueryMap User bean);

      @GetMapping("/admin/sysPwd/update")
      Object updatePwd(@RequestBody JSONObject json);

}