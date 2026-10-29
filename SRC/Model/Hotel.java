package SRC.Model;
import java.util.List;

public class Hotel {

    // Atributos

    private int id;
    private String name;
    private String adress;
    private int totalFloor;
    private List<Room> rooms;
    private float tbh, tcs, tmi, pvm, rcp, TCD1, TCD2, TPA, RVM, RPI, TBA;
    private List<Booking> bookings;
    private List<Guest> guests;
    private List<Voucher> vouchers;
    // Constructor

    public Hotel(int id, String name, String adress, int totalFloor, float tbh, float tcs, float tmi, float pvm, float rcp){
        setId(id);
        setName(name);
        setAdress(adress);
        setTotalFloor(totalFloor);
        setTbh(tbh);
        setTcs(tcs);
        setTmi(tmi);
        setPvm(pvm);
        setRcp(rcp);
        setTCD1();
        setTCD2();
        setTPA();
    }
    
    // Metodos
    
    // Comprobación de ID único
    private boolean idExists(int idRoom) {
        for (Room r : this.rooms) {
            if (r.getId() == idRoom) {
                return true;
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
    
    public int getTotalFloor(){
        return totalFloor;
    }
    
    public void setTotalFloor(int totalFloor) {
        if (comprobation(totalFloor)) {
            this.totalFloor = totalFloor;
            return;
        }
        throw new IllegalArgumentException("El número de pisos debe ser positivo");
    }
    
    public List<Room> getRooms() {
        return rooms;
    }
    
    public float getTbh() {
        return tbh;
    }
    
    public void setTbh(float tbh) {
        if (comprobation(tbh)) {
            this.tbh = tbh;
            return;
        }
        throw new IllegalArgumentException("La tarifa base de habitación por noche debe ser positiva");
    }
    
    public float getTcs() {
        return tcs;
    }

    public void setTcs(float tcs) {
        if (comprobation(tcs)) {
        this.tcs = tcs;
        return;
        }
        throw new IllegalArgumentException("La tarifa de cama sencilla por noche debe ser positiva");
    }

    public float getTmi() {
        return tmi;
    }
    
    public void setTmi(float tmi) {
        if (comprobation(tmi)) {
        this.tmi = tmi;
        return;
        }
        throw new IllegalArgumentException("La tarifa de minibar por noche debe ser positiva");
    }
    
    public float getPvm() {
        return pvm;
    }
    
    public void setPvm(float pvm) {
        if (comprobation(pvm)) {
        this.pvm = pvm;
        return;
        }
        throw new IllegalArgumentException("El porcentaje de recargo por vista frente al mar debe ser positivo");
    }

    public float getRcp() {
        return rcp;
    }

    public void setRcp(float rcp) {
        if (!(rcp<0)) {
        this.rcp = rcp;
        return;
        }
        throw new IllegalArgumentException("El recargo por canales premium debe ser positivo");
    }
    
    public float getTCD1(){
        return TCD1;
    }

    public void setTCD1(){
        TCD1=(float) (tcs*1.45);
    }    

    public float getTCD2(){
        return TCD2;
    }

    public void setTCD2(){
        TCD2=(float) (tcs*1.90);
    }
    
    public float getTPA(){
        return TPA;
    }
    
    public void setTPA(){
        TPA=(float) (tcs*0.70);
    }
    
    public float getRVM(){
        return RVM;
    }
    
    public void setRVM(){
        RVM=(float) (tbh*(pvm/100));
    }
    
    public float getRPI() {
        return RPI;
    }

    public void setRPI(int floor) {
        if(!(floor<1)&&!(floor>3)){
            RPI=0;
            return;
        }
        else if(!(floor<4)&&!(floor>6)){
            RPI= (RVM*10)/100;
            return;
        }
        else if(floor==7||floor>7){
            RPI= (RVM*20)/100;
            return;
        }
        throw new IllegalArgumentException("El piso no puede ser negativo o 0");
    }


    public float getTBA() {
        return TBA;
    }

    public void setTBA() {
        TBA= tbh + RPI + RVM + rcp;
    }
    
    public List<Booking> getBooking() {
        return bookings;
    }

    public void setBooking(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuest(List<Guest> guests) {
        this.guests = guests;
    }

    public boolean comprobation(float price){
        return price>0;
    }

    public RoomIndividual createIndividualRoom(int id, boolean lookSea, int floor, boolean tvPremiun) {
        if (idExists(id)) {
            throw new IllegalArgumentException("Ya existe una habitación con el ID: " + id);
        }
        RoomIndividual room = new RoomIndividual(this, id, lookSea, floor, tvPremiun);
        this.rooms.add(room);
        return room;
    }

    public RoomDouble createDoubleRoom(int id, boolean lookSea, int floor, boolean tvPremiun) {
        if (idExists(id)) {
            throw new IllegalArgumentException("Ya existe una habitación con el ID: " + id);
        }
        RoomDouble room = new RoomDouble(this, id, lookSea, floor, tvPremiun);
        this.rooms.add(room);
        return room;
    }

    public RoomFamily createFamilyRoom(int id, boolean lookSea, int floor, int camaSimple, boolean tvPremiun) {
        if (idExists(id)) {
            throw new IllegalArgumentException("Ya existe una habitación con el ID: " + id);
        }
        RoomFamily room = new RoomFamily(this, id, lookSea, floor, camaSimple, tvPremiun);
        this.rooms.add(room);
        return room;
    }

    public Suite createSuite(int id, boolean lookSea, int floor) {
        if (idExists(id)) {
            throw new IllegalArgumentException("Ya existe una habitación con el ID: " + id);
        }
        Suite room = new Suite(this, id, lookSea, floor);
        this.rooms.add(room);
        return room;
    }

    public Booking createBooking(Guest responsableGuest, int id, Room room, int guestCount, int nightCount){
        
        return Booking;
    }
}