package com.xzk.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


/**
 * Created by XiaoZK on 2016/10/9.
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(Model model, Date date, HttpServletRequest request) {
        Date now = new Date();
        model.addAttribute("time", now);
        model.addAttribute("formate", date);
        System.out.println("converter测试");
        System.out.println(date);
        return "/index";
    }
}
