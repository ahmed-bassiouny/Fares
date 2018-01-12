package ahmed.bassiouny.fares.view.activities;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.model.Section;
import ahmed.bassiouny.fares.model.Shop;
import ahmed.bassiouny.fares.toolbar.MyToolbar;
import ahmed.bassiouny.fares.utils.SpacesItemDecoration;
import ahmed.bassiouny.fares.view.adapter.SectionOfShopAdapter;
import ahmed.bassiouny.fares.view.adapter.ShopAdapter;

public class ShopActivity extends MyToolbar {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        setupMyToolbar(true,true,"المتاجر");
        findViewById();
        setFakeData();
    }
    private void findViewById(){
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        //recyclerView.addItemDecoration(new SpacesItemDecoration());
    }
    private void  setFakeData(){
        List<Shop> shops= new ArrayList<>();
        Shop shop1 = new Shop(1,"ابو حسن للمفروشات","الوصف الخاص بالمتجر الخاص بالعميل الذى تم انشاءه",R.drawable.p1);
        shops.add(shop1);
        Shop shop2 = new Shop(1,"كوكى مان","الوصف الخاص بالمتجر الخاص بالعميل الذى تم انشاءه",R.drawable.p2);
        shops.add(shop2);
        Shop shop3 = new Shop(1,"ميكس للاحذية","الوصف الخاص بالمتجر الخاص بالعميل الذى تم انشاءه",R.drawable.p3);
        shops.add(shop3);
        Shop shop4 = new Shop(1,"التوحيد والنور","الوصف الخاص بالمتجر الخاص بالعميل الذى تم انشاءه",R.drawable.p4);
        shops.add(shop4);
        ShopAdapter sectionOfShopAdapter = new ShopAdapter(this,shops);
        recyclerView.setAdapter(sectionOfShopAdapter);
    }
}
