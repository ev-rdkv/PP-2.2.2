package web.dao;

import org.springframework.stereotype.Repository;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {
    private final List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car(1, "Maserati", 11));
        cars.add(new Car(2, "BMW", 22));
        cars.add(new Car(3, "Hyundai", 33));
        cars.add(new Car(4, "Ford", 44));
        cars.add(new Car(5, "Audi", 55));
    }

    @Override
    public List<Car> showCarsByCount(int count) {
        List<Car> carsCount = new ArrayList<>(cars);
        if (count >= 5 || count == 0) {
            return cars;
        }
        return carsCount.stream().limit(count).collect(Collectors.toList());
    }
}
