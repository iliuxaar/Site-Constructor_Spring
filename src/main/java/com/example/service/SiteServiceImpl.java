package com.example.service;


import com.example.model.Site;
import com.example.model.User;
import com.example.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteServiceImpl implements SiteService{

    @Autowired
    private SiteRepository siteRepository;

    @Override
    public void save(Site site) {
        siteRepository.save(site);
    }

    @Override
    public List<Site> findAll() {
        return siteRepository.findAll();
    }

    @Override
    public List<Site> findByUser(User user) {
        return siteRepository.findByUser(user);
    }

    @Override
    public void delete(long id) {
        siteRepository.delete(id);
    }

    @Override
    public Site findById(long id){
        return siteRepository.findById(id);
    }


}
