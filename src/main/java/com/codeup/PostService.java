package com.codeup;

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

    private void createPosts(){
        for(long i = 0; i < 10; i++){
            posts.add(new Post("title" + i, "body" + i, i));
        }
    }

    public List<Post> all(){
        return posts;
    }

    public Post onePost(long id){
        for(int i = 0; i < posts.size(); i++){
            if(posts.get(i).getId() == id){
                return posts.get(i);
            }
        }
        return null;
    }



}
