package masterspringbootfinalProject.masterspringbootfinalProject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {

    private UserDto userDto;
    private AccountDto accountDto;
}
