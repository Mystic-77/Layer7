package com.mystic.layer7;

import com.mystic.layer7.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Controller
public class HomeController
{

    @Autowired
    private DatabaseService dbService;

    //GET MAPPINGS
    @GetMapping("/index")
    public String indexPage()
    {
        return "index";
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

    @GetMapping("/forums")
    public String forumsPage(Model model)
    {
        List<Post> posts = dbService.getPostRepository().findAll();
        Collections.reverse(posts);
        model.addAttribute("posts",posts);
        return "forums";
    }

    @GetMapping("/links")
    public String linksPage(Model model)
    {
        List<Link> links = dbService.getLinkRepository().findAll();
        model.addAttribute("links", links);
        return "links";
    }

    @GetMapping("/playlists")
    public String playlistsPage(Model model)
    {
        List<Playlist> playlists = dbService.getPlaylistRepository().findAll();
        model.addAttribute("playlists",playlists);
        return "playlists";
    }

    @GetMapping("/users")
    public String usersPage(Model model)
    {
        List<User> users = dbService.getUserRepository().findAll();
        model.addAttribute("users",users);
        return "users";
    }

    @GetMapping("/profile")
    public String showProfile(@CookieValue(value = "userid") String userId,
                              Model model)
    {
        User user = dbService.getUserRepository().getUserById(userId);
        List<Post> posts = dbService.getPostRepository().getPostsByUser(userId);
        model.addAttribute("user",user);
        model.addAttribute("posts",posts);
        return "profile";
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

    @GetMapping("/forums/{postId}")
    public String postPage(@PathVariable String postId,
                           Model model)
    {
        Post post = dbService.getPostRepository().getPostById(postId);
        String username = dbService.getUserRepository().getUserById(post.getUser()).getUsername();
        List<Comment> comments = dbService.getCommentRepository().getCommentByPost(postId);

        model.addAttribute("username",username);
        model.addAttribute("post",post);
        model.addAttribute("comments",comments);

        return "post";
    }

    @GetMapping("/deletePost/{postId}")
    public String deletePost(@PathVariable String postId)
    {
        Post post = dbService.getPostRepository().getPostById(postId);
        User user = dbService.getUserRepository().getUserById(post.getUser());

        //remove post id from user db
        List<String> userPosts = user.getPosts();
        userPosts.remove(postId);
        user.setPosts(userPosts);

        //delete all comments of the post from comment repository
        dbService.getCommentRepository().deleteCommentsByPost(postId);

        //delete the post
        dbService.getPostRepository().deletePostById(postId);

        return "redirect:/forums";
    }

    //POST MAPPINGS
    @PostMapping("/createAccount")
    public String newAccount(@ModelAttribute("user") User user)
    {
        if(user == null)
        {
            return "error";
        }

        String password = user.getPassword();

        user.setPassword(new PasswordEncryptor().encode(user.getPassword()));
        user.setRole("USER");
        user.setPosts(new ArrayList<String>());

        dbService.getUserRepository().save(user);
        return "redirect:/index";
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
                model.addAttribute(user);
                Cookie cookie = new Cookie("userid", user.getId());
                response.addCookie(cookie);
                return "redirect:profile";
            }
            else
            {
                System.out.println("evaluated as wrong");
                return "redirect:login";
            }
        }
        catch (Exception e)
        {
            return "error";
        }
    }



    @PostMapping("/addPost")
    public String addNewPost(@ModelAttribute("post") Post post,
                             @CookieValue(value = "userid") String userid,
                             Model model)
    {
        String s = post.getTags().get(0);
        post.setTags(Arrays.asList(s.split(" ")));
        Vote vote = new Vote();
        dbService.getVoteRepository().save(vote);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        post.setTimestamp(timestamp.toString());

        List<String> arr = new ArrayList<>();
        post.setComments(arr);
        post.setVote(vote.getId());
        post.setUser(userid);
        dbService.getPostRepository().save(post);

        User user = dbService.getUserRepository().getUserById(userid);
        user.getPosts().add(post.getId());
        dbService.getUserRepository().save(user);
//        System.out.println(post);
        return "redirect:forums";
    }

    @PostMapping("/addLink")
    public String addNewLink(@ModelAttribute("link") Link link)
    {
        dbService.getLinkRepository().save(link);
        return "redirect:links";
    }

    @PostMapping("/addPlaylist")
    public String addNewPlaylist(@ModelAttribute("playlist") Playlist playlist)
    {
        dbService.getPlaylistRepository().save(playlist);
        return "redirect:playlists";
    }

    @PostMapping("addComment/{postId}")
    public String makeComment(@PathVariable("postId") String postId,
                              @ModelAttribute("comment") Comment comment,
                              @CookieValue(value = "userid") String userId)
    {
        if(comment.getCommentContent().trim() == "")
        {
            return "redirect:/forums/" + postId;
        }
        comment.setPost(postId);
        comment.setUser(dbService.getUserRepository().getUserById(userId).getUsername());
        dbService.getCommentRepository().save(comment);
        return "redirect:/forums/" + postId;
    }
}
    