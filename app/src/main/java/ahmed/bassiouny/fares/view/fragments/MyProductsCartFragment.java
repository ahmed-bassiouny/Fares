package ahmed.bassiouny.fares.view.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.interfaces.MyTitle;
import ahmed.bassiouny.fares.model.Product;
import ahmed.bassiouny.fares.model.ProductCart;
import ahmed.bassiouny.fares.view.adapter.CartProductAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyProductsCartFragment extends Fragment {

    private RecyclerView recyclerView;
    private TextView tvItemCount;
    private TextView tvTotal;
    private static MyProductsCartFragment myProductsCartFragment;
    private MyTitle myTitle;

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
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        myTitle = (MyTitle) getActivity();
        myTitle.changeTitle(getString(R.string.shop_cart));
    }

    @Override
    public void onResume() {
        super.onResume();
        setFakeData();
    }

    private void setFakeData() {
        Product product1 = new Product("بنطلون","وصف عن البنطلون دة","350",R.drawable.p3);
        Product product2 = new Product("بنطلون","وصف عن البنطلون دة","350",R.drawable.p2);
        Product product3 = new Product("بنطلون","وصف عن البنطلون دة","350",R.drawable.p1);
        ProductCart productCart1 = new ProductCart(product1,"السعيد للاحذية",2);
        ProductCart productCart2 = new ProductCart(product2,"الحمد للمفروشات",1);
        ProductCart productCart3 = new ProductCart(product3,"الفارس للماكولات",1);
        List<ProductCart> productCarts = new ArrayList<>();
        productCarts.add(productCart1);
        productCarts.add(productCart2);
        productCarts.add(productCart3);
        CartProductAdapter cartProductAdapter = new CartProductAdapter(productCarts);
        recyclerView.setAdapter(cartProductAdapter);
        tvItemCount.append("4 قطع");
        tvTotal.append("540 جنية");

    }
}
