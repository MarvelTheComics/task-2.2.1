package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      CarService carService = context.getBean(CarService.class);

      List<User> users = List.of(
              new User("User1", "Lastname1", "user1@mail.ru"),
              new User("User2", "Lastname2", "user2@mail.ru"),
              new User("User3", "Lastname3", "user3@mail.ru"),
              new User("User4", "Lastname4", "user4@mail.ru")
      );
      users.forEach(userService::add);
      List<Car> cars = List.of(
              new Car("LADA", 2112),
              new Car("LADA", 2104)
      );
      cars.forEach(carService::add);

      List<User> usersFromBD = userService.listUsers();
      List<Car> carsFromBD = carService.listCars();
      Iterator<Car> iterator = carsFromBD.iterator();
      for(User user:usersFromBD) {
         if(iterator.hasNext()) {
            user.setCar(iterator.next());
            userService.update(user);
         }
      }
      System.out.println(userService.searchUsers(new Car("LADA", 2104)));
      context.close();
   }
}
