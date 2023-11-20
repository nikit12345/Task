package spring.security.RegistrationAndLogin.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.security.RegistrationAndLogin.model.User;
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
