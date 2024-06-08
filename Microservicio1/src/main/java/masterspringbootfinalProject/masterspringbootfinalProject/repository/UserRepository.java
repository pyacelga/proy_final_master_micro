package masterspringbootfinalProject.masterspringbootfinalProject.repository;

import masterspringbootfinalProject.masterspringbootfinalProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByIdentificationNumber(String identificationNumb);
}
