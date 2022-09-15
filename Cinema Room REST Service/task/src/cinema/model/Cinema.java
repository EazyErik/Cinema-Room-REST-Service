package cinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cinema{

    private int total_rows;
    private int total_columns;
    private List<Seat> available_seats;

}
