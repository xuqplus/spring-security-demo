package cn.xuqplus.springsecuritydemo.config;

import cn.xuqplus.springsecuritydemo.entity.Role;
import cn.xuqplus.springsecuritydemo.entity.User;
import cn.xuqplus.springsecuritydemo.repository.RoleRepository;
import cn.xuqplus.springsecuritydemo.repository.UserRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class Startup implements ApplicationListener<ApplicationReadyEvent> {

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Override
  public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
    Role admin = new Role("admin");
    Role root = new Role("root");
    roleRepository.save(admin);
    roleRepository.save(root);
    User user = new User("xqq", "123123",
        new ArrayList<Role>() {{
          add(admin);
          add(root);
        }});
    userRepository.save(user);
  }
}
