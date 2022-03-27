package antifraud.persistance;

import antifraud.persistance.entity.SuspiciousIPEntity;
import org.springframework.data.repository.CrudRepository;

public interface SuspiciousIPRepository extends CrudRepository<SuspiciousIPEntity, Long> {
    boolean existsByIp(String ip);

    SuspiciousIPEntity findFirstByIp(String ip);
}
