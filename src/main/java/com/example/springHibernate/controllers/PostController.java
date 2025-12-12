package com.example.springHibernate.controllers;

import com.example.springHibernate.models.Post;
import com.example.springHibernate.services.PostService;
import com.example.springHibernate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/posts/{id}")
    public Optional<Post> getPostById(@PathVariable Integer id) {
        return postService.findById(id);
    }

    @GetMapping("/posts/user/{id}/posts")
    public List<Post> GetPostsByUser(@PathVariable Integer id) {
        return postService.getPostsByUser(id);
    }

    @PostMapping("/posts/addNew")
    public void AddPost(@RequestBody Post post) {
        postService.addPost(post);
    }

    @PutMapping("/posts/{id}/update")
    public void UpdatePost(@RequestBody Post post) {
        postService.updatePost(post);
    }
    @DeleteMapping("/post/{id}/delete")
    public void DeletePost(@PathVariable Integer id) {
        postService.DeletePost(id);
    }
}
