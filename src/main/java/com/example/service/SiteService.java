package com.example.service;


import com.example.model.Site;
import com.example.model.User;

import java.util.List;


public interface SiteService {
    Site findById(long Id);

    void save(Site site);

    List<Site> findAll();

    List<Site> findByUser(User user);

    void delete(long id);
}
