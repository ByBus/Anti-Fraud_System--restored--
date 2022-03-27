package antifraud.model;

import antifraud.buiseness.Regexes;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SuspiciousIpDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private long id;
    @NonNull
    @Pattern(regexp = Regexes.IP_FORMAT, message = "Wrong ip format!")
    private String ip;
}
