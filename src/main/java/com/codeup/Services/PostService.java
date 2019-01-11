package com.codeup.Services;

import com.codeup.Models.Post;
import com.codeup.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postDao;

    @Autowired
    public PostService(PostRepository postDao){
        this.postDao = postDao;
//        createPosts();
    }

    public Iterable<Post> all(){
        return postDao.findAll();
    }

    public Post findPost(long id){
        return postDao.findOne(id);
    }

    public Post createPost(Post post){
        postDao.save(post);
        return post;
    }

    public boolean deletePost(long id){
        postDao.delete(id);
        return postDao.exists(id);
    }

//    private void createPosts(){
//        for(long i = 0; i < 10; i++){
//            createPost(new Post("title" + i, "body" + i));
//        }
//    }




}
