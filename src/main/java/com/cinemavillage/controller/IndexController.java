package com.cinemavillage.controller;

import com.cinemavillage.model.movie.Movie;
import com.cinemavillage.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class IndexController {

    private final static String HOME_PAGE = "home_page";
    private final static String HOME_PAGE_LOGGED = "home_page_logged";
    private final static String CINEMA = "cinemaHallLayout";

    private final MovieRepository movieRepository;

    @RequestMapping("/")
    public ModelAndView homePage() {
        return new ModelAndView(HOME_PAGE);
    }
//    @RequestMapping("/")
//    public ModelAndView homePagedffd() {
//        List<?> s  = hallRepository.getAll();
//        ModelAndView modelAndView = new ModelAndView(HOME_PAGE);
//        modelAndView.addObject(s);
//    }

    @RequestMapping("/home")
    public ModelAndView homePageLogged() {
        System.out.println("EEEEEEE");
        ModelAndView model = new ModelAndView(HOME_PAGE_LOGGED);
        Movie movie = movieRepository.findMovieById("6378ae0fdc32216566ac95fd");
        System.out.println(movie.toString());
        model.addObject("movieTitle", movie.getTitle());
        model.addObject("movieTime", movie.getDateOfScreening());
        return model;
    }

    @RequestMapping("/cinema")
    public ModelAndView cinema() {
        return new ModelAndView(CINEMA);
    }

}
