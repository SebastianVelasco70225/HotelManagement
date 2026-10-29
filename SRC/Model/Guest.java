package SRC.Model;

public class Guest {
    private String name;
    private int id;
    private int cedula;
    private int telephone;
    private String email;
    
    // Constructor
    public Guest (String name, int id, int cedula, int telephone, String email){
        setName(name);
        setId(id);
        setCedula(cedula);
        setTelephone(telephone);
        setEmail(email);
    }

    // Métodos

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
