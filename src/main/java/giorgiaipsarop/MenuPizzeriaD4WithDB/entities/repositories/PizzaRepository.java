package giorgiaipsarop.MenuPizzeriaD4WithDB.entities.repositories;

import giorgiaipsarop.MenuPizzeriaD4WithDB.entities.classes.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    boolean existsByName(String name);

    @Query("SELECT p.name FROM Pizza p WHERE p.price <= :price")
    List<String> filterByPriceLessThan(double price);
}
