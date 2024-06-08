package masterspringbootfinalProjectM2.masterspringbootfinalProjectM2.service.impl;

import lombok.AllArgsConstructor;
import masterspringbootfinalProjectM2.masterspringbootfinalProjectM2.domain.AccountDto;
import masterspringbootfinalProjectM2.masterspringbootfinalProjectM2.entity.Account;
import masterspringbootfinalProjectM2.masterspringbootfinalProjectM2.mapper.AccountMapper;
import masterspringbootfinalProjectM2.masterspringbootfinalProjectM2.repository.AccountRepository;
import masterspringbootfinalProjectM2.masterspringbootfinalProjectM2.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Random;


@Service
@AllArgsConstructor
public class AccountServiceimpl implements AccountService {

    private AccountRepository accountRepository;
    final Logger logger = LoggerFactory.getLogger(AccountServiceimpl.class);


    @Override
    public AccountDto savedAccount(Long idUser){

        //Account account = AccountMapper.mapToUser(idUser);
        Account account = new Account();
        logger.info("valor accountUser:" +account.getAccountUser());

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        account.setCreatedAt(timestamp);
        account.setUpdateAt(timestamp);
        account.setAccountUser(createStringData(10));
        account.setCardUser("54"+createStringData(14));
        account.setPinUser(createStringData(4));
        account.setIdUser(idUser);
        account.setAccountBalance(BigDecimal.valueOf(0));

        Account savedAccount =accountRepository.save(account);

        AccountDto savedAccountDto=AccountMapper.mapToUserDto(savedAccount);

        return savedAccountDto;
    }

    @Override
    public AccountDto getAccountByUser(Long idUser) {

        Account account =accountRepository.findByIdUser(idUser);
        AccountDto accountDto=AccountMapper.mapToUserDto(account);
        return accountDto;
    }

    public String createStringData(int longitud){
        int valorDado = (int)Math.floor(Math.random()*10+1);

        String caracts = "0123456789";
        Random random = new Random();

        StringBuilder sb = new StringBuilder(longitud);

        // Generar la serie de caracteres aleatorios
        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(caracts.length());
            char caracter = caracts.charAt(index);
            sb.append(caracter);
        }

        // Imprimir la serie de caracteres aleatorios
        logger.info("VALOR ACCOUNT: " + sb);
        return sb.toString();
    }
}
