package cinema.repository;


import cinema.model.Seat;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CinemaRepository {

   private final List<Seat> available_seats = new ArrayList<>();





    public int getTotal_rows() {
        return 9;
    }

    public int getTotal_columns() {
        return 9;
    }

    public List<Seat>getAllSeats(){
            for (int i = 1; i <= 9 ; i++) {
                for (int j = 1; j <=  9; j++) {
                    available_seats.add(new Seat(i,j));
                }
            }
            return available_seats;
        }

    }



