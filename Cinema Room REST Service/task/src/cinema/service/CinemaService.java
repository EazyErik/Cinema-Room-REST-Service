package cinema.service;


import cinema.model.*;
import cinema.repository.CinemaRepository;
import cinema.repository.PasswordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CinemaService {


    private final CinemaRepository cinemaRepository;

    private final PasswordRepository passwordRepository;



    public CinemaService(CinemaRepository cinemaRepository, PasswordRepository passwordRepository) {
        this.cinemaRepository = cinemaRepository;
        this.passwordRepository = passwordRepository;
    }

    public Cinema getCinemaInfos() {
        return cinemaRepository.getCinema();

    }

    public CinemaDTO getCinema(){
        Cinema cinema = cinemaRepository.getCinema();
        int totalRows = cinema.getTotal_rows();
        int totalColumns = cinema.getTotal_columns();
        List<SeatDTO> availableSeats = cinema.getAvailable_seats()
                .stream().
                map(ticketWithToken -> {
                    return new SeatDTO(ticketWithToken);
                }).toList();


        return new CinemaDTO(totalRows,totalColumns,availableSeats);
    }




    public boolean isInCinema(Seat seat) {

        return cinemaRepository.isInCinema(seat);
    }

    public boolean isSeatTaken(Seat seat) {
        return cinemaRepository.isSeatTaken(seat);
    }


    public Object buyTicket(Seat seat) {

        return cinemaRepository.bookTicket(seat);

    }

    public SoldTicket findTicketByToken(String token) {
        SoldTicket soldTicket = new SoldTicket();
        soldTicket.setReturned_ticket(cinemaRepository.findTicketByToken(token));
        return soldTicket;

    }
    public boolean isFoundByToken(String token){
        return cinemaRepository.isFoundByToken(token);
    }

    public Statistic showStatistics() {

        Cinema cinema = cinemaRepository.getCinema();
        int income = 0;
        int availableSeats = 81;
        int numberSoldTickets = 0;
        List<TicketWithToken> seats = cinema.getAvailable_seats();
        for(TicketWithToken ticketWithToken : seats){
            if(ticketWithToken.getTicket().isBooked()){
                availableSeats --;
                numberSoldTickets ++;
                income += ticketWithToken.getTicket().getPrice();
            }

        }


        return new Statistic(income,availableSeats,numberSoldTickets);
    }

    public boolean checkPassword(String password) {
        return passwordRepository.checkPassword(password);

    }
}
