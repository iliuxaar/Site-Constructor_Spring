package com.example.controller;

import com.example.model.Page;
import com.example.model.Site;
import com.example.service.PageService;
import com.example.service.SiteService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class PageController {
    @Autowired
    SiteService siteService;

    @Autowired
    UserService userService;

    @Autowired
    PageService pageService;

    @RequestMapping(value = "/site/pages/{site_id}", method = RequestMethod.GET)
    public List<Page> getSitePages(@PathVariable("site_id") Long id){
        List<Page> pages;
        pages = pageService.findBySite(siteService.findById(id));
        return pages;
    }

    @RequestMapping(value = "/site/page/{page_id}", method = RequestMethod.GET)
    public @ResponseBody
    Page getPage(@PathVariable("page_id")long id){
        Page page;
        page = pageService.findById(id);
        return page;
    }


    @RequestMapping(value = "/site/page/{id}/delete", method = RequestMethod.GET)
    public void deletePage(@PathVariable("id")long id){
        pageService.delete(id);
    }


    @RequestMapping(value = "/site/page/{site_id}/save", method = RequestMethod.POST)
    public void savePage(@RequestBody Map map,@PathVariable("site_id") long id){
        Page page;
        if(map.get("id")!= null){
            long id1 = Long.valueOf((int)map.get("id"));
            page = pageService.findById(id1);
            page.setContent((String) map.get("content"));
            page.setPageName((String) map.get("name"));
            pageService.save(page);
        }
        else {
            page = new Page();
            page.setContent((String) map.get("content"));
            page.setPageName((String) map.get("name"));
            page.setSite(siteService.findById(id));
            pageService.save(page);
        }
    }

}