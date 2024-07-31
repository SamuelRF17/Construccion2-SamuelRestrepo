package project.model;

import java.util.Date;

public class Invoice {
    private long Id;
    private Persons personId;
    private Partner partnerId;
    private Date dateCreated;
    private double amount;
    private Boolean status;

    public Invoice() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Persons getPersonId() {
        return personId;
    }

    public void setPersonId(Persons personId) {
        this.personId = personId;
    }

    public Partner getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Partner partnerId) {
        this.partnerId = partnerId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
