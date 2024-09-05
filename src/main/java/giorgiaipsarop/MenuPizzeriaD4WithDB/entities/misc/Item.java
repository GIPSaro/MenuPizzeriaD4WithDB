package giorgiaipsarop.MenuPizzeriaD4WithDB.entities.misc;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name="items")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
public abstract class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id", nullable = false)
    @Setter
    protected long id;
    protected int calories;
    protected double price;

    public Item(int calories, double price) {
        this.calories = calories;
        this.price = price;
    }

}