package giorgiaipsarop.MenuPizzeriaD4WithDB.entities.services;


import giorgiaipsarop.MenuPizzeriaD4WithDB.entities.classes.Topping;
import giorgiaipsarop.MenuPizzeriaD4WithDB.entities.repositories.ToppingRepository;
import giorgiaipsarop.MenuPizzeriaD4WithDB.exceptions.ItemAlreadyExist;
import giorgiaipsarop.MenuPizzeriaD4WithDB.exceptions.ItemNotFoundException;
import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ToppingService {

    @Autowired
    private ToppingRepository toppingRepository;

    public void saveTopping(Topping topping){
        if(toppingRepository.existsByName(topping.getName())){
            throw new ItemAlreadyExist("Nome già assegnato");

        }
        else{
            toppingRepository.save(topping);
        }
    }
    public Topping findById(long toppingId){
        return toppingRepository.findById(toppingId).orElseThrow(()-> new ItemNotFoundException(toppingId));
    }
    public void findByIdAndDelete(long toppingId){
        Topping found = this.findById(toppingId);
        toppingRepository.delete(found);
        log.info("Il topping con l'Id" + toppingId + "è stato eliminato con successo!");
    }
    public List<String>filterByCaloriesLessThan(int calories){
        return toppingRepository.filterByCaloriesLessThan(50);
    }
}
