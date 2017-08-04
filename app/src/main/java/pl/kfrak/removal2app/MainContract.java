package pl.kfrak.removal2app;

/**
 * Created by RENT on 2017-08-02.
 */

public interface MainContract {

    interface Presenter {
        //w momencie kiedy kliknieta zostal dialog do otwoierania fragmentu
        void onOpenItemDialogPressed();

        void onOpenBasementDialogPressed();

        void notifyDialogClosed();

        void onViewInitialized();
    }
    interface View3 {
        void openItemAddDialog();

        void openBasementAddDialog();

        void showList();

        void refreshList();
    }
}
