package com.blibli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ADIN on 4/22/2017.
 */


@Controller
//this controller used for webpage mapping
public class AppController {

    //likely... this calls the folders
    //this mapping to access offices page
    @RequestMapping("/")
    String home(ModelMap modal) {
        modal.addAttribute("title","Bliblibli");
        return "index";
    }

    @RequestMapping("/partials/{page1}")
    String partialHandler(@PathVariable("page1") final String page1) {
        return page1;
    }

    @RequestMapping("/partials/{page1}/{page2}")
    String partialHandler(@PathVariable("page1") final String page1,@PathVariable("page2") final String page2) {
        return page1+"/"+page2;
    }

}

