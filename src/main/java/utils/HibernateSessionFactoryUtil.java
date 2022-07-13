package utils;

import models.Auto;
import models.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

//У него всего одна задача — создавать для нашего приложения фабрику сессий для работы с БД.
////Больше он ничего не умеет.

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                //В этом классе мы создаем новый объект конфигураций Configuration, и передаем ему те классы, которые он должен воспринимать как сущности — User и Auto.
                //Объект конфигурации. Первый объект Hibernate, который должен присутствовать в любом Hibernate-приложении.
                // Он активирует платформу Hibernate. Объект конфигурации создается только один раз во время инициализации приложения.
                // Это родительский объект — именно из него создаются все остальные. Он проверяет, является ли файл конфигурации синтаксически правильным или нет.
                // Он предоставляет свойства конфигурации и сопоставления, необходимые Hibernate.
                Configuration configuration = new Configuration().configure();
                //и передаем ему те классы, которые он должен воспринимать как сущности — User и Auto.
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Auto.class);
                //Обратите внимание на метод configuration.getProperties().
                //Какие еще properties? Откуда?
                //Properties — это параметры для работы hibernate, указанные в специальном файле hibernate.cfg.xml.
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}