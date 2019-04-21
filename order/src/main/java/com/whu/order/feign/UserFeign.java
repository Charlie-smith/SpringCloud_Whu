package com.whu.order.feign;

import com.whu.order.vo.ResponseInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@FeignClient(name = "user")
public interface UserFeign {

    @RequestMapping("/test")
    ResponseInfo userTest();
}
