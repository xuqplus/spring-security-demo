package cn.xuqplus.springsecuritydemo.config;

import cn.xuqplus.springsecuritydemo.service.MyAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.expression.WebExpressionVoter;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

  @Bean
  public AccessDecisionManager accessDecisionManager() {
    List decisionVoters = new ArrayList<AccessDecisionVoter>();
    RoleVoter roleVoter = new RoleVoter();
    decisionVoters.add(roleVoter);
    WebExpressionVoter webExpressionVoter = new WebExpressionVoter();
    decisionVoters.add(webExpressionVoter);
    decisionVoters.add(new AuthenticatedVoter());
    AccessDecisionManager accessDecisionManager = new AffirmativeBased(decisionVoters);
    return accessDecisionManager;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
            .accessDecisionManager(accessDecisionManager())
            .antMatchers("/index.html", "/anonymous").anonymous()
            .antMatchers("/all").permitAll()
            .antMatchers("/normal").hasRole("normal")
            .antMatchers("/admin").hasRole("admin")
            .antMatchers("/root").hasRole("root")
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginProcessingUrl("/loginProcessingUrl").permitAll()
            .and()
            //logout默认url为"/logout", spring security实现了默认登出行为
            .logout().permitAll()
            .and()
            //新版本spring security中, csrf默认是开启的
            .csrf().disable();
  }

  //  @Autowired
//  MyAuthenticationProvider provider;

//  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    super.configure(auth);
//    auth.authenticationProvider(provider);
//  }

  @Autowired
  public void setProvider(MyAuthenticationProvider provider, AuthenticationManagerBuilder builder) {
    builder.authenticationProvider(provider);
  }
}
