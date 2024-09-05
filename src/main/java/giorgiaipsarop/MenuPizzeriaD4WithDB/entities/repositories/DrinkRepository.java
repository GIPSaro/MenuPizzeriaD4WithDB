package giorgiaipsarop.MenuPizzeriaD4WithDB.entities.repositories;

import giorgiaipsarop.MenuPizzeriaD4WithDB.entities.classes.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {
    boolean existsByName(String name);

}
