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

public class ProductRelatedToAdapter extends RecyclerView.Adapter<ProductRelatedToAdapter.MyViewHolder> {

    private List<Product> products;

    public ProductRelatedToAdapter(List<Product> products) {
        this.products = products;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivProductImage;
        private TextView tvProductName;
        private TextView tvProductDesc;
        private TextView tvProductPrice;
        public MyViewHolder(View itemView) {
            super(itemView);
            ivProductImage = itemView.findViewById(R.id.iv_product_image);
            tvProductName = itemView.findViewById(R.id.tv_product_name);
            tvProductDesc = itemView.findViewById(R.id.tv_product_desc);
            tvProductPrice = itemView.findViewById(R.id.tv_product_price);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product_related_to, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Product product = products.get(position);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}