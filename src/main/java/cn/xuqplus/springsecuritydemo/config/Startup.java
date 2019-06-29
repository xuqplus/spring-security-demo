package cn.xuqplus.springsecuritydemo.config;

import cn.xuqplus.springsecuritydemo.entity.Role;
import cn.xuqplus.springsecuritydemo.entity.User;
import cn.xuqplus.springsecuritydemo.repository.RoleRepository;
import cn.xuqplus.springsecuritydemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Startup implements ApplicationListener<ApplicationReadyEvent> {

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Override
  public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
    if (!roleRepository.existsByName("normal")) {
      Role role = new Role("normal");
      roleRepository.save(role);
    }
    if (!roleRepository.existsByName("admin")) {
      Role role = new Role("admin");
      roleRepository.save(role);
    }
    if (!roleRepository.existsByName("root")) {
      Role role = new Role("root");
      roleRepository.save(role);
    }
    if (!userRepository.existsByUsername("root")) {
      User user = new User("root", "123456",
              new ArrayList<Role>() {{
                add(roleRepository.getByName("normal"));
                add(roleRepository.getByName("admin"));
                add(roleRepository.getByName("root"));
              }});
      userRepository.save(user);
    }
    if (!userRepository.existsByUsername("admin")) {
      User user = new User("admin", "123456",
              new ArrayList<Role>() {{
                add(roleRepository.getByName("normal"));
                add(roleRepository.getByName("admin"));
              }});
      userRepository.save(user);
    }
    if (!userRepository.existsByUsername("normal")) {
      User user = new User("normal", "123456",
              new ArrayList<Role>() {{
                add(roleRepository.getByName("normal"));
              }});
      userRepository.save(user);
    }
  }
}
