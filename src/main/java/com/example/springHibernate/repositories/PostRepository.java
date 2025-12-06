package com.example.springHibernate.repositories;

import com.example.springHibernate.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

    List<Post> findByUserId(Integer id);
}
