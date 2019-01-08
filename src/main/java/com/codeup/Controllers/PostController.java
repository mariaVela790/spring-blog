package com.codeup.Controllers;

import com.codeup.Models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String postIndex(Model model){
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("title", "description"));
        posts.add(new Post("title2", "description2"));
        model.addAttribute("posts", posts);
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postIndividualPost(@PathVariable long id, Model model){
        Post post = new Post("title", "description");
        model.addAttribute("post", post);
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String getCreatePost(){
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    public String createPost(){
        return "create a new post";
    }
}
