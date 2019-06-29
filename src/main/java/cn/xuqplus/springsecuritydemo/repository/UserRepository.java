package cn.xuqplus.springsecuritydemo.repository;

import cn.xuqplus.springsecuritydemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  User findUserByUsername(String username);

  boolean existsByUsername(String username);
}
