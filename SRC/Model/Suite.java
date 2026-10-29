package SRC.Model;

public class Suite extends Room {

    // Atributos

    private boolean minibar;
    

    // Constructor 

    public  Suite(Hotel hotel, int id, boolean lookSea, int floor){
        super(hotel, id, lookSea);
        setValidFloor(floor);
        this.type = "Suite";
        this.State = "Habilitada";
        this.bedConfigurationRoom = new int [] {0, 1};
        setAbility(bedConfigurationRoom);
        this.tvPremiun = true;
        this.minibar = true;
    }

    
    @Override 
    
    public void setValidFloor(int floor){
        if (floor >= (hotel.getTotalFloor() - 1 ) || floor  <= hotel.getTotalFloor()){
            this.floor = floor;
        } else {
            throw new IllegalArgumentException("Para esta habitacion, el piso no coincide");
        }
    }
    
    public boolean isMinibar() {
        return minibar;
    }
}
