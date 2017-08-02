package pl.kfrak.removal2app.AddFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import pl.kfrak.removal2app.R;

public class AddItemFragment extends DialogFragment implements AddItemContract.View2 {

    @BindView(R.id.add_fragment_item_name)
    EditText name;
    @BindView(R.id.add_fragment_item_description)
    EditText description;

    private AddItemContract.Presenter AddItemPresenter;
    private Realm realm;


    private AddItemContract.Presenter addItemPresenter;

    public AddItemFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_item, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //AddItemContract.Presenter zamiast AddItemPresenter, bo
        addItemPresenter = new AddItemPresenter(this); //to this zapewnia ze presenter może "mówić" do presentera
        realm = Realm.getDefaultInstance();
    }
        //mamy wtedy sostęp do metody w interfejsie, a jesli AddItemPresenter to mam dostęp do metody bedacej w klasie i w interfejsie
        //to jest takie sito - o to chodzi w komunikacji z interfejsami, tylko te metody konieczne, potrzebne; taki jest ich sens.

        //cel: gdy user wpisze cos w pola + kliknie save, chcemy zapisac item do BD
        @OnClick(R.id.add_fragment_item_save)
        public void onSaveButtonClicked () {
            addItemPresenter.saveItem(realm);
        }

    @Override
    public String getItemName() {
        return name.getText().toString();
    }

    @Override
    public String getItemDescription() {
        return description.getText().toString();
    }
}