package com.cinemavillage.model;

import lombok.Data;

@Data
public class Seat {
    private int row;
    private int column;
    private boolean isTaken;
}
