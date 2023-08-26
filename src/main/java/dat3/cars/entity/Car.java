package dat3.cars.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
//------------------------
@Entity
@Table(name="Car")

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;

    @Column(name = "car_brand", length = 50, nullable = false)
    private String brand;

    @Column(name = "car_model", length = 60, nullable = false)
    private String model;

    @Column(name = "rental_price_day")
    private double pricePrDay;

    @Column(name = "max_discount")
    private int bestDiscount;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "last_edited")
    private LocalDateTime lastEdited;
    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }


}
