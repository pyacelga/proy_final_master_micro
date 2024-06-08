package masterspringbootfinalProject.masterspringbootfinalProject.service.impl;

import lombok.AllArgsConstructor;
import masterspringbootfinalProject.masterspringbootfinalProject.domain.APIResponseDto;
import masterspringbootfinalProject.masterspringbootfinalProject.domain.AccountDto;
import masterspringbootfinalProject.masterspringbootfinalProject.domain.UserDto;
import masterspringbootfinalProject.masterspringbootfinalProject.entity.User;
import masterspringbootfinalProject.masterspringbootfinalProject.mapper.UserMapper;
import masterspringbootfinalProject.masterspringbootfinalProject.repository.UserRepository;
import masterspringbootfinalProject.masterspringbootfinalProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.Random;


@Service
@AllArgsConstructor
public class UserServiceimpl implements UserService {

    private UserRepository userRepository;
    private WebClient webClient;
    final Logger logger = LoggerFactory.getLogger(UserServiceimpl.class);

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Override
    public UserDto getUser(Long id){


        User user=userRepository.getById(id);
        UserDto savedUserDto=UserMapper.mapToUserDto(user);

        return savedUserDto;
    }

    @Override
    public UserDto getIdentificationNumber(String idNumb){

        logger.info("NUM IDENTIFICADOR OFICIAL: "+ idNumb);
        User user=userRepository.findByIdentificationNumber(idNumb);
        UserDto savedUserDto=UserMapper.mapToUserDto(user);

        return savedUserDto;
    }

    @Override
    public APIResponseDto getGralInfoAccount(String idNumOficial){

        UserDto userDto=this.getIdentificationNumber(idNumOficial);
        AccountDto accountDto = null;
        // Invocación al 2Micro para consultar datos de la cuenta:
        try{
            // Utiliza el Circuit Breaker para envolver la llamada al segundo microservicio
            AccountDto finalAccountDto = new AccountDto();
            accountDto = circuitBreakerFactory.create("secondService").run(() -> {
                return webClientBuilder.build()
                        .get()
                        .uri("http://localhost:8082/api/account/" + userDto.getId())
                        .retrieve()
                        .bodyToMono(AccountDto.class)
                        .block();
            }, throwable -> {
                // Manejo de errores: Devolver un objeto AccountDto vacío
                return new AccountDto();
            });
        } catch (Exception e) {
            // Manejo de excepciones generales: Regresar un objeto AccountDto vacío
            accountDto = new AccountDto();
        }
        APIResponseDto apiResponseDto= new APIResponseDto();
        apiResponseDto.setAccountDto(accountDto);
        apiResponseDto.setUserDto(userDto);


        return apiResponseDto;
    }


    @Override
    public APIResponseDto savedUser(UserDto userDto){

        User user = UserMapper.mapToUser(userDto);
        logger.info("valor user:" +user.getFirstName());

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        user.setCreatedAt(timestamp);
        user.setUpdateAt(timestamp);

        User saveduser =userRepository.save(user);
        UserDto savedUserDto=UserMapper.mapToUserDto(saveduser);

        // Invocación al 2Micro para insertar datos de la cuenta:
        AccountDto accountDto = webClient.post()
                .uri("http://localhost:8082/api/account/" + savedUserDto.getId())
                .retrieve()
                .bodyToMono(AccountDto.class)
                .block();

        APIResponseDto apiResponseDto= new APIResponseDto();

        apiResponseDto.setUserDto(savedUserDto);
        apiResponseDto.setAccountDto(accountDto);
       // logger.info("RESPONSE M2: "+msj);

        return apiResponseDto;
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
