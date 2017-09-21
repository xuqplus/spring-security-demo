package cn.xuqplus.springsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class DemoController {

  @RequestMapping("/private")
  public String private0() {
    return "private";
  }

  @RequestMapping("/public")
  public String public0() {
    return "public";
  }

  /*
   * 由于启用了thymeleaf
   * 将会查找目录resources/templates
   */
  @RequestMapping("/")
  public String index() {
    return "redirect:/index.html";
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String get() {
    return "login";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String login() {
    return "private";
  }
}
