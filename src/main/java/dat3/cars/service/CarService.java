package dat3.cars.service;

import dat3.cars.dto.CarRequest;
import dat3.cars.dto.CarResponse;
import dat3.cars.entity.Car;
import dat3.cars.entity.Member;
import dat3.cars.repositories.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarResponse> getCars(boolean includeAll) {
        List<Car> cars = carRepository.findAll();
        List<CarResponse> response = new ArrayList<>();

        for (Car car : cars) {
            CarResponse cr = new CarResponse(car, includeAll);
            response.add(cr);
        }

        return response;
    }


    public CarResponse findCarById(int id, boolean includeAll) {
        Car found = carRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Car not found"));
        return new CarResponse(found, includeAll);
    }

    public CarResponse addCar(CarRequest body) {
        if (carRepository.existsById(body.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This car already exist");
        }
        Car newCar = CarRequest.getCarEntity(body);
        carRepository.save(newCar);

        return new CarResponse(newCar, true);
    }


    public CarResponse editCar(CarRequest body, int id) {
        Car editCar = getCarIfExists(id);
        //ID can not be changed
        editCar.setBrand(body.getBrand());
        editCar.setModel(body.getModel());
        editCar.setPricePrDay(body.getPricePrDay());
        editCar.setBestDiscount(body.getBestDiscount());
        Car saved = carRepository.save(editCar);
        return new CarResponse(saved, true);
    }


    public void setPrice(int id, double newPrice) {
        Car editCar = getCarIfExists(id);
        editCar.setPricePrDay(newPrice);
        carRepository.save(editCar);
    }


    public void setDiscount(int id, int newDiscount) {
        Car editCar = getCarIfExists(id);
        editCar.setBestDiscount(newDiscount);
        carRepository.save(editCar);
    }

    public ResponseEntity<Boolean> deleteCar(int id) {
        if (carRepository.existsById(id)) {
            try {
                carRepository.deleteById(id);
                return ResponseEntity.ok(true); // Return true for successful deletion
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not delete car. Most likely because it's part of a rental/reservation");
            }
        } else {
            // Handle the case where the car with the specified ID does not exist
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car with this ID does not exist");
        }
    }

        private Car getCarIfExists ( int id){
            return carRepository.findById(id).orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car with this ID does not exist"));
        }

    }







