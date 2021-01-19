package pe.com.bcp.challengue.test.service.impl;

import org.springframework.beans.BeanUtils;
import pe.com.bcp.challengue.test.dto.ChangeTypeDto;
import pe.com.bcp.challengue.test.dto.ChangeTypeRequest;
import pe.com.bcp.challengue.test.dto.ChangeTypeResponse;
import pe.com.bcp.challengue.test.entities.ChangeType;
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
            ChangeTypeDto changeTypeDto = changeTypeRepository
                    .findChangeType(currencySource,    currencyDestination);

            System.out.println("changeType " + changeTypeDto);
            BigDecimal amountConverted = amount.multiply(changeTypeDto.getChangeType());
            ChangeTypeResponse changeTypeResponse = new ChangeTypeResponse(currencySource, currencyDestination,
                    changeTypeDto.getChangeType(), amount,amountConverted);
            singleSubscriber.onSuccess( changeTypeResponse);
        });

    }

    @Override
    public Single<Boolean > updateChangeType(ChangeTypeRequest changeTypeRequest) {

        System.out.println("changeTypeRequest " + changeTypeRequest);
        return Single.create(singleSubscriber -> {
            try{
                ChangeType changeType = new ChangeType();
                ChangeTypeDto changeTypeDto = changeTypeRepository.findChangeType(changeTypeRequest.getCurrencySource(),
                        changeTypeRequest.getCurrencyDestination());
                    BeanUtils.copyProperties(changeTypeDto, changeType);
                    BeanUtils.copyProperties(changeTypeRequest, changeType);

                    changeTypeRepository.save(changeType);
                    singleSubscriber.onSuccess( true);
            }catch(Exception e){
                   e.printStackTrace();
                   singleSubscriber.onError( new RuntimeException("Error en actualizar tipo de cambio "));
            }
        });
    }
}
