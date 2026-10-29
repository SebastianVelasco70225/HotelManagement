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
        Voucher voucher= new Voucher(this);
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
        } else if (guestCount>room.getAbility()) {
            throw new IllegalArgumentException("La cantidad de huéspedes excede la capacidad de la habitación");
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

    public void setPrice(float tbh, float tcs, float tmi, float pvm, float rcp, float TCD1, float TCD2, float TPA, float RVM, float RPI, float TBA) {
        switch (room.getType()) {
            case "Habitacion individual":
                    price=TBA+tcs;
                    break;
            case "Habitacion Doble":
                if (guestCount==1) {
                    price=TBA+TCD1;
                    return;
                } 
                price=TBA+TCD2;
                break;
            case "Habitacion Family":
                if (guestCount<7) {
                    price=TBA+(TCD2*2)+(tcs*2);
                    return;
                }
                price=TBA+(TCD2*2)+(tcs*2)+tcs*(70/100);
                break;
            case "Suite":
                price=TBA+TCD2+tmi;
                break;
            default:
                throw new IllegalArgumentException("No existe ese tipo de habitación");
        }
    }

    public void changeState(boolean confirmation){
        if(confirmation){
            state="Confirmada";
            return;
        }
        state="Cancelada";
    }
}
