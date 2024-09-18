package com.weiran.cloud.repository;

import com.weiran.cloud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

//public interface UserRepository extends MongoRepository<User, String> {
//    User findByEmail(String email);
//}
