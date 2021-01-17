package pe.com.bcp.challengue.test.repository;

import pe.com.bcp.challengue.test.entities.ChangeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ChangeTypeRepository extends JpaRepository<ChangeType, Long> {
    @Query("SELECT changeType from  ChangeType where currencySource = :currencySource" +
            " and currencyDestination = :currencyDestination ")

   public BigDecimal findChangeType(String currencySource, String currencyDestination);
}
