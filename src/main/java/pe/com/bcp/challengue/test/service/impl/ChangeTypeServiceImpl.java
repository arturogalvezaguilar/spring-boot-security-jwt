package pe.com.bcp.challengue.test.service.impl;

import pe.com.bcp.challengue.test.dto.ChangeTypeRequest;
import pe.com.bcp.challengue.test.dto.ChangeTypeResponse;
import pe.com.bcp.challengue.test.repository.ChangeTypeRepository;
import pe.com.bcp.challengue.test.service.ChangeTypeService;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ChangeTypeServiceImpl implements ChangeTypeService {

    @Autowired
    private ChangeTypeRepository changeTypeRepository;


    @Override
    public Single<ChangeTypeResponse> getAmountConverted(String currencySource , String currencyDestination,
                                                         BigDecimal amount) {


        return Single.create(singleSubscriber -> {
            BigDecimal changeType = changeTypeRepository
                    .findChangeType(currencySource,
                    currencyDestination);
            System.out.println("changeType " + changeType);
            BigDecimal amountConverted = amount.multiply(changeType);
            ChangeTypeResponse changeTypeResponse = new ChangeTypeResponse(currencySource, currencyDestination,
                    changeType, amount,amountConverted);
            singleSubscriber.onSuccess( changeTypeResponse);
        });

    }

    @Override
    public Single<String> updateChangeType(ChangeTypeRequest addAuthorRequest) {
        return null;
    }
}
