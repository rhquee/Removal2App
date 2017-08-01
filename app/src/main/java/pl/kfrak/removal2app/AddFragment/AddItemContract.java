package pl.kfrak.removal2app.AddFragment;

/**
 * Created by RENT on 2017-08-01.
 */

public interface AddItemContract {
    //zagniezdzilismy onterfejsy w srodku, tzn ze jak bedziemy implementowac interfejs to zagniezdzamy > patrz: AddItemFragment
    interface Presenter {
        void saveItem();
    }

    interface View2 { }
}
