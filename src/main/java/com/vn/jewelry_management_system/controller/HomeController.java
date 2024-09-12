package com.vn.jewelry_management_system.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class HomeController {

    @GetMapping("/home")
    public String home(Authentication authentication) {
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return "redirect:/admin/dashboard";
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_STAFF"))) {
            return "redirect:/admin/dashboard";
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_EMPLOYEE"))) {
            return "redirect:/admin/dashboard";
        }
        return "admin/dashboard";
    }

    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }

    @GetMapping("/register")
    public String register() {
        return "admin/register";
    }
}