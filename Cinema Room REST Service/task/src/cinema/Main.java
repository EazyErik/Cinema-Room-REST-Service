package cinema;


import cinema.repository.CinemaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        CinemaRepository repository = new CinemaRepository();
        System.out.println(repository.getAllSeats().size());


    }
}
