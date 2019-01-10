package com.codeup.Services;

import com.codeup.Models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private List<Post> posts;

    @Autowired
    public PostService(){
        posts = new ArrayList<>();
        createPosts();
    }

    public List<Post> all(){
        return posts;
    }

    public Post findPost(long id){
        return posts.get((int)id - 1);
    }

    public Post createPost(Post post){
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }

    private void createPosts(){
        for(long i = 0; i < 10; i++){
            createPost(new Post("title" + i, "body" + i));
        }
    }




}
