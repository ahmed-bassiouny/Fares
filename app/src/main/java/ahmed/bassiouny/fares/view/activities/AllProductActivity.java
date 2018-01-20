package ahmed.bassiouny.fares.view.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.model.Product;
import ahmed.bassiouny.fares.toolbar.MyToolbar;
import ahmed.bassiouny.fares.view.adapter.AllProductAdapter;

public class AllProductActivity extends MyToolbar {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_product);
        setupMyToolbar(true,true,"المنتجات");
        findViewById();
        setFakeData();
    }
    private void findViewById(){
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void  setFakeData(){

        List<Product> products = new ArrayList<>();
        Product product1 = new Product("بنطلون","وصف عن البنطلون دة","350 جنية",R.drawable.p3);
        products.add(product1);
        Product product2 = new Product("بنطلون","وصف عن البنطلون دة","350 جنية",R.drawable.p2);
        products.add(product2);
        Product product3 = new Product("بنطلون","وصف عن البنطلون دة","350 جنية",R.drawable.p1);
        products.add(product3);
        AllProductAdapter allProductAdapter = new AllProductAdapter(this,products);
        recyclerView.setAdapter(allProductAdapter);
    }
}
