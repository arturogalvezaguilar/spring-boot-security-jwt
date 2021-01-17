package pe.com.bcp.challengue.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class ChangeTypeResponse {
    private String currencySource;
    private String currencyDestination;
    private BigDecimal changeType;
    private BigDecimal amount;
    private BigDecimal amountConverted;

}
