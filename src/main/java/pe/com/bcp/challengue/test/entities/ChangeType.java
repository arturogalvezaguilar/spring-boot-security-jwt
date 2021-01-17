package pe.com.bcp.challengue.test.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(	name = "change_type")
public class ChangeType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "currency_source")
    private String currencySource;
    @Column(name = "currency_destination")
    private String currencyDestination;
    @Column(name = "change_type")
    private BigDecimal changeType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrencySource() {
        return currencySource;
    }

    public void setCurrencySource(String currencySource) {
        this.currencySource = currencySource;
    }

    public String getCurrencyDestination() {
        return currencyDestination;
    }

    public void setCurrencyDestination(String currencyDestination) {
        this.currencyDestination = currencyDestination;
    }

    public BigDecimal getChangeType() {
        return changeType;
    }

    public void setChangeType(BigDecimal changeType) {
        this.changeType = changeType;
    }

}
