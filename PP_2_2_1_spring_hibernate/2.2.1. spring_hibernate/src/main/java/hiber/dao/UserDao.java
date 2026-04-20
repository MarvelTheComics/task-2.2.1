package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();
   void update(User user);

   void add(Car car);
   List<Car> listCars();
   List <User> searchUsers(Car car);
}
