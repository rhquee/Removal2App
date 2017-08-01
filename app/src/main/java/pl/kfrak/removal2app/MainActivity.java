package pl.kfrak.removal2app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //zakomentowane, bo dodane do "MyApplication"
        //Realm.init(this); //this bo kazde activity jest kontextem; linijka wymagana przez dokumentacje - po gradle

//        PREZENTACJA REALMA - BOOKS
//        //stworzenie nowego obiektu i dodanie do BD
//        Book book = new Book(0, "Rok 1984", new Author(0, "Joanna", "Chmielewska"), "Krowa Niebiańska"); //isbn jako string, bo?
//
//        //zmienna Realm
//        Realm realm = Realm.getDefaultInstance(); //domyslna metoda/instancja, inna mozliwosc: 2 BD exportowa i generyczna np., ale u nas jest domyslna;
//
//        //transakcja - moment w kodzie kiedy zapisujemy cos w BD (musi sie rozpoczac i zakonczyc), bo z mozemy zawsze brac, ale zakomnczenie = transakcja;
//
//        //dodawanie do realma
//        realm.beginTransaction();
//        realm.copyToRealm(book);
//        realm.commitTransaction();
//
//        //rezultaty jakie chcemy odczytac: book -> tj kolekcja
//        //where - jakiej klasy chemy uzyskac rezultaty -> nazwa klasy. Dlaczego <Book> = ... (Book.class)
//        //bo po prawej zapewniamy ze edziemy brali obiekty z tej jednej klasy, po lewej - lista (kolekcja)
//
//        //znajduje wszytskie obiekty w klasie Book.class. findAll pokazuje wszytskie ktore spełniają warunki
//        //pomiedzy where a findAll
//        RealmResults<Book> books = realm.where(Book.class).findAll();
//
//        Log.d("Tag", book.toString());


        //RZECZY W PIWNICY
        //cd. onCreate'a:
        ButterKnife.bind(this);
    }
}
