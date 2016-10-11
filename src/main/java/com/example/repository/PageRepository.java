package com.example.repository;


import com.example.model.Page;
import com.example.model.Site;
import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PageRepository extends JpaRepository<Page,Long>{
    Page findById(long id);

    List<Page> findBySite(Site site);
}
