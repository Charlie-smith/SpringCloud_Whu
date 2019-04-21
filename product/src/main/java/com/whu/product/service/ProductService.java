package com.whu.product.service;

import com.whu.product.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Page<Product> productList(String gameName,Integer page,Integer size);

    Product findProductById(Integer productId);

    Product updateProductStock(Integer productId,Integer stockChange);

}
