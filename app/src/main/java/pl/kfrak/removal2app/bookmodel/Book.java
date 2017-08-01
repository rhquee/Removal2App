package pl.kfrak.removal2app.bookmodel;


import io.realm.RealmObject;
import pl.kfrak.removal2app.bookmodel.Author;

public class Book extends RealmObject {

    private int id;
    //private String author;
    private Author author;
    private String title;
    private String isbn;

    public Book() {
        //leave empty, Realm is required empty constructor
    }

    public Book(int id, String title, Author author, String isbn) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.isbn = isbn;
    }
}
