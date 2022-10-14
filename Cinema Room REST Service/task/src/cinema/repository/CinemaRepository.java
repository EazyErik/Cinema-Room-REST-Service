package cinema.repository;

import cinema.model.Cinema;
import cinema.model.Seat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CinemaRepository {

    private Cinema cinema = new Cinema();

    public CinemaRepository() {
        cinema.setTotal_rows(9);
        cinema.setTotal_columns(9);

        List<Seat> available_seats = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if(i > 4 ) {
                    available_seats.add(new Seat(i, j,8));
                }
                else{
                    available_seats.add(new Seat(i, j,10));
                }

            }
        }
        cinema.setAvailable_seats(available_seats);



    }

    public Cinema getCinema() {
        return cinema;
    }

    public void bookTicket(Seat seat) {

        List<Seat> temp = new ArrayList<>();


        for (Seat place : cinema.getAvailable_seats()) {
            if (seat.getRow() == place.getRow() && seat.getColumn() == place.getColumn()) {

                continue;
            }
            temp.add(place);

        }
        cinema.setAvailable_seats(temp);
    }


    public boolean isSeatTaken(Seat seat) {
        for (Seat place : cinema.getAvailable_seats()) {

            if (seat.getRow() == place.getRow() && seat.getColumn() == place.getColumn()) {
                return false;

            }

        }

        return true;

    }

    public boolean isInCinema(Seat seat) {
        if (seat.getRow() > cinema.getTotal_rows() || seat.getColumn() > cinema.getTotal_columns()) {
            return false;
        }
        if(seat.getRow() < 1 || seat.getColumn() < 1) {
            return false;
        } else {
            return true;
        }
    }


}




