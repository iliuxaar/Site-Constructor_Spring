package com.example.controller;

import com.example.model.Site;
import com.example.model.User;
import com.example.service.SiteService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class SiteController {

    @Autowired
    SiteService siteService;

    @Autowired
    UserService userService;

    @Autowired
    SiteController(SiteService siteService){this.siteService = siteService;}

    @RequestMapping(value = "/site/get_all", method = RequestMethod.GET)
    public @ResponseBody List<Site> getAllSites(){
        List<Site> sites;
        sites = siteService.findAll();
        return sites;
    }

    @RequestMapping(value = "/site/get_user_data", method = RequestMethod.GET)
    public @ResponseBody List<Site> getUserSites(Authentication principal){
        List<Site> sites;
        User user;
        user = userService.findByUserId((String)principal.getCredentials());
        sites = siteService.findByUser(user);
        return sites;
    }

    @RequestMapping(value = "/site/info/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Site viewSite( @PathVariable("id") long id,Authentication principal){
        Site site;
        site = siteService.findById(id);
        User user = site.getUser();
        if (user.getUserId().equals((String)principal.getCredentials()))
            return site;
        else
            return null;
    }

    @RequestMapping(value = "/site/{id}/delete", method = RequestMethod.GET)
    public void deleteSite(@PathVariable("id")long id){
        siteService.delete(id);
    }

    @RequestMapping(value = "/site/update", method = RequestMethod.POST)
    public void updateSite(@RequestBody Map map){
        Site site = siteService.findById((Long)map.get("id"));
        siteService.save(site);
    }

    @RequestMapping(value = "/site/save", method = RequestMethod.POST)
    public void saveSite(@RequestBody String name, Authentication principal,HttpServletResponse response)throws IOException{
        Site site = new Site();
        site.setSiteName(name);
        site.setUser(userService.findByUserId((String)principal.getCredentials()));
        siteService.save(site);
    }
}