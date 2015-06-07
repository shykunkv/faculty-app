package ua.shykun.jba.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import ua.shykun.jba.entity.Role;
import ua.shykun.jba.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByName(String name);
}
