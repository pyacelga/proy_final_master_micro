package masterspringbootfinalProject.masterspringbootfinalProject.mapper;

import masterspringbootfinalProject.masterspringbootfinalProject.domain.UserDto;
import masterspringbootfinalProject.masterspringbootfinalProject.entity.User;
import org.modelmapper.ModelMapper;

public class UserMapper {

    public static UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getIdentificationType(),
                user.getIdentificationNumber(),
                user.getUserName(),
                user.getPassword(),
                user.getCreatedAt(),
                user.getUpdateAt()
        );
        return userDto;
    }

    public static User mapToUser(UserDto userDto){
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getIdentificationType(),
                userDto.getIdentificationNumber(),
                userDto.getUserName(),
                userDto.getPassword(),
                userDto.getCreatedAt(),
                userDto.getUpdateAt()
        );
        return user;
    }


}
