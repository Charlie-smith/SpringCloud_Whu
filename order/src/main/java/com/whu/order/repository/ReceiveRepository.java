package com.whu.order.repository;

import com.whu.order.entity.Receive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiveRepository extends JpaRepository<Receive,Integer>{

}
