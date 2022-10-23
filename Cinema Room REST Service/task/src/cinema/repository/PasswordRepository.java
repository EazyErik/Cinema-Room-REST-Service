package cinema.repository;

import org.springframework.stereotype.Component;

@Component
public class PasswordRepository {


    public boolean checkPassword(String password){
        return password.equals("super_secret");
    }




}
