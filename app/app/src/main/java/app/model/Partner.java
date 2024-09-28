
package app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.security.Timestamp;
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
    @Column(name = "userid")    
    private User userId;
    @Column(name = "amount")
    private double money;
    @Column(name = "type")
    private String type;
    @Column(name = "creationdate")
    private Timestamp dateCreated;

}
