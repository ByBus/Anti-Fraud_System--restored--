package antifraud.persistance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
interface TransactionHistoryRepository extends CrudRepository<TransactionEntity, Long> {
    List<TransactionEntity> findAllByNumberAndRegionNotAndDateBetween(
            String number,
            WorldRegion region,
            LocalDateTime publicationDateStart,
            LocalDateTime publicationDateEnd
    );

    List<TransactionEntity> findAllByNumberAndIpNotAndDateBetween(
            String number,
            String ip,
            LocalDateTime publicationDateStart,
            LocalDateTime publicationDateEnd
    );

    List<TransactionEntity> findAllByOrderByIdAsc();

    List<TransactionEntity> findAllByNumber(String number);
}
