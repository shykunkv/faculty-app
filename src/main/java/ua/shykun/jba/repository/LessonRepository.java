package ua.shykun.jba.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import ua.shykun.jba.entity.Lesson;
import ua.shykun.jba.entity.Role;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
	Lesson findByName(String name);
}
