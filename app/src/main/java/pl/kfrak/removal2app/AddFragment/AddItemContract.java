package pl.kfrak.removal2app.AddFragment;

import io.realm.Realm;

/**
 * Created by RENT on 2017-08-01.
 */

public interface AddItemContract {
    //contract to interfejs - z niego samego nie bedziemy korzsytac, ale z zagniezdzonych interfejsów - tak
    //zagniezdzilismy onterfejsy w srodku, tzn ze jak bedziemy implementowac interfejs to zagniezdzamy > patrz: AddItemFragment

        interface Presenter {

            void saveItem(Realm realm);
        }

        interface View2 {

            String getItemName();

            String getItemDescription();
        }

    }
