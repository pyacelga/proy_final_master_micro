package masterspringbootfinalProjectM2.masterspringbootfinalProjectM2.mapper;

import masterspringbootfinalProjectM2.masterspringbootfinalProjectM2.domain.AccountDto;
import masterspringbootfinalProjectM2.masterspringbootfinalProjectM2.entity.Account;

public class AccountMapper {

    public static AccountDto mapToUserDto(Account account){
        AccountDto userDto = new AccountDto(
                account.getId(),
                account.getIdUser(),
                account.getAccountUser(),
                account.getCardUser(),
                account.getPinUser(),
                account.getAccountBalance(),
                account.getCreatedAt(),
                account.getUpdateAt()
        );
        return userDto;
    }

    public static Account mapToUser(AccountDto accountDto){
        Account user = new Account(
                accountDto.getId(),
                accountDto.getIdUser(),
                accountDto.getAccountUser(),
                accountDto.getCardUser(),
                accountDto.getPinUser(),
                accountDto.getAccountBalance(),
                accountDto.getCreatedAt(),
                accountDto.getUpdateAt()
        );
        return user;
    }


}
