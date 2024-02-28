package com.example.endPointAuthorizationBasic.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/company")
public class AuthController {
    @GetMapping("/database")
//    @PreAuthorize("hasAuthority('dbAdmin')")
    public String checkAccess()
    {

        var u= SecurityContextHolder.getContext();
        u.getAuthentication().getAuthorities().forEach(a-> System.out.println(a));
        System.out.println(u.getAuthentication().getCredentials());
//        return new RedirectView("/kitchen");


        return "success";
    }
    @GetMapping("/office")
//    @PreAuthorize("hasAuthority('employee')")
    public String getAccess()
    {

        var u= SecurityContextHolder.getContext();
        u.getAuthentication().getAuthorities().forEach(a-> System.out.println(a));
        System.out.println(u.getAuthentication().getPrincipal());
//        return new RedirectView("/kitchen");


        return "office";
    }

}
