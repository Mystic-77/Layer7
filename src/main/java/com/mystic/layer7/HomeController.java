package com.mystic.layer7;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
    @GetMapping("/login2")
    public String login2()
    {
        return "login2";
    }
//    @GetMapping("/profile")
//    public String profilePage()
//    {
//        return "profile";
//    }

}
