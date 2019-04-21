package com.whu.product.service.impl;

import com.whu.product.entity.Product;
import com.whu.product.enums.ProductEnum;
import com.whu.product.exception.ProductException;
import com.whu.product.repository.ProductRepository;
import com.whu.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> productList(String gameName,Integer page,Integer size) {
        Pageable pageable = PageRequest.of(page,size);
        return productRepository.findByGameName(gameName,pageable);
    }

    @Override
    public Product findProductById(Integer productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public Product updateProductStock(Integer productId, Integer stockChange) {
        Product product = productRepository.findById(productId).orElse(null);
        if(product==null)
            throw new ProductException(ProductEnum.PRODUCT_NOT_EXIST);
        product.setProductStock(product.getProductStock()-stockChange);
        return productRepository.save(product);
    }

}
