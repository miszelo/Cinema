package com.cinemavillage.controller;

import com.cinemavillage.model.Hall;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class HallController {

    @GetMapping
    public Hall getHall() {

        return null;
    }

}
