package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }
   @Transactional
   @Override
   public void update(User user) {
      userDao.update(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional
   @Override
   public void add(Car car) {
      userDao.add(car);
   }

   @Transactional
   @Override
   public List<Car> listCars() {
      return userDao.listCars();
   }

   @Transactional
   @Override
   public List<User> searchUsers(Car car) {
      return userDao.searchUsers(car);
   }

}
