package com.whu.order.feign;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.whu.order.vo.ResponseInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "product",fallbackFactory = ProductFallbackFactory.class)
@Hystrix
public interface ProductFeign {

    @RequestMapping("product_information")
    ResponseInfo information(@RequestBody String data);

    @RequestMapping("update_stock")
    ResponseInfo updateStock(@RequestBody String data);


}
