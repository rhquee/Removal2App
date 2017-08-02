package pl.kfrak.removal2app;

/**
 * Created by RENT on 2017-08-02.
 */

public interface MainContract {

    interface Presenter {
        //w momencie kiedy kliknieta zostal dialog do otwoierania fragmentu
        void onOpenDialogPressed();
    }
    interface View3 {
        void openAddDialog();
    }
}
