package cinema.controller;


import cinema.model.*;
import cinema.service.CinemaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping()
public class CinemaController {

    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/seats")
    public CinemaDTO getCinemaInfos() {
        return cinemaService.getCinema();

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

    @PostMapping("/return")

    public Object returnedTicket(@RequestBody TokenForTicket token) {
        Object response;



        if(cinemaService.isFoundByToken(token.getToken())){
            response = cinemaService.findTicketByToken(token.getToken());

            return  new ResponseEntity<>(response, HttpStatus.OK);

        }else{
            response = new ErrorMesssage("Wrong token!");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);


        }

    }
    @PostMapping("/stats")
    public Object showStatistics(@RequestParam(required = false) String password){
        Object response;
        if(password == null ||Objects.isNull(password) || !cinemaService.checkPassword(password)){
            response = new ErrorMesssage("The password is wrong!");
            return new ResponseEntity<>(response,HttpStatus.UNAUTHORIZED);

        }
         return cinemaService.showStatistics();


    }



}
