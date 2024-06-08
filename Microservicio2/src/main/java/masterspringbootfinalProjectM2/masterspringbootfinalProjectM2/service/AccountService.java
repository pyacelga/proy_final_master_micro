package masterspringbootfinalProjectM2.masterspringbootfinalProjectM2.service;

import masterspringbootfinalProjectM2.masterspringbootfinalProjectM2.domain.AccountDto;


public interface AccountService {
    AccountDto savedAccount(Long idUser);

    AccountDto getAccountByUser(Long idUser);
}
