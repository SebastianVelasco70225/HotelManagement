package SRC.Model;

public class RoomIndividual extends Room{
    
    // Constructor

    public RoomIndividual(Hotel hotel, int id, boolean lookSea, int floor, boolean tvPremiun){
        super(hotel, id, lookSea);
        setValidFloor(floor);
        this.type = "Habitacion individual";
        this.State = "Habilitada";
        this.bedConfigurationRoom = new int [] { 1, 0};
        setAbility(bedConfigurationRoom);
        setTVPremiun(tvPremiun);
    }

    @Override 

    public void setValidFloor(int floor){
        if (floor < (hotel.getTotalFloor() - 1 )){
            this.floor = floor;
        } else {
            throw new IllegalArgumentException("Para esta habitacion, el piso no coincide");
        }
    }


}
