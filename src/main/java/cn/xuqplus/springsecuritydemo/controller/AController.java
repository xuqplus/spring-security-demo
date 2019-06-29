package cn.xuqplus.springsecuritydemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class AController {
  Logger logger = LoggerFactory.getLogger(AController.class);

  @GetMapping("/")
  public String a(HttpSession session) {
    logger.info("session.getId()=>{}", session.getId());
    return "ok, s0";
  }

  @GetMapping("setSession")
  public String setSession(HttpSession session, String k, String v) {
    logger.info("session.getId()=>{}", session.getId());
    logger.info("setSession, k=>{}, v=>{}", k, v);
    session.setAttribute(k, v);
    return "ok, s0, setSession";
  }
}
