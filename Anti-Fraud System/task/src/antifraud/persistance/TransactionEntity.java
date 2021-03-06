package antifraud.persistance;

import antifraud.buiseness.status.TransactionStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions_history")
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private Long amount;
    @NonNull
    private String ip;
    @NonNull
    private String number;
    @NonNull
    @Enumerated(EnumType.STRING)
    private WorldRegion region;
    @NonNull
    private LocalDateTime date;
    @Enumerated(EnumType.STRING)
    private TransactionStatus status = TransactionStatus.PROHIBITED;
    private TransactionStatus feedback;
}
