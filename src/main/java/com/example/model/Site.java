package com.example.model;

import javax.persistence.*;


@Entity
@Table(name = "site")
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String siteName;

    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}

