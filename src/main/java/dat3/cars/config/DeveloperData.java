package dat3.cars.config;

import dat3.cars.entity.Car;
import dat3.cars.entity.Member;
import dat3.cars.entity.Reservation;
import dat3.cars.repositories.CarRepository;
import dat3.cars.repositories.MemberRepository;
import dat3.cars.repositories.ReservationRepository;
import dat3.security.entity.Role;
import dat3.security.entity.UserWithRoles;
import dat3.security.repository.UserWithRolesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Controller
public class DeveloperData implements ApplicationRunner {

    CarRepository carRepository;
    MemberRepository memberRepository;

    ReservationRepository reservationRepository;


    public DeveloperData(CarRepository carRepository, MemberRepository memberRepository, ReservationRepository reservationRepository) {
        this.carRepository = carRepository;
        this.memberRepository = memberRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        createCars();
        createMembers();

        // De eksisterede biler og members fra carRepository og memberRepository bliver hentet herfra.
        List <Car> cars = carRepository.findAll();
        List <Member> members = memberRepository.findAll();

        //Reservationer bliver oprettet med de eksisterende værdier.
        Reservation reservation1 = new Reservation(members.get(0), cars.get(0), LocalDate.now());
        Reservation reservation2 = new Reservation(members.get(1), cars.get(1), LocalDate.now());
        Reservation reservation3 = new Reservation(members.get(2), cars.get(2), LocalDate.now());

        // De oprettet reservationer tilføjet til listen.

        List<Reservation> reservations = new ArrayList<>();
        reservations.add(reservation1);
        reservations.add(reservation2);
        reservations.add(reservation3);

        reservationRepository.saveAll(reservations);

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

    private void createMembers() {
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


    // Autowired annotationen er fjernet her da det ikke virkede med den.
    UserWithRolesRepository userWithRolesRepository;

    final String passwordUsedByAll = "test12";

    /*****************************************************************************************
     NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL
     iT'S ONE OF THE TOP SECURITY FLAWS YOU CAN DO
     *****************************************************************************************/
    private void setupUserWithRoleUsers() {

        System.out.println("******************************************************************************");
        System.out.println("******* NEVER  COMMIT/PUSH CODE WITH DEFAULT CREDENTIALS FOR REAL ************");
        System.out.println("******* REMOVE THIS BEFORE DEPLOYMENT, AND SETUP DEFAULT USERS DIRECTLY  *****");
        System.out.println("**** ** ON YOUR REMOTE DATABASE                 ******************************");
        System.out.println("******************************************************************************");
        UserWithRoles user1 = new UserWithRoles("user1", passwordUsedByAll, "user1@a.dk");
        UserWithRoles user2 = new UserWithRoles("user2", passwordUsedByAll, "user2@a.dk");
        UserWithRoles user3 = new UserWithRoles("user3", passwordUsedByAll, "user3@a.dk");
        UserWithRoles user4 = new UserWithRoles("user4", passwordUsedByAll, "user4@a.dk");
        user1.addRole(Role.USER);
        user1.addRole(Role.ADMIN);
        user2.addRole(Role.USER);
        user3.addRole(Role.ADMIN);
        //No Role assigned to user4
        userWithRolesRepository.save(user1);
        userWithRolesRepository.save(user2);
        userWithRolesRepository.save(user3);
        userWithRolesRepository.save(user4);
    }

}







