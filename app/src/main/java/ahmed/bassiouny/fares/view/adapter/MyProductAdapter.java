package ahmed.bassiouny.fares.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.interfaces.MyProductInterface;
import ahmed.bassiouny.fares.model.Product;
import ahmed.bassiouny.fares.view.activities.ShowProductActivity;

/**
 * Created by bassiouny on 11/01/18.
 */

public class MyProductAdapter extends RecyclerView.Adapter<MyProductAdapter.MyViewHolder> {

    private List<Product> products;
    private Context context;
    private MyProductInterface myProductInterface;

    public MyProductAdapter(Context context, List<Product> products) {
        this.products = products;
        this.context = context;
        myProductInterface = (MyProductInterface) context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivProductImage;
        private TextView tvProductName;
        private TextView tvProductDescription;
        private ConstraintLayout myContainer;
        private Button btnEdit, btnDelete;

        public MyViewHolder(View view) {
            super(view);
            ivProductImage = view.findViewById(R.id.iv_product_image);
            tvProductName = view.findViewById(R.id.tv_product_name);
            tvProductDescription = view.findViewById(R.id.tv_product_desc);
            myContainer = view.findViewById(R.id.my_container);
            btnEdit = view.findViewById(R.id.btn_edit);
            btnDelete = view.findViewById(R.id.btn_delete);
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
        final Product product = products.get(position);
        holder.tvProductName.setText(product.getName());
        holder.tvProductDescription.setText(product.getDescription());
        holder.myContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myProductInterface.operationProduct(product, MyProductInterface.VIEW);
            }
        });
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myProductInterface.operationProduct(product, MyProductInterface.DELETE);
            }
        });
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myProductInterface.operationProduct(product, MyProductInterface.EDIT);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}