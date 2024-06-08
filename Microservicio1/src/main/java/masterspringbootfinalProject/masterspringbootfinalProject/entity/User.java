package masterspringbootfinalProject.masterspringbootfinalProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String firstName;
        private String lastName;
        private String identificationType;

        @Column(nullable = false, unique = true)
        private String identificationNumber;
        private String userName;
        private String password;
        private Timestamp createdAt;
        private Timestamp updateAt;


}
