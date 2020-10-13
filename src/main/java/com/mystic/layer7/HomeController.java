package com.mystic.layer7;

import com.mystic.layer7.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//mvc format
@Controller
public class HomeController
{

    @Autowired
    private DatabaseService dbService;

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
    @PostMapping("/createAccount")
    public String newAccount(@ModelAttribute("user") User user)
    {
        if(user == null)
        {
            return "error";
        }
        System.out.println(user);
        String password = user.getPassword();
        System.out.println(password);
        user.setPassword(new PasswordEncryptor().encode(user.getPassword()));
        System.out.println(user);
        dbService.getUserRepository().save(user);
        return "/";
    }
    @PostMapping("/profile")
    public String profilePage(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              Model model)
    {
        try
        {
            PasswordEncryptor passwordEncryptor = new PasswordEncryptor();
            User user = dbService.getUserRepository().getUserByUsername(username);
            String hashedPassword = passwordEncryptor.encode(password);
            System.out.println(hashedPassword);
            if (passwordEncryptor.comparePasswords(hashedPassword, user.getPassword()))
            {
                System.out.println("condition is evaluated to be true");
                System.out.println("retrieving posts");

                return "helloworld";
            }
            else
            {
                System.out.println("evaluated as wrong");
                return "login";
            }
        }
        catch (Exception e)
        {
            return "error";
        }


    }
}
