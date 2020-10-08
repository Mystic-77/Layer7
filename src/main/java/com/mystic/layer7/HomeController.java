package com.mystic.layer7;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//mvc format
@Controller
public class HomeController
{
    @GetMapping("/hello")
    public String homePage()
    {
        return "helloworld";
    }

    @GetMapping("/login")
    public String loginPage()
    {
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage()
    {
        return "signup";
    }

    @GetMapping("/profile")
    public String profilePage()
    {
        return "profile";
    }

}
