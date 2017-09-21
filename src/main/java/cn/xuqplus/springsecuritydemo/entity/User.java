package cn.xuqplus.springsecuritydemo.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User extends BaseEntity implements UserDetails {

  public String username, password;
  @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
  public List<Role> roles;

  public User() {
  }

  public User(String username, String password,
      List<Role> roles) {
    this.username = username;
    this.password = password;
    this.roles = roles;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    if (null == roles || roles.size() <= 0) {
      authorities.add(new SimpleGrantedAuthority(""));
      return authorities;
    }
    for (Role role : roles) {
      authorities.add(new SimpleGrantedAuthority(role.name));
    }
    return authorities;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public String getUsername() {
    return this.username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
