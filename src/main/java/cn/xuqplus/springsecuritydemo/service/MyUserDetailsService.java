package cn.xuqplus.springsecuritydemo.service;

import cn.xuqplus.springsecuritydemo.entity.User;
import cn.xuqplus.springsecuritydemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {

  @Autowired
  UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    User user = userRepository.findUserByUsername(s);
    if (null == user) {
      throw new UsernameNotFoundException("用户名不存在");
    }
    return user;
  }
}
