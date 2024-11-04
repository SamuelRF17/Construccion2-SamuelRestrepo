
package app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "partner")
public class Partner {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long Id;
    @ManyToOne
    @JoinColumn(name = "userid")    
    private User userId;
    @Column(name = "amount")
    private double amount;
    @Column(name = "type")
    private String type;
    @Column(name = "creationdate")
    private Date dateCreated;

}
