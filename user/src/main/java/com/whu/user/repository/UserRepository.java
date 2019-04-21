package com.whu.user.repository;

import com.whu.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

    User findByUserEmailAndPassword(String userEmail,String password);

    User findByUserEmail(String userEmail);
}
