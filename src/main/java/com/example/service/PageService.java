package com.example.service;


import com.example.model.Page;
import com.example.model.Site;

import java.util.List;

public interface PageService {
    Page findById(long id);

    List<Page> findBySite(Site site);

    void save(Page page);

    void delete(long id);

}
