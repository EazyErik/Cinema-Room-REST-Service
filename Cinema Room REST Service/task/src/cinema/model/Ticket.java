package cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Ticket {

    int row;
    int column;
    int price;





    boolean isBooked = false;
    @JsonIgnore
    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Ticket(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
    }




    public Ticket() {
    }
}
