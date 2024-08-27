package project.java.app.DTO;

public class PersonsDto {
    private long Id, cedula;
    private String name, celPhone;

    public PersonsDto() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getCelPhone() {
        return celPhone;
    }

    public void setCelPhone(String celPhone) {
        this.celPhone = celPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
