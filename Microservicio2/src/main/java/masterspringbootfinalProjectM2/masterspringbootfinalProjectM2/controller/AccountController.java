package masterspringbootfinalProjectM2.masterspringbootfinalProjectM2.controller;

import lombok.AllArgsConstructor;
import masterspringbootfinalProjectM2.masterspringbootfinalProjectM2.domain.AccountDto;
import masterspringbootfinalProjectM2.masterspringbootfinalProjectM2.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/account")
@AllArgsConstructor
public class AccountController {

    private AccountService accountService;


  /*  @GetMapping("{name}")
    public ResponseEntity<String> getMessage(@PathVariable("name") String name){

        return new ResponseEntity<>("Hola "+name+", Bienvenido al MS-2 GESTIÓN DE CUENTAS ", HttpStatus.OK);
    }*/

    @PostMapping("{idUser}")
    public ResponseEntity<AccountDto> getSavedAccount(@PathVariable("idUser") Long idUser){

        AccountDto accountDto =saveAccount(idUser);
        return new ResponseEntity<>(accountDto, HttpStatus.CREATED);
    }
    public AccountDto saveAccount(Long idUser){

        AccountDto accountDto= accountService.savedAccount(idUser);
        return accountDto;
    }

    @GetMapping("{idUser}")
    public ResponseEntity<AccountDto> getAccountByIdUser(@PathVariable("idUser") Long idUser){

        System.out.println("MICRO 2 !!!!!!   GET ACCOUNT BY ID USER");

        AccountDto accountDto =accountService.getAccountByUser(idUser);
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

}
