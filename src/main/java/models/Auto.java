package models;

import javax.persistence.*;

//@Entity сообщает Hibernate, что этот класс — компонент сущности, и его объекты должны быть постоянными.
//@Table применяется для указания имени создаваемой таблицы в базе данных.
@Entity
@Table(name = "autos")
public class Auto {
    //@Id используется для определения первичного ключа. Можно также добавить совместно несколько полей, чтобы создать составной ключ.
    @Id
    //@GeneratedValue определяет стратегию инкремента в поле. Это необязательный параметр — если он не определен с помощью @Id,
    // применяется стратегия по умолчанию.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@Column определяет, как поле сопоставляется со столбцом в таблице. Аннотация принимает такие атрибуты,
    // как имя столбца, определение столбца, возможность принимать null-значение, уникальность и т. д.
    // В отличие от XML-файлов, здесь не нужно указывать тип, поскольку он берется непосредственно из поля.
    @Column (name = "model")
    private String model;

    //можно не указывать Column name, если оно совпадает с названием столбца в таблице
    private String color;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Auto() {
    }

    public Auto(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return color + " " + model;
    }
}