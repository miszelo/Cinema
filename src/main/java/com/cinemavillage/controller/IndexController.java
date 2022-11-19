package com.cinemavillage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    private final static String HOME_PAGE = "home_page";
    private final static String HOME_PAGE_LOGGED = "home_page_logged";
    private final static String CINEMA = "cinemaHallLayout";

    @RequestMapping("/")
    public ModelAndView homePage() {
        return new ModelAndView(HOME_PAGE);
    }

    @RequestMapping("/home")
    public ModelAndView homePageLogged() {
        return new ModelAndView(HOME_PAGE_LOGGED);
    }

    @RequestMapping("/cinema")
    public ModelAndView cinema() {
        return new ModelAndView(CINEMA);
    }

}
