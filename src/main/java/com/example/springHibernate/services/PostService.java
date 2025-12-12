package com.example.springHibernate.services;

import com.example.springHibernate.models.Post;
import com.example.springHibernate.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll() {
        return (List<Post>) postRepository.findAll();
    }

    public Optional<Post> findById(Integer id) {
        return postRepository.findById(id);
    }

    public List<Post> getPostsByUser(Integer id) {
        return postRepository.findByUserId(id);
    }

    public void addPost(Post post) {
        postRepository.save(post);
    }

    public void updatePost(Post post) {
        postRepository.save(post);
    }

    public void DeletePost(Integer id) {
        postRepository.deleteById(id);
    }
}
