package giorgiaipsarop.MenuPizzeriaD4WithDB.entities.services;

import giorgiaipsarop.MenuPizzeriaD4WithDB.entities.classes.Pizza;
import giorgiaipsarop.MenuPizzeriaD4WithDB.entities.repositories.PizzaRepository;
import giorgiaipsarop.MenuPizzeriaD4WithDB.exceptions.ItemAlreadyExist;
import giorgiaipsarop.MenuPizzeriaD4WithDB.exceptions.ItemNotFoundException;
import jakarta.persistence.Access;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;


    public void savePizza(Pizza pizza){
        if (pizzaRepository.existsByName(pizza.getName())){
            throw new ItemAlreadyExist("Nome già assegnato!");

        }
        else{
            pizzaRepository.save(pizza);
            log.info("Pizza salvata correttamente");
        }
    }
    public Pizza findById(long pizzaId) {
        return pizzaRepository.findById(pizzaId).orElseThrow(() -> new ItemNotFoundException(pizzaId));
    }

    public void findByIdAndDelete(long pizzaId) {
        Pizza found = this.findById(pizzaId);
        pizzaRepository.delete(found);
        log.info("La pizza con l'id " + pizzaId + " è stato cancellata correttamente!");
    }

    public List<String> filterByPriceLessThan(double price) {
        return pizzaRepository.filterByPriceLessThan(price);
    }
}

