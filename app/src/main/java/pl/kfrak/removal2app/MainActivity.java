package pl.kfrak.removal2app;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmResults;
import pl.kfrak.removal2app.AddFragment.AddItemFragment;

public class MainActivity extends AppCompatActivity implements MainContract.View3 {

    private MainContract.Presenter mainPresenter;

//    @BindView(R.id.main_activity_fab)
//    FloatingActionButton floatingActionButton;

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

        mainPresenter = new MainPresenter(this); //this, tj cos co implementuje interfejs view3

        FloatingActionButton floatingActionButton = (FloatingActionButton)findViewById(R.id.main_activity_fab);

//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mainPresenter.onOpenDialogPressed();
//            }
//        });

        floatingActionButton.setOnClickListener(v -> mainPresenter.onOpenDialogPressed());

    }

//    @OnClick(R.id.main_activity_fab)
//    public void onFabPressed(){
//        //pod wzgllędem MVP dziala to tak, ze:
//        //user kliknie
//        //powiadamiamy presenter "kliknięto przyscisk"
//        //presenter otwiera w naszym activity dialog
//        mainPresenter.onOpenDialogPressed();
//
//    }

    @Override
    public void openAddDialog() {
        //razem z AddItemFragment > newInstance
        //istnieje metoda która otwiera dialog
        AddItemFragment.newInstance().show(getSupportFragmentManager(), "");
    }
}
