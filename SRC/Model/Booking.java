package SRC.Model;

public class Booking {
    private Guest responsableGuest;
    private int id;
    private Room room;
    private int guestCount;
    private int nightCount;
    private String state;
    private float price;
    
    //Constructor
    public Booking(Guest responsableGuest, int id, Room room, int guestCount, int nightCount){
        setResponsableGuest(responsableGuest);
        setId(id);
        setRoom(room);
        setGuestCount(guestCount);
        setNightCount(nightCount);
        setState("Pendiente");
    }

    //Métodos

    public Guest getResponsableGuest() {
        return responsableGuest;
    }

    public void setResponsableGuest(Guest responsableGuest) {
        this.responsableGuest = responsableGuest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(int guestCount) {
        if (guestCount<0||guestCount==0){
            throw new IllegalArgumentException("El número de huéspedes debe ser mayor a 0");
        }
        this.guestCount = guestCount;
    }

    public int getNightCount() {
        return nightCount;
    }

    public void setNightCount(int nightCount) {
        if (nightCount==0||nightCount<0){
            throw new IllegalArgumentException("El número de noches de la reserva debe ser mayor a 0");
        }
        this.nightCount = nightCount;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        if(!(state.toLowerCase().trim().equals("pendiente"))||!(state.toLowerCase().trim().equals("confirmada"))||!(state.toLowerCase().trim().equals("cancelada")))
        {
            throw new IllegalArgumentException("El estado de la reserva es inválido");
        }
        this.state= state;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
