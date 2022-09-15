package cinema.service;


import cinema.model.Cinema;
import cinema.repository.CinemaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CinemaService {

    private final CinemaRepository cinemaRepository;

    public Cinema getCinemaInfos() {
        return new Cinema(
                cinemaRepository.getTotal_rows(),
                cinemaRepository.getTotal_columns(),
                cinemaRepository.getAvailable_seats()
        );
    }
}
