package pl.kfrak.removal2app.Adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;
import pl.kfrak.removal2app.R;
import pl.kfrak.removal2app.model.Item;

public class ItemsListAdapter extends RecyclerView.Adapter<ItemsListAdapter.ItemViewHolder> {

    private final RealmResults<Item> items;

    public ItemsListAdapter(RealmResults<Item> items) {
        this.items = items;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
    //ItemsListAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_list_row, null, false);
        return new ItemViewHolder(view);
    }




    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Item item = items.get(position);
        holder.itemTitle.setText(item.getName());
        holder.itemId.setText(String.valueOf(item.getId()));
    }

    //    static class ItemViewHolder extends RecyclerView.ViewHolder {
//
//        @BindView(R.id.item_id)
//        TextView itemId;
//        @BindView(R.id.item_title)
//        TextView itemTitle;
//
//        public ItemViewHolder(View itemView) {
//            super(itemView);
//            ButterKnife.bind(this, itemView);
//        }
//    }
    class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_id)
        TextView itemId;
        @BindView(R.id.item_title)
        TextView itemTitle;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
