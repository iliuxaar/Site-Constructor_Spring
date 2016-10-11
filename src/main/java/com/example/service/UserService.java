package com.example.service;


import com.example.model.User;

public interface UserService {

    User findById(Long id);

    User findByUserId(String userId);

    void save(User user);

}
