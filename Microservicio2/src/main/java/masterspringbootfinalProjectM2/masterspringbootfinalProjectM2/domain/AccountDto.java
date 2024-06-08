package masterspringbootfinalProjectM2.masterspringbootfinalProjectM2.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private Long id;
    private Long idUser;
    private String accountUser;
    private String cardUser;
    private String pinUser;
    private BigDecimal accountBalance;
    private Timestamp createdAt;
    private Timestamp updateAt;


}
