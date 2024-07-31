package project.model;
// package project;

public class Persons {
    private long Id, cedula, celPhone;
    private String name;

    public Persons() {
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

    public long getCelPhone() {
        return celPhone;
    }

    public void setCelPhone(long celPhone) {
        this.celPhone = celPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
