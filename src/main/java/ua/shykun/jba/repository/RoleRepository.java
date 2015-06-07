package ua.shykun.jba.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.shykun.jba.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Role findByName(String name);
}
