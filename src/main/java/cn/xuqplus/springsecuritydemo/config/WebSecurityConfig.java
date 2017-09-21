package cn.xuqplus.springsecuritydemo.config;


import cn.xuqplus.springsecuritydemo.service.MyAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * spring security 关键配置类
 *
 * 实现UserDetails, UserDetailsService, AuthenticationProvider 然后配置安全策略并注入AuthenticationProvider实例
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  /*
    安全策略
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers("/", "/index.html", "/public").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login").loginProcessingUrl("/login").permitAll()
        .and()
        //logout默认url为"/logout", spring security实现了默认登出行为
        .logout().permitAll()
        .and()
        //新版本spring security中, csrf默认是开启的
        .csrf().disable();
  }

  /*
    校验规则
   */
  @Override
  protected void configure(AuthenticationManagerBuilder builder) throws Exception {
    builder.authenticationProvider(provider);
  }

  @Autowired
  MyAuthenticationProvider provider;
}
