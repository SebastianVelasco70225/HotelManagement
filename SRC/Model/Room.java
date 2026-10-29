package SRC.Model;

public abstract class Room {

    // Atributos

    protected Hotel hotel;
    protected int floor;
    protected int id;
    protected String type;
    protected String State;
    protected int [] bedConfigurationRoom; 
    protected boolean lookSea;
    protected int ability;
    protected boolean tvPremiun = false;
    
    // Constructor
    public Room( Hotel hotel, int id, boolean sealook){
        this.hotel = hotel;
        setId(id);
        setSeaLook(sealook);
    }

    public abstract void setValidFloor(int floor);

    public void setAbility(int[] bed){
        int total = 0;
        total += bed[0];
        total += bed[1] * 2;
        this.ability = total;
    }

    public void setId(int id){
        if( id > 0 ) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("El id de la habitacion no es valido");
        }
    }

    public void  setSeaLook(boolean sealook){
        this.lookSea = sealook;
    }

    public void setTVPremiun(boolean TV){
        if (TV == true ) {
            this.tvPremiun = TV;
        }
    }

    public int getFloor() {
        return floor;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getState() {
        return State;
    }

    public int[] getBedConfigurationRoom() {
        return bedConfigurationRoom;
    }

    public boolean isLookSea() {
        return lookSea;
    }

    public int getAbility() {
        return ability;
    }

    public boolean isTvPremiun() {
        return tvPremiun;
    }


}
