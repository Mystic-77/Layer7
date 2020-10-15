package com.mystic.layer7;

import com.mystic.layer7.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

//mvc format
@Controller
public class HomeController
{

    @Autowired
    private DatabaseService dbService;

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

    @GetMapping("/forums")
    public String forumsPage()
    {
        return "forums";
    }

    @GetMapping("/links")
    public String linksPage()
    {
        return "links";
    }

    @GetMapping("/playlists")
    public String playlistsPage()
    {
        return "playlists";
    }

    @GetMapping("/users")
    public String usersPage()
    {
        return "users";
    }

    @GetMapping("/profile")
    public String showProfile(@CookieValue(value = "userid") String userId,
                              Model model)
    {
        User user = dbService.getUserRepository().getUserById(userId);
        model.addAttribute(user);
        return "profile";
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
        user.setRole("USER");
        user.setPosts(new ArrayList<String>());
        System.out.println(user);
        dbService.getUserRepository().save(user);
        return "/index";
    }


    @PostMapping("/auth")
    public String profilePage(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              HttpServletResponse response,
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
                model.addAttribute(user);
                Cookie cookie = new Cookie("userid", user.getId());
                response.addCookie(cookie);
                return "profile";
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

    @GetMapping("/addPost")
    public String addPost(@CookieValue(value = "userid") String userid,
                          Model model)
    {
        return "new-post-form";
    }

    @GetMapping("/addLink")
    public String addLink(@CookieValue(value = "userid") String userid,
                          Model model)
    {
        return "new-link-form";
    }

    @GetMapping("/addPlaylist")
    public String addPlaylist(@CookieValue(value = "userid") String userid,
                              Model model)
    {
        return "new-playlist-form";
    }
}
