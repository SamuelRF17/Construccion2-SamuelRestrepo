package project.model;

public class Guest {
    private long Id;
    private String userId;  
    private Partner partnerId;
    private Boolean status;

    public Guest() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Partner getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Partner partnerId) {
        this.partnerId = partnerId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}