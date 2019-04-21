package com.whu.product.controller;

import com.google.gson.Gson;
import com.whu.product.entity.Product;
import com.whu.product.service.ProductService;
import com.whu.product.vo.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private Gson gson;

    @RequestMapping("product_information")
    public ResponseInfo information(@RequestBody String data){
        Integer productId = Integer.valueOf(gson.fromJson(data,Map.class).get("productId").toString());
        Product product = productService.findProductById(productId);
        return new ResponseInfo(product);
    }

    //查询商品列表，代码合格通过测试
    @RequestMapping("product_list")
    public ResponseInfo list(@RequestBody String data){
        Map<String,String> requestInfo = gson.fromJson(data,Map.class);
        String gameName = requestInfo.get("gameName");
        Integer page = Integer.valueOf(requestInfo.get("page"));
        Integer size = Integer.valueOf(requestInfo.get("size"));
        Page<Product> products = productService.productList(gameName,page-1,size);
        return new ResponseInfo(products.getContent());
    }

    @RequestMapping("update_stock")
    public ResponseInfo updateStock(@RequestBody String data){
        Map<String,String> requestInfo = gson.fromJson(data,Map.class);
        Integer productId = Integer.valueOf(requestInfo.get("productId"));
        Integer stockChange = Integer.valueOf(requestInfo.get("stockChange"));
        Product product = productService.updateProductStock(productId,stockChange);
        return new ResponseInfo(null);
    }
}
