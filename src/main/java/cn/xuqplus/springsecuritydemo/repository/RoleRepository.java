package cn.xuqplus.springsecuritydemo.repository;

import cn.xuqplus.springsecuritydemo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
