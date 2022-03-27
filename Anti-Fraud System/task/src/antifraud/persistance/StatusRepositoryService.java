package antifraud.persistance;

import antifraud.buiseness.status.TransactionStatus;
import antifraud.persistance.entity.TransactionStatusEntity;

public interface StatusRepositoryService {
    TransactionStatus getStatusWithAmount(long amount);

    TransactionStatusEntity get(TransactionStatus status);

    TransactionStatusEntity update(TransactionStatusEntity statusEntity);
}
