package com.codeup.Controllers;

import com.codeup.Models.Post;
import com.codeup.Services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class PostController {
    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String postIndex(Model model){
        model.addAttribute("posts", this.postService.all());
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postIndividualPost(@PathVariable long id, Model model){
        model.addAttribute("post", this.postService.findPost(id));
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String getCreatePost(Model model){
        model.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String save(Post post){
        postService.createPost(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, Model model){
        Post post = postService.findPost(id);
        model.addAttribute("post", post);
        return "/posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String saveEdit(@ModelAttribute Post post){
        System.out.println(post.getTitle());
//        code to save edit to id
        return "redirect:/posts" + post.getId();
    }

}
