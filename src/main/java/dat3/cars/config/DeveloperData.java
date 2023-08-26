package dat3.cars.config;

import dat3.cars.entity.Car;
import dat3.cars.entity.Member;
import dat3.cars.repositories.CarRepository;
import dat3.cars.repositories.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Controller
public class DeveloperData implements ApplicationRunner {

    CarRepository carRepository;
    MemberRepository memberRepository;

    public DeveloperData(CarRepository carRepository, MemberRepository memberRepository) {
        this.carRepository = carRepository;
        this.memberRepository = memberRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        createCars();
        createMembers();
    }

    private void createCars() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("Toyota", "Corolla"));
        cars.add(new Car("Honda", "Civic"));
        cars.add(new Car("Ford", "Fusion"));
        cars.add(new Car("Chevrolet", "Malibu"));
        cars.add(new Car("Volkswagen", "Passat"));
        cars.add(new Car("Nissan", "Altima"));
        cars.add(new Car("Hyundai", "Elantra"));
        cars.add(new Car("Kia", "Optima"));
        cars.add(new Car("Mazda", "Mazda3"));
        cars.add(new Car("Subaru", "Impreza"));
        cars.add(new Car("Mercedes-Benz", "C-Class"));
        cars.add(new Car("BMW", "3 Series"));
        cars.add(new Car("Audi", "A4"));
        cars.add(new Car("Lexus", "IS"));
        cars.add(new Car("Volvo", "S60"));
        cars.add(new Car("Acura", "TLX"));
        cars.add(new Car("Infiniti", "Q50"));
        cars.add(new Car("Genesis", "G70"));
        cars.add(new Car("Porsche", "911"));
        cars.add(new Car("Jaguar", "XE"));
        cars.add(new Car("Tesla", "Model 3"));
        cars.add(new Car("Chrysler", "300"));
        cars.add(new Car("Dodge", "Charger"));
        cars.add(new Car("Buick", "Regal"));
        cars.add(new Car("Lincoln", "MKZ"));
        cars.add(new Car("Cadillac", "CT4"));
        cars.add(new Car("Kia", "Stinger"));
        cars.add(new Car("Hyundai", "Sonata"));
        cars.add(new Car("Nissan", "Maximaa"));

        carRepository.saveAll(cars);

    }

    public void createMembers() {
        List<Member> members = new ArrayList<>();
        members.add(new Member("user1", "password1", "user1@example.com", "John", "Doe", "123 Street", "LA", "12345"));
        members.add(new Member("user2", "password2", "user2@example.com", "Jane", "Smith", "456 Street", "NYC", "67890"));
        members.add(new Member("user3", "password3", "user3@example.com", "Michael", "Johnson", "789 Street", "Jersey", "54321"));
        members.add(new Member("user4", "password4", "user4@example.com", "Emily", "Williams", "987 Street", "CPH", "98765"));
        members.add(new Member("user5", "password5", "user5@example.com", "David", "Brown", "654 Street", "Chicago", "12345"));
        members.add(new Member("user6", "password6", "user6@example.com", "Olivia", "Jones", "321 Street", "Dalas", "67890"));
        members.add(new Member("user7", "password7", "user7@example.com", "Daniel", "Miller", "111 Street", "Brooklyn", "54321"));
        members.add(new Member("user8", "password8", "user8@example.com", "Sophia", "Wilson", "222 Street", "MN", "98765"));
        members.add(new Member("user9", "password9", "user9@example.com", "James", "Taylor", "333 Street", "Saint Pual", "12345"));
        members.add(new Member("user10", "password10", "user10@example.com", "Isabella", "Anderson", "444 Street", "Greenbay", "67890"));

        memberRepository.saveAll(members);
    }
}







