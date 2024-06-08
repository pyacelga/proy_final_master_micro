package masterspringbootfinalProject.masterspringbootfinalProject.controller;

import lombok.AllArgsConstructor;
import masterspringbootfinalProject.masterspringbootfinalProject.domain.APIResponseDto;
import masterspringbootfinalProject.masterspringbootfinalProject.domain.UserDto;
import masterspringbootfinalProject.masterspringbootfinalProject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;


    @PostMapping
    public ResponseEntity<APIResponseDto> saveUser(@RequestBody UserDto userDto){

        APIResponseDto responseDto= userService.savedUser(userDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

 /*   @GetMapping("{idUser}")
    public ResponseEntity<UserDto> getUser(@PathVariable("idUser") Long idUser){

        System.out.println("MICRO 1 : GET USER");
        UserDto userDto = userService.getUser(idUser);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }*/


    @GetMapping("{userIdNum}")
    public ResponseEntity<APIResponseDto> getUserByIdNumb(@PathVariable("userIdNum") String userIdNum){

        System.out.println("MICRO 1 : GET USER BY IDNUMB");
        APIResponseDto responseDto = userService.getGralInfoAccount(userIdNum);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(responseDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
