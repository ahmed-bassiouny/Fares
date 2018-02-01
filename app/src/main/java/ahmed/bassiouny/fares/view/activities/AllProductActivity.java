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
    }
    private void findViewById(){
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
