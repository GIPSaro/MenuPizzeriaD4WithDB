package giorgiaipsarop.MenuPizzeriaD4WithDB.entities.repositories;

import giorgiaipsarop.MenuPizzeriaD4WithDB.entities.classes.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ToppingRepository extends JpaRepository<Topping, Long> {
    boolean existsByName(String name);
    @Query("SELECT t.name FROM Topping t WHERE t.calories < :calories")
    List<String> filterByCaloriesLessThan(int calories);
}
