package SRC.Model;

public class Hotel {

    // Atributos

    private int id;
    private String name;
    private String adress;
    private int floorCount;
    private Room [] rooms;
    private float tbh, tcs, tmi, pvm, rcp, TCD1, TCD2, TPA, RVM, RPI, TBA;
    private Booking [] booking;
    private Guest [] guest;
    // Constructor

    public Hotel(int id, String name, String adress, int floorCount, Room [] rooms, float tbh, float tcs, float tmi, float pvm, float rcp){
        setId(id);
        setName(name);
        setAdress(adress);
        setFloorCount(floorCount);
        setRooms(rooms);
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
    
    public int getFloorCount() {
        return floorCount;
    }
    
    public void setFloorCount(int floorCount) {
        if (comprobation(floorCount)) {
            this.floorCount = floorCount;
            return;
        }
        throw new IllegalArgumentException("El número de pisos debe ser positivo");
    }
    
    public Room [] getRooms() {
        return rooms;
    }
    
    public void setRooms(Room [] rooms) {
        this.rooms = rooms;
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
    
    public Booking[] getBooking() {
        return booking;
    }

    public void setBooking(Booking[] booking) {
        this.booking = booking;
    }

    public Guest[] getGuest() {
        return guest;
    }

    public void setGuest(Guest[] guest) {
        this.guest = guest;
    }

    public boolean comprobation(float price){
        return price>0;
    }
}