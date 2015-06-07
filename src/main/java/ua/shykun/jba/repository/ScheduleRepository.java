package ua.shykun.jba.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import ua.shykun.jba.entity.Role;
import ua.shykun.jba.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

}
