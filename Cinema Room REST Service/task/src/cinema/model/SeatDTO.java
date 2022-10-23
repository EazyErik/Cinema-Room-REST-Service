package cinema.model;

public class SeatDTO {

    private int row;
    private int column;

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public SeatDTO() {
    }

    public SeatDTO(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public SeatDTO(TicketWithToken ticketWithToken) {
        this.row = ticketWithToken.getTicket().getRow();
        this.column = ticketWithToken.getTicket().getColumn();
        this.price = ticketWithToken.getTicket().getPrice();
    }
}
