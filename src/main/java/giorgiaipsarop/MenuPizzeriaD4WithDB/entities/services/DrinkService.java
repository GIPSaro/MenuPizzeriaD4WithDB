package giorgiaipsarop.MenuPizzeriaD4WithDB.entities.services;


import giorgiaipsarop.MenuPizzeriaD4WithDB.entities.classes.Drink;
import giorgiaipsarop.MenuPizzeriaD4WithDB.entities.repositories.DrinkRepository;
import giorgiaipsarop.MenuPizzeriaD4WithDB.exceptions.ItemAlreadyExist;
import giorgiaipsarop.MenuPizzeriaD4WithDB.exceptions.ItemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DrinkService {
@Autowired
    private DrinkRepository drinkRepository;

public void saveDrink(Drink drink){
    if (drinkRepository.existsByName(drink.getName())) {
        throw new ItemAlreadyExist("Nome già assegnato!");
    } else {
        drinkRepository.save(drink);
        log.info("Drink salvato correttamente!");
    }
}

    public Drink findById(long drinkId) {
        return drinkRepository.findById(drinkId).orElseThrow(() -> new ItemNotFoundException(drinkId));
    }

    public void findByIdAndDelete(long drinkId) {
        Drink found = this.findById(drinkId);
        drinkRepository.delete(found);
        log.info("Il drink con l'id " + drinkId + " è stato cancellato correttamente!");
    }
}
