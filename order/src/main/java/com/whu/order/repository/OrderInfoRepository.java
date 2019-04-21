package com.whu.order.repository;

import com.whu.order.entity.OrderInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderInfoRepository extends JpaRepository<OrderInfo,String> {
    Page<OrderInfo> findByUserIdAndOrderStatus(String userId, String orderStatus, Pageable pageable);
}
