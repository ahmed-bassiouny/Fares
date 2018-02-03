package ahmed.bassiouny.fares.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.interfaces.ParseObject;
import ahmed.bassiouny.fares.model.Shop;

/**
 * Created by bassiouny on 11/01/18.
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.MyViewHolder> {

    private List<Shop> shops;
    private Fragment fragment;
    private ParseObject parseObject;

    public ShopAdapter(Fragment fragment, List<Shop> shops) {
        this.fragment = fragment;
        this.shops = shops;
        parseObject = (ParseObject) fragment;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivShopPhoto;
        private TextView ivShopName,ivShopDescription;
        public MyViewHolder(View view) {
            super(view);
            ivShopPhoto = view.findViewById(R.id.iv_shop_photo);
            ivShopName = view.findViewById(R.id.iv_shop_name);
            ivShopDescription = view.findViewById(R.id.iv_shop_description);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Shop shop = shops.get(getAdapterPosition());
                    parseObject.parse(shop);
                }
            });
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_shops_adapter, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Shop shop = shops.get(holder.getAdapterPosition());
        holder.ivShopName.setText(shop.getName());
        holder.ivShopDescription.setText(shop.getDescription());
    }

    @Override
    public int getItemCount() {
        return shops.size();
    }
}