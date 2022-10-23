package cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TicketWithToken {

    private Ticket ticket;


    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TicketWithToken(Ticket ticket, String token) {
        this.ticket = ticket;
        this.token = token;
    }

    public TicketWithToken() {
    }
}
