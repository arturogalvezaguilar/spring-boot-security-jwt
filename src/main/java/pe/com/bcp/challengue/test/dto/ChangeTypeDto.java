package pe.com.bcp.challengue.test.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ChangeTypeDto {
    private String currencySource;
    private String currencyDestination;
    private BigDecimal changeType;
    private BigDecimal amount;
    private  Long id;

    public ChangeTypeDto(Long id, String currencySource , String currencyDestination , BigDecimal changeType){
        this.id = id ;
        this.currencySource = currencySource;
        this.currencyDestination = currencyDestination;
        this.changeType = changeType;
    }
}
