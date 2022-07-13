package dao;

import models.Auto;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

/*      нам понадобится класс UserDAO.
        DAO (data access object) — один из наиболее распространенных паттернов проектирования, "Доступ к данным".
        Его смысл прост — создать в приложении слой, который отвечает только за доступ к данным, и больше ни за что.
        Достать данные из БД, обновить данные, удалить данные — и все.
        Что же умеет наш класс UserDao?
        Собственно, как и все DAO, он умеет только работать с данными. Найти юзера по id, обновить его данные, удалить его,
        вытащить из БД список всех юзеров или сохранить в БД нового юзера — вот весь его функционал.
*/
public class UserDao {

    //Найти пользователя по ID
    public User findById(int id) {
        return (User) HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    //Записать в базу данные о пользователе
    public void save(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    //Обновить данные о пользователе в базе
    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    //Удалить из базы данные о пользователе
    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    //Найти авто по ID
    public Auto findAutoById(int id) {
        return (Auto) HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Auto.class, id);

    }

    //Найти всех пользователей
    public List<User> findAll() {
        List<User> users = (List<User>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }
}