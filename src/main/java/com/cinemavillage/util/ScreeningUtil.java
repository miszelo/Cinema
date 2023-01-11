package com.cinemavillage.util;

import com.cinemavillage.model.Seat;

import java.util.List;

public final class ScreeningUtil {
    public static List<Seat> setNewSeatState(List<Seat> seatState) {
        for (int row = 1; row < 8; row++) {
            for (int column = 1; column < 15; column++) {
                seatState.add(new Seat(row, column, false));
            }
        }
        return seatState;
    }
}
