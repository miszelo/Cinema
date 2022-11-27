package com.cinemavillage.controller;

import com.cinemavillage.model.hall.Hall;
import com.cinemavillage.model.movie.Movie;
import com.cinemavillage.repository.HallRepository;
import com.cinemavillage.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class IndexController {

    private final static String HOME_PAGE = "home_page";
    private final static String HOME_PAGE_LOGGED = "home_page_logged";
    private final static String CINEMA = "cinemaHallLayout";

    private final HallRepository hallRepository;

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
    public String homePageLogged(Model model) {

        //findAll - for testing purpose only, should be found by date
        List<Movie> movies = movieRepository.findAll();
        model.addAttribute("movies", movies);
        return HOME_PAGE_LOGGED;
    }

    @RequestMapping("/cinema")
    public String cinema() {
        return CINEMA;
    }
}
