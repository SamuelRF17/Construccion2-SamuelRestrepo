package app.dto;

public class PersonDto {
    private long Id;
    private String name, celPhone, cedula;

    public PersonDto(String name, String cedula, String celPhone) {
        this.name = name;
        this.cedula = cedula;
        this.celPhone = celPhone;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
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
