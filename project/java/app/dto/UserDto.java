package project.java.app.DTO;

public class UserDto {
    private long Id;
    private String userName, Rol;
    private PersonsDto personId;

    public UserDto() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String rol) {
        Rol = rol;
    }

    public PersonsDto getPersonId() {
        return personId;
    }

    public void setPersonId(PersonsDto personId) {
        this.personId = personId;
    }

}
