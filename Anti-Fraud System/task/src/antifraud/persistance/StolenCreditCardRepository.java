package antifraud.persistance;

import antifraud.persistance.entity.StolenCreditCardEntity;
import org.springframework.data.repository.CrudRepository;

public interface StolenCreditCardRepository extends CrudRepository<StolenCreditCardEntity, Long> {
    boolean existsByNumber(String number);

    StolenCreditCardEntity findFirstByNumber(String cardNumber);
}
