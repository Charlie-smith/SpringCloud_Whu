package com.whu.order.feign;

import com.whu.order.enums.OrderEnum;
import com.whu.order.exception.OrderException;
import com.whu.order.vo.ResponseInfo;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ProductFallbackFactory implements FallbackFactory<ProductFeign> {

    @Override
    public ProductFeign create(Throwable throwable) {
        return new ProductFeign() {
            @Override
            public ResponseInfo information(String data) {
                return new ResponseInfo(OrderEnum.SERVICE_PRODUCT_CALL_FAIL,null);
            }

            @Override
            public ResponseInfo updateStock(String data) {
                return new ResponseInfo(OrderEnum.SERVICE_PRODUCT_CALL_FAIL,null);
            }
        };
    }
}
