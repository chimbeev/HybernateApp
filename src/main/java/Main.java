import models.Auto;
import models.User;
import services.UserService;
//В этом приложении мы используем Фреймворк Hibernate для работы с БД
//Что такое Hibernate?
//        Это — одна из наиболее популярных реализаций ORM-модели. Объектно-реляционная модель описывает отношения между программными объектами и записями в БД.
//Наша цель: создать CRUD-приложение (Create,Read,Update,Delete), которое будет уметь:
//        Создавать пользователей (User), а также искать их в базе данных по ID, обновлять их данные в базе, а также удалять из базы.
//        Присваивать пользователям объекты автомобилей (Auto). Создавать, редактировать, находить и удалять автомобили из базы данных.
//        Кроме того, приложение должно автоматически удалять "бесхозные" автомобили из БД. Т.е. при удалении пользователя, все принадлежащии ему автомобили также должны быть удалены из БД.
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserService userService = new UserService();
        User user = new User("Anatolii",49);
        userService.saveUser(user);
        Auto toyota = new Auto("Toyota", "black");
        toyota.setUser(user);
        user.addAuto(toyota);
        Auto mazda = new Auto("Mazda", "white");
        mazda.setUser(user);
        user.addAuto(mazda);
        userService.updateUser(user);
    }
}