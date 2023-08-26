package dat3.cars.repositories;

import dat3.cars.entity.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class CarRepositoryTest {

    @Autowired
    CarRepository carRepository;

    @Test
    public void testFindAllCars() {
        Car car1 = new Car("Mercedes-Benz", "C-Class");
        Car car2 = new Car("BMW", "3 Series");
        carRepository.save(car1);
        carRepository.save(car2);

        List<Car> cars = (List<Car>) carRepository.findAll();
        assertEquals(2, cars.size());
    }

}

