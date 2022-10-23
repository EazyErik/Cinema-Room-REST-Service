package cinema.repository;

import cinema.model.Cinema;
import cinema.model.Seat;
import cinema.model.Ticket;
import cinema.model.TicketWithToken;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class CinemaRepository {

    private Cinema cinema = new Cinema();

    public CinemaRepository() {
        cinema.setTotal_rows(9);
        cinema.setTotal_columns(9);


        Ticket ticket;

        List<TicketWithToken> available_seats = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                String uuid = UUID.randomUUID().toString();

                if (i > 4) {
                    ticket = new Ticket(i, j, 8);
                    available_seats.add(new TicketWithToken(ticket, uuid));
                } else {
                    ticket = new Ticket(i, j, 10);
                    available_seats.add(new TicketWithToken(ticket, uuid));

                }

            }
        }
        cinema.setAvailable_seats(available_seats);


    }

    public Cinema getCinema() {
        return cinema;
    }

    public TicketWithToken bookTicket(Seat seat) {
        TicketWithToken response = new TicketWithToken();

        List<TicketWithToken> temp = new ArrayList<>();


        for (TicketWithToken place : cinema.getAvailable_seats()) {
            if (seat.getRow() == place.getTicket().getRow() && seat.getColumn() == place.getTicket().getColumn()) {

                Ticket tempTicket;
                tempTicket = place.getTicket();
                tempTicket.setBooked(true);
                place.setTicket(tempTicket);
                response = place;

            }
            temp.add(place);

        }
       cinema.setAvailable_seats(temp);
        return response;
    }


    public boolean isSeatTaken(Seat seat) {
        for (TicketWithToken place : cinema.getAvailable_seats()) {

            if (seat.getRow() == place.getTicket().getRow() && seat.getColumn() == place.getTicket().getColumn()) {
                if(place.getTicket().isBooked()){
                    return true;
                }
            }

        }

        return false;

    }

    public boolean isInCinema(Seat seat) {
        if (seat.getRow() > cinema.getTotal_rows() || seat.getColumn() > cinema.getTotal_columns()) {
            return false;
        }
        if (seat.getRow() < 1 || seat.getColumn() < 1) {
            return false;
        } else {
            return true;
        }
    }

    public Ticket findTicketByToken (String token) {
        List<TicketWithToken> temp = new ArrayList<>();
        Ticket response = null;
        for (TicketWithToken place : cinema.getAvailable_seats()) {
            if (token.equals(place.getToken())) {

                if(place.getTicket().isBooked()){

                    Ticket tempTicket;
                    tempTicket = place.getTicket();
                    tempTicket.setBooked(false);
                    place.setTicket(tempTicket);

                    response = place.getTicket();
                }
                temp.add(place);
            }

        }
        return response;
    }
public boolean isFoundByToken(String token) {


    for (TicketWithToken place : cinema.getAvailable_seats()) {
        if (token.equals(place.getToken())) {

            if(place.getTicket().isBooked()){

               return true;


            }

        }

    }
    return false;

}

}




