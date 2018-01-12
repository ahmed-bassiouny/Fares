package ahmed.bassiouny.fares.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.model.Product;

/**
 * Created by bassiouny on 11/01/18.
 */

public class MyProductAdapter extends RecyclerView.Adapter<MyProductAdapter.MyViewHolder> {

    private List<Product> products;

    public MyProductAdapter(List<Product> products) {
        this.products = products;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivProductImage,ivMore;
        private TextView tvProductName;
        private TextView tvProductPrice;
        public MyViewHolder(View view) {
            super(view);
            ivProductImage = view.findViewById(R.id.iv_product_image);
            tvProductName = view.findViewById(R.id.tv_product_name);
            tvProductPrice = view.findViewById(R.id.tv_product_price);
            ivMore = view.findViewById(R.id.iv_more);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_my_product_adapter, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Product product = products.get(position);
        holder.ivProductImage.setImageResource(product.getPhoto());
        holder.tvProductName.setText(product.getName());
        holder.tvProductPrice.setText(product.getPrice());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}