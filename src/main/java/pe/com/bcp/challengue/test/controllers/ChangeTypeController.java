package pe.com.bcp.challengue.test.controllers;

import pe.com.bcp.challengue.test.base.dto.BaseWebResponse;
import pe.com.bcp.challengue.test.service.ChangeTypeService;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/changeType")
public class ChangeTypeController {

     public ChangeTypeController(ChangeTypeService changeTypeService){
        this.changeTypeService = changeTypeService;
    }

    private ChangeTypeService changeTypeService;

    @GetMapping(
            value = "/{currencySource}/{currencyDestination}/{amount}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @PreAuthorize("hasRole('USER')")
    public Single<ResponseEntity<BaseWebResponse>> getAmountConverted(
            @PathVariable("currencySource")   String currencySource,
            @PathVariable("currencyDestination") String currencyDestination,
            @PathVariable("amount") BigDecimal amount
            ){
        return changeTypeService.getAmountConverted(currencySource,currencyDestination, amount )
                .subscribeOn(Schedulers.io())
                .map( changeTypeResponse -> ResponseEntity
                        .ok()
                        .body(BaseWebResponse.successWithData(changeTypeResponse)));
    }


    /*@GetMapping("/hola")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Hola Mundo";
    }*/

}
