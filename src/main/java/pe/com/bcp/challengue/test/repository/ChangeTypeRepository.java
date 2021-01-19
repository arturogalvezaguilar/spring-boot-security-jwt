package pe.com.bcp.challengue.test.repository;

import pe.com.bcp.challengue.test.dto.ChangeTypeDto;
import pe.com.bcp.challengue.test.entities.ChangeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ChangeTypeRepository extends JpaRepository<ChangeType, Long> {

    @Query("SELECT new pe.com.bcp.challengue.test.dto.ChangeTypeDto(c.id, c.currencySource, c.currencyDestination, c.changeType) from  ChangeType c where c.currencySource = :currencySource" +
            " and c.currencyDestination = :currencyDestination "  )

    public ChangeTypeDto findChangeType(String currencySource, String currencyDestination);
}
