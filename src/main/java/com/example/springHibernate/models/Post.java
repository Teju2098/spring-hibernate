package com.example.springHibernate.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "post")
public class Post {

    @Id
    private Integer id;
    @Column(name = "post_date")
    private LocalDateTime postdate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private  User user;
    private String details;

    public Post() {

    }

    public Post(Integer id, LocalDateTime postdate, User user, String details) {
        super();
        this.id = id;
        this.postdate = postdate;
        this.user = user;
        this.details = details;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getPostdate() {
        return postdate;
    }

    public void setPostdate(LocalDateTime postdate) {
        this.postdate = postdate;
    }


    @JsonBackReference
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
