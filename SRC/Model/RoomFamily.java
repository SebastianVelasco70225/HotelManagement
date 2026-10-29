package SRC.Model;


public class RoomFamily extends Room{
    
    public RoomFamily(Hotel hotel, int id, boolean lookSea, int floor, int camaSimple, boolean tvPremiun){
        super(hotel, id, lookSea);
        setValidFloor(floor);
        this.type = "Habitacion Family";
        this.State = "Habilitada";
        this.bedConfigurationRoom = new int [] { setcamasSimples(camaSimple), 2 };
        setAbility(bedConfigurationRoom);
        setTVPremiun(tvPremiun);
    }

    @Override 

    public void setValidFloor(int floor){
        if (floor < (hotel.getTotalFloor() - 1 )){
            this.floor = floor;
        } else {
            throw new IllegalArgumentException("Para este tipo de habitacion, el piso no coincide ");
        }
    }

    public int setcamasSimples(int camaSimples){
        if (camaSimples >= 2 && camaSimples <= 4  ){
            return camaSimples;
        } else {
            throw new IllegalArgumentException("El numero de camas Simples no es correcta");
        }
    }

}
