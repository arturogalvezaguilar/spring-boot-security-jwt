package pe.com.bcp.challengue.test.service;

import pe.com.bcp.challengue.test.dto.ChangeTypeRequest;
import pe.com.bcp.challengue.test.dto.ChangeTypeResponse;
import io.reactivex.Single;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public interface ChangeTypeService {
    public Single<ChangeTypeResponse> getAmountConverted(String currencySource , String currencyDestination,
                                                         BigDecimal amount);
    Single<String> updateChangeType(ChangeTypeRequest addAuthorRequest);
}
