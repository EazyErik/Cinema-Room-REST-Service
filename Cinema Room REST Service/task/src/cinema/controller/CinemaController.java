package cinema.controller;


import cinema.model.Cinema;
import cinema.model.ErrorMesssage;
import cinema.model.Seat;
import cinema.model.Ticket;
import cinema.service.CinemaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class CinemaController {

    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/seats")
    public Cinema getCinemaInfos() {
        return cinemaService.getCinemaInfos();

    }

    @PostMapping("/purchase")
    public Object buyTicket(@RequestBody Seat seat) {

        Object response = null;

        if (!cinemaService.isInCinema(seat)) {
            response = new ErrorMesssage("The number of a row or a column is out of bounds!");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        } else if (cinemaService.isSeatTaken(seat)) {
            response = new ErrorMesssage("The ticket has been already purchased!");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } else {
            response = cinemaService.buyTicket(seat);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}
