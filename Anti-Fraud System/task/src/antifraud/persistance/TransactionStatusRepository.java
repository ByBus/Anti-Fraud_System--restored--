package antifraud.persistance;

import antifraud.buiseness.status.TransactionStatus;
import antifraud.persistance.entity.TransactionStatusEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionStatusRepository extends CrudRepository<TransactionStatusEntity, TransactionStatus> {
    TransactionStatusEntity findFirstByMaxAmountGreaterThanEqualOrderByMaxAmountAsc(long amount);
}
