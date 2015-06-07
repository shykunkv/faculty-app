package ua.shykun.jba.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import ua.shykun.jba.entity.Group;
import ua.shykun.jba.entity.Lesson;
import ua.shykun.jba.entity.Role;

public interface GroupRepository extends JpaRepository<Group, Integer> {
	Group findByName(String name);
}
