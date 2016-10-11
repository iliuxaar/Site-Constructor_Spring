package com.example.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String userId;

    @Column
    private String name;

    @Column
    private String role;

//    @OneToMany(mappedBy = "User", cascade = CascadeType.ALL)
//    private Set<Site> sites;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    public Set<Site> getSites() {
//        return sites;
//    }
//
//    public void setSites(Set<Site> sites) {
//        this.sites = sites;
//    }
}
