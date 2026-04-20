package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void update(User user);
    List<User> listUsers();

    void add(Car car);
    List<Car> listCars();
    List <User> searchUsers(Car car);
}
