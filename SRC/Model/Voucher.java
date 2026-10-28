package SRC.Model;

public class Voucher {
    private int number;
    private Booking booking;
    
    // Constructores
    public Voucher(int number, Booking booking){
        setBooking(booking);
        setNumber();
    }

    // Métodos

    public int getNumber() {
        return number;
    }
    public void setNumber() {
        number=booking.getId();
    }
    public Booking getBooking() {
        return booking;
    }
    public void setBooking(Booking booking) {
        this.booking = booking;
    }


}
