package pe.com.bcp.challengue.test.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ChangeTypeRequest {
    private String currencySource;
    private String currencyDestination;
    private BigDecimal changeType;
    private BigDecimal amount;
}
