package pl.kfrak.removal2app;

/**
 * Created by RENT on 2017-08-02.
 */

public class MainPresenter implements MainContract.Presenter {

    //private final MainActivity mainActivity;
    private final MainContract.View3 view;

    //public MainPresenter(MainActivity mainActivity){
    public MainPresenter(MainContract.View3 view){
        this.view = view;
    }

    @Override
    public void onOpenDialogPressed() {
        //nie mozemy otworzyc tu widoku, musimy to wydelegowac do view
        view.openAddDialog();
    }
}
