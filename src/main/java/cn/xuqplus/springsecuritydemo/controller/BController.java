package cn.xuqplus.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BController {

  @RequestMapping("anonymous")
  public String anonymous() {
    return "anonymous";
  }

  @RequestMapping("all")
  public String all() {
    return "all";
  }

  @RequestMapping("normal")
  public String normal() {
    return "normal";
  }

  @RequestMapping("admin")
  public String admin() {
    return "admin";
  }

  @RequestMapping("root")
  public String root() {
    return "root";
  }
}
