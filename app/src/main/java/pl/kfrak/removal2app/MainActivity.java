package pl.kfrak.removal2app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.clans.fab.FloatingActionButton;

import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.kfrak.removal2app.AddBasement.AddBasementFragment;
import pl.kfrak.removal2app.AddFragment.AddItemFragment;
import pl.kfrak.removal2app.ListFragment.ItemsListFragment;

public class MainActivity extends AppCompatActivity implements MainContract.View3, AddDialogInterface {

    private MainContract.Presenter mainPresenter;
    private ItemsListFragment itemsListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter = new MainPresenter(this);
        itemsListFragment = ItemsListFragment.newInstance();
        mainPresenter.onViewInitialized();
    }

    @OnClick(R.id.menu_item_item)
    public void onItemFabPressed() {
        mainPresenter.onOpenItemDialogPressed();
    }

    @OnClick(R.id.menu_item_basement)
    public void onBasementFabPressed() {
        mainPresenter.onOpenBasementDialogPressed();
    }

    @Override
    public void openItemAddDialog() {
        AddItemFragment.newInstance().show(getSupportFragmentManager(), "");
    }

    @Override
    public void showList() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.container, itemsListFragment)
                .commit();
    }

    @Override
    public void refreshList() {
        itemsListFragment.refreshList();
    }

    @Override
    public void openBasementAddDialog() {
        AddBasementFragment.newInstance().show(getSupportFragmentManager(), "");
    }

    @Override
    public void onDialogDismiss() {
        mainPresenter.notifyDialogClosed();
    }
}