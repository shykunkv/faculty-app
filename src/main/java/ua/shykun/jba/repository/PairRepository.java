package ua.shykun.jba.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import ua.shykun.jba.entity.Group;
import ua.shykun.jba.entity.Pair;
import ua.shykun.jba.entity.Role;

public interface PairRepository extends JpaRepository<Pair, Integer> {

}
