package cn.xuqplus.springsecuritydemo.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityRequestMatcherProviderAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.assertj.ApplicationContextAssert;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringSecurityConfigTest {

  @Autowired
  ApplicationContext context;

  @Autowired
  SecurityRequestMatcherProviderAutoConfiguration autoConfiguration;

  @Autowired
  SecurityFilterAutoConfiguration securityFilterAutoConfiguration;

  @Autowired
  AuthenticationConfiguration authenticationConfiguration;

  @Test
  public void a() {
    System.err.println();
  }
}