package dat3.cars.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor

@Entity

public class Reservation {


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    int id;

    private LocalDate rentalDate;

    @ManyToOne
    private Car car;

    @ManyToOne
    private Member member;


    public Reservation(Member member, Car car, LocalDate rentalDate) {
        this.rentalDate = rentalDate;
        this.car = car;
        this.member = member;
        car.addReservation(this);
        member.addReservation(this);

    }
}
