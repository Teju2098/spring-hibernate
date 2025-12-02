package com.example.springHibernate.models;

//import jakarta.persistence.Entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;

@Entity
@Table(name = "location")
public class Location {

    @Id
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "location")
    private List<User> users;

    @JsonManagedReference
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Location(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Location() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
