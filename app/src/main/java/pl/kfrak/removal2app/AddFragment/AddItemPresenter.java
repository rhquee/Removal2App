package pl.kfrak.removal2app.AddFragment;

import java.util.Date;

import io.realm.Realm;
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

        //nowy obiekt
        final Item item = new Item(-1, name, description, new Date().getTime());
        saveItemToRealm(realm, item);
    }

    private void saveItemToRealm(Realm realm, final Item item) {
        //wykonanie transakcji zapisania itemu do BD
        //implementacja anonimowa (new Realm.Transaction)
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(item);
            }
        });
    }
}
