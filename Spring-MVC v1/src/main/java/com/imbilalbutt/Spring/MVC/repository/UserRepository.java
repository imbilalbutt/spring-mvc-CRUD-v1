package com.imbilalbutt.Spring.MVC.repository;

import com.imbilalbutt.Spring.MVC.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends DistributedRepository<User> {
}
