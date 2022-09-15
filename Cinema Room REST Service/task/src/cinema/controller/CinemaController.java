package cinema.controller;


import cinema.model.Cinema;
import cinema.service.CinemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CinemaController {

    private final CinemaService cinemaService;

    @GetMapping("/seats")
    public Cinema getCinemaInfos(){
        return cinemaService.getCinemaInfos();

    }
}
