package com.cinemavillage.controller;

import com.cinemavillage.model.Screening;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class ScreeningController {

    @GetMapping
    public Screening getHall() {

        return null;
    }

}
