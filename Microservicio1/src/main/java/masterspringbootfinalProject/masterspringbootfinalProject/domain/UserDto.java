package masterspringbootfinalProject.masterspringbootfinalProject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto{
    private Long id;
    private String firstName;
    private String lastName;
    private String identificationType;
    private String identificationNumber;
    private String userName;
    private String password;
    private Timestamp createdAt;
    private Timestamp updateAt;
        


  /*  public UserDto {
        Objects.requireNonNull(firstName);
        Objects.requireNonNull(lastName);
        Objects.requireNonNull(identificationType);
        Objects.requireNonNull(identificationNumber);
        Objects.requireNonNull(userName);
        Objects.requireNonNull(password);
    }*/




  /*  public String accountUser(){
        Random random = new Random();
        IntStream intStream = random.ints(8, 1);
        Iterator iterator = intStream.iterator();
        while (iterator.hasNext()){
            System.out.println("Random Number ACCOUNT "+iterator.next());
        }
        //this.account=iterator.next().toString();
        //this.account()=cta;

        return null;
    }*/
}
