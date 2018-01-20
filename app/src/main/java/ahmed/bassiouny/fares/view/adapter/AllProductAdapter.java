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
import ahmed.bassiouny.fares.model.Product;
import ahmed.bassiouny.fares.view.activities.ShowProductActivity;

/**
 * Created by bassiouny on 11/01/18.
 */

public class AllProductAdapter extends RecyclerView.Adapter<AllProductAdapter.MyViewHolder> {

    private List<Product> products;
    private Context context;

    public AllProductAdapter(Context context, List<Product> products) {
        this.products = products;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivProductImage, ivMore;
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
                .inflate(R.layout.item_all_product_adapter, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Product product = products.get(position);
        holder.ivProductImage.setImageResource(product.getPhoto());
        holder.tvProductName.setText(product.getName());
        holder.tvProductPrice.setText(product.getPrice());
        holder.ivMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ShowProductActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}