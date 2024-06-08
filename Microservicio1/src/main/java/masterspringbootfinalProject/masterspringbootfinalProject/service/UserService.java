package masterspringbootfinalProject.masterspringbootfinalProject.service;

import masterspringbootfinalProject.masterspringbootfinalProject.domain.APIResponseDto;
import masterspringbootfinalProject.masterspringbootfinalProject.domain.UserDto;

public interface UserService {
    UserDto getIdentificationNumber(String idNumb);

    APIResponseDto getGralInfoAccount(String idNumOficial);

    APIResponseDto savedUser(UserDto userDto);

    UserDto getUser(Long id);
}
