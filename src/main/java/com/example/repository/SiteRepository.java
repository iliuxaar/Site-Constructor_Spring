package com.example.repository;

import com.example.model.Site;
import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface SiteRepository extends JpaRepository<Site,Long> {
    Site findById(long Id);
    List<Site> findAll();

    List<Site> findByUser(User user);



}