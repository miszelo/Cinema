package com.cinemavillage.model;

import lombok.Data;

@Data
public class Seat {
    private int row;
    private int column;
    private boolean isTaken;

    public Seat(int row, int column, boolean isTaken) {
        this.row = row;
        this.column = column;
        this.isTaken = isTaken;
    }
}
