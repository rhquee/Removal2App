package pl.kfrak.removal2app.AddFragment;

import java.util.Date;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import pl.kfrak.removal2app.model.Item;

/**
 * Created by RENT on 2017-08-01.
 */

public class AddItemPresenter implements AddItemContract.Presenter {


    private final AddItemContract.View2 view;

    public AddItemPresenter(AddItemContract.View2 view) {
        this.view = view;
    }

    @Override
    public void saveItem(Realm realm) {
        String name = view.getItemName();
        String description = view.getItemDescription();

        //tworzy nowy obiekt
        final Item item = new Item(generateIt(realm), name, description, new Date().getTime()); //generator id
        saveItemToRealm(realm, item);
        view.closeDialog();
    }


    private int generateIt(Realm realm) {
        //generowanie unikalne id dla nowego itemu w bd
        //0. jesli bd nie jest pusta

//        Item itemMaxId = realm.where(Item.class).findFirst(); //findFirst zwraca obiekt/element
        Number maxNumber = realm.where(Item.class).max("id");
        //if (maxNumber != null) {
        //1. znalezx najwyzsze id w bd
        //int maxId = realm.where(Item.class).max("id").intValue(); //zwraca number, my chcemy intValue

//            return maxNumber.intValue() + 1;
//        } else {
//            return Integer.MIN_VALUE; //czemu minvalue?
//        }
        return maxNumber != null ? maxNumber.intValue() + 1 : Integer.MIN_VALUE;
    }


    private void saveItemToRealm(Realm realm, final Item item) {
        //wykonanie transakcji zapisania itemu do BD

        //implementacja anonimowa (new Realm.Transaction)
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
        //execyute z parametrem innerRealm
//            public void execute(Realm innerRealm) {
//                innerRealm.copyToRealm(item);
//            }
//        });

        //innerRealm to nie jest realm z parametru
        realm.executeTransaction(innerRealm -> innerRealm.copyToRealm(item));
    }
}
