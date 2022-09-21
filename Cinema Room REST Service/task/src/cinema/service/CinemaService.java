package cinema.service;


import cinema.model.Cinema;
import cinema.repository.CinemaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service

public class CinemaService {

    private final CinemaRepository cinemaRepository;

    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public Cinema getCinemaInfos() {
        return new Cinema(
                cinemaRepository.getTotal_rows(),
                cinemaRepository.getTotal_columns(),
                cinemaRepository.getAllSeats()
        );
    }
}
