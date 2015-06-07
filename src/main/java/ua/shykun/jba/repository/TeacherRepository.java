package ua.shykun.jba.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import ua.shykun.jba.entity.Lesson;
import ua.shykun.jba.entity.Role;
import ua.shykun.jba.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
	Teacher findByName(String name);
}
