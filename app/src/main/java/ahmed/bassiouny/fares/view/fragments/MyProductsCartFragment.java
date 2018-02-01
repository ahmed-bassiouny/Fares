package ahmed.bassiouny.fares.view.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.interfaces.ParseObject;
import ahmed.bassiouny.fares.model.Product;
import ahmed.bassiouny.fares.model.ProductCart;
import ahmed.bassiouny.fares.view.adapter.CartProductAdapter;
import ahmed.bassiouny.fares.view.dialog.AddEditProductQuantityActivity;
import ahmed.bassiouny.fares.view.dialog.OrderDeliveryDetailsDialogActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyProductsCartFragment extends Fragment implements ParseObject<Integer>{

    private RecyclerView recyclerView;
    private TextView tvItemCount;
    private TextView tvTotal;
    private static MyProductsCartFragment myProductsCartFragment;
    private Button btnGetProduct;

    public MyProductsCartFragment() {
        // Required empty public constructor
    }

    public static MyProductsCartFragment newInstance(){
        if(myProductsCartFragment == null)
            myProductsCartFragment = new MyProductsCartFragment();
        return myProductsCartFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_products_cart, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
        tvItemCount = view.findViewById(R.id.tv_item_count);
        tvTotal = view.findViewById(R.id.tv_total);
        btnGetProduct = view.findViewById(R.id.btn_get_product);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        onClick();
    }

    private void onClick() {
        btnGetProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), OrderDeliveryDetailsDialogActivity.class));
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void parse(Integer integer) {
        startActivity(new Intent(getContext(), AddEditProductQuantityActivity.class));
    }
}
