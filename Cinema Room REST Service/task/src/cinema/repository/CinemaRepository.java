package cinema.repository;


import cinema.model.Seat;
import lombok.Data;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Data
public class CinemaRepository {

    private int total_rows = 9;
    private int total_columns = 9;
    private List<Seat> available_seats = new ArrayList<>();

    public List<Seat> getAvailable_seats() {
        return getAllSeats();
    }

    private List<Seat>getAllSeats(){
            for (int i = 1; i <= total_rows ; i++) {
                for (int j = 1; j <=  total_columns; j++) {
                    available_seats.add(new Seat(i,j));
                }
            }
            return available_seats;
        }

    }



