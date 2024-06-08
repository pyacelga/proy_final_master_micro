package masterspringbootfinalProjectM2.masterspringbootfinalProjectM2.repository;

import masterspringbootfinalProjectM2.masterspringbootfinalProjectM2.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {

    Account findByIdUser (Long idUser);
}
