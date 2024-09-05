package giorgiaipsarop.MenuPizzeriaD4WithDB.entities.classes;

import giorgiaipsarop.MenuPizzeriaD4WithDB.entities.misc.Item;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="pizzas")
@NoArgsConstructor
public class Pizza extends Item {
    private String name;

@ManyToMany
@JoinTable(
   name="pizza_topping",
    joinColumns = @JoinColumn(name="pizza_id"),
    inverseJoinColumns = @JoinColumn(name = "topping_id")
)
private List<Topping> toppingList;
private boolean isXl = false;

public Pizza(String name, List<Topping> toppingList, boolean isXl, double price){
    super(700, price);
    this.name = name;
    this.toppingList = toppingList;
    this.isXl = isXl;
}


    @Override
    public int getCalories() {
        return super.getCalories() + this.getToppingList().stream().mapToInt(Topping::getCalories).sum();
    }

    @Override
    public double getPrice() {
        return super.getPrice() + this.getToppingList().stream().mapToDouble(Topping::getPrice).sum();
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", price=" + price +
                ", toppingList=" + toppingList +
                ", isXl=" + isXl +
                '}';
    }
}