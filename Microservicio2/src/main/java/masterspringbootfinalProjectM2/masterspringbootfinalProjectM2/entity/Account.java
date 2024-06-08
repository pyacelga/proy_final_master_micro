package masterspringbootfinalProjectM2.masterspringbootfinalProjectM2.entity;

import jakarta.persistence.*;
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
@Entity
@Table(name = "account")
public class Account {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Long idUser;
        private String accountUser;
        private String cardUser;
        private String pinUser;
        private BigDecimal accountBalance;
        private Timestamp createdAt;
        private Timestamp updateAt;

        public Account(Long id, Long idUser, String account, String card, String pin, Timestamp createdAt, Timestamp updateAt) {
        }
}
