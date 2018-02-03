package ahmed.bassiouny.fares.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class SectionProductsAdapter extends RecyclerView.Adapter<SectionProductsAdapter.MyViewHolder> {

    private List<Product> products;
    private Context context;

    public SectionProductsAdapter(Context context) {
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivProductImage;
        private TextView tvProductName;
        private TextView tvProductPrice;

        public MyViewHolder(View view) {
            super(view);
                ivProductImage = view.findViewById(R.id.iv_product_image);
                tvProductName = view.findViewById(R.id.tv_product_name);
                tvProductPrice = view.findViewById(R.id.tv_product_price);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_section_products_adapter, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Product product = products.get(position);
        holder.tvProductName.setText(product.getName());
        holder.tvProductPrice.setText(product.getPrice()+" "+context.getString(R.string.eg));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setData(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }
}