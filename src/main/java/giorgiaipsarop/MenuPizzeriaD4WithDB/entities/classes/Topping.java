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
@Table(name="toppings")
@NoArgsConstructor
public class Topping extends Item {
    private String name;
@ManyToMany
@JoinTable(
        name="pizza_topping",
        joinColumns = @JoinColumn(name="topping_id"),
        inverseJoinColumns = @JoinColumn(name="pizza_id")
)
private List<Pizza> pizzaList;

    public Topping(String name, int calories, double price) {
        super(calories, price);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Topping{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", price=" + price +
                '}';
    }
}