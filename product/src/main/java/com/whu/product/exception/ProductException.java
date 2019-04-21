package com.whu.product.exception;

import com.whu.product.enums.ProductEnum;
import lombok.Data;

@Data
public class ProductException extends RuntimeException{

    private Integer code;

    public ProductException(ProductEnum productEnum) {
        super(productEnum.getMessage());

        this.code = productEnum.getCode();
    }

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
