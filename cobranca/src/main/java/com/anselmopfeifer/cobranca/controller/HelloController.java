package com.anselmopfeifer.cobranca.controller;

/**
 * Created by anselmo on 28/08/16.
 */

import com.anselmopfeifer.cobranca.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/home")
    String home() {
        return "home";
    }

    @RequestMapping("/admin")
    String restricted() {
        return "admin";
    }

//    @RequestMapping("/admin")
//    String admin() {
//        adminService.ensureAdmin();
//        return "admin";
//    }
}
