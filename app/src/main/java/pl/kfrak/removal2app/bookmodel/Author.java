package pl.kfrak.removal2app.bookmodel;

import io.realm.RealmObject;

/**
 * Created by RENT on 2017-08-01.
 */

public class Author extends RealmObject {
    private int id;
    private String name;
    private String surname;

    public Author(){
        //leave empty
    }

    public Author(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
