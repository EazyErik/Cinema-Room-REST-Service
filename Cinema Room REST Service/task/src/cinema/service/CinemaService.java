package cinema.service;


import cinema.model.Cinema;
import cinema.model.ErrorMesssage;
import cinema.model.Seat;
import cinema.model.Ticket;
import cinema.repository.CinemaRepository;
import org.springframework.stereotype.Service;


@Service
public class CinemaService {


    private final CinemaRepository cinemaRepository;

    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public Cinema getCinemaInfos() {
        return cinemaRepository.getCinema();

    }

    public boolean isInCinema(Seat seat) {

        return cinemaRepository.isInCinema(seat);
    }

    public boolean isSeatTaken(Seat seat) {
        return cinemaRepository.isSeatTaken(seat);
    }


    public Object buyTicket(Seat seat) {

        cinemaRepository.bookTicket(seat);
        Ticket currentTicket = new Ticket();
        currentTicket.setColumn(seat.getColumn());
        currentTicket.setRow(seat.getRow());
        if (seat.getRow() > 4) {
            currentTicket.setPrice(8);
        } else {
            currentTicket.setPrice(10);
        }

        return currentTicket;


    }
}
