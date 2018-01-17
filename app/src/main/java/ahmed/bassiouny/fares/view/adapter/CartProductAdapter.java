package ahmed.bassiouny.fares.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.model.Product;
import ahmed.bassiouny.fares.model.ProductCart;

/**
 * Created by bassiouny on 11/01/18.
 */

public class CartProductAdapter extends RecyclerView.Adapter<CartProductAdapter.MyViewHolder> {

    private List<ProductCart> productCarts;

    public CartProductAdapter(List<ProductCart> productCarts) {
        this.productCarts = productCarts;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivProductImage;
        private TextView tvProductName;
        private TextView tvShopName;
        private TextView tvProductPrice;
        private EditText tvQuantity;
        private TextView tvTotal;
        private TextView btnDelete;

        public MyViewHolder(View view) {
            super(view);
            ivProductImage = view.findViewById(R.id.iv_product_image);
            tvProductName = view.findViewById(R.id.tv_product_name);
            tvShopName = view.findViewById(R.id.tv_shop_name);
            tvProductPrice = view.findViewById(R.id.tv_product_price);
            tvQuantity = view.findViewById(R.id.tv_quantity);
            tvTotal = view.findViewById(R.id.tv_total);
            btnDelete = view.findViewById(R.id.btn_delete);

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product_cart, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        ProductCart productCart = productCarts.get(position);
        Product product = productCart.getProduct();
        holder.ivProductImage.setImageResource(product.getPhoto());
        holder.tvProductName.setText(product.getName());
        holder.tvProductPrice.append(product.getPrice());
        holder.tvShopName.append(productCart.getShopName());
        holder.tvQuantity.append(productCart.getQuantity());
        holder.tvTotal.append(productCart.getTotal());
    }

    @Override
    public int getItemCount() {
        return productCarts.size();
    }
}