package app.dto;

public class UserDto {
    private long Id;
    private String userName, Rol = "Socio", password;
    private PersonDto personDto;

    public UserDto(String userName, String password, PersonDto personDto) {
        this.userName = userName;
        this.password = password;
        this.personDto = personDto;
    }

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

    public PersonDto getPersonId() {
        return personDto;
    }

    public void setPersonId(PersonDto personDto) {
        this.personDto = personDto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
