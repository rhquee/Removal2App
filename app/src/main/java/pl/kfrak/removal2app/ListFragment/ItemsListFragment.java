package pl.kfrak.removal2app.ListFragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.kfrak.removal2app.Adapters.ItemsListAdapter;
import io.realm.Realm;
import io.realm.RealmResults;
import pl.kfrak.removal2app.R;
import pl.kfrak.removal2app.model.Item;


public class ItemsListFragment extends Fragment {

    @BindView(R.id.list_fragment_recyclerview)
    RecyclerView recyclerView;

    private Realm realm;

    public static ItemsListFragment newInstance() {
        return new ItemsListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_items_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        realm = Realm.getDefaultInstance();
        RealmResults<Item> items = realm.where(Item.class).findAll();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new ItemsListAdapter(items));
    }

    public void refreshList() {
        RealmResults<Item> items = realm.where(Item.class).findAll();
        recyclerView.setAdapter(new ItemsListAdapter(items));
    }
}
