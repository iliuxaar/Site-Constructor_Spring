package com.example.service;


import com.example.model.Page;
import com.example.model.Site;
import com.example.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl implements PageService{
    @Autowired
    private PageRepository pageRepository;

    @Override
    public Page findById(long id) {
        return pageRepository.findById(id);
    }

    @Override
    public List<Page> findBySite(Site site) {
        return pageRepository.findBySite(site);
    }

    @Override
    public void save(Page page) {
        pageRepository.save(page);
    }

    @Override
    public void delete(long id) {
        pageRepository.delete(id);
    }


}
