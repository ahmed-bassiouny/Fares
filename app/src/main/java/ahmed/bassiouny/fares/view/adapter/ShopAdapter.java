package ahmed.bassiouny.fares.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.model.Section;
import ahmed.bassiouny.fares.model.Shop;
import ahmed.bassiouny.fares.view.activities.SectionsOfShopActivity;

/**
 * Created by bassiouny on 11/01/18.
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.MyViewHolder> {

    private List<Shop> shops;
    private Context context;

    public ShopAdapter(Context context,List<Shop> shops) {
        this.context = context;
        this.shops = shops;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivShopPhoto;
        private TextView ivShopName,ivShopDescription;

        public MyViewHolder(View view) {
            super(view);
            ivShopPhoto = view.findViewById(R.id.iv_shop_photo);
            ivShopName = view.findViewById(R.id.iv_shop_name);
            ivShopDescription = view.findViewById(R.id.iv_shop_description);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_shops_adapter, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return shops.size();
    }
}