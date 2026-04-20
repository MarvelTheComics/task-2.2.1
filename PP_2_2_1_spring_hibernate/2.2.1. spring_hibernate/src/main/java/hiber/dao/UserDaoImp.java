package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("FROM User");
      return query.getResultList();
   }

   @Override
   public void update(User user) {
      sessionFactory.getCurrentSession().update(user);
   }

   @Override
   public void add(Car car) {
      sessionFactory.getCurrentSession().save(car);
   }

   @Override
   public List<Car> listCars() {
       return sessionFactory.getCurrentSession()
               .createQuery("FROM Car", Car.class)
               .getResultList();
   }

   @Override
   public List <User> searchUsers(Car car) {
      List <User> users = new ArrayList<>();
      List <Car> cars = sessionFactory.getCurrentSession()
              .createQuery("FROM Car WHERE model = :model AND series = :series", Car.class)
              .setParameter("model", car.getModel())
              .setParameter("series", car.getSeries())
              .getResultList();
      for (Car car1: cars) {
         users.add(car1.getUser());
      }
      return users;
   }

}
