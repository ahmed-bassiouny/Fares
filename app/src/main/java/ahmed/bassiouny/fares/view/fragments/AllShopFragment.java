package ahmed.bassiouny.fares.view.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.model.Shop;
import ahmed.bassiouny.fares.view.adapter.ShopAdapter;

/**
 * private RecyclerView recyclerView;
 * <p>
 * A simple {@link Fragment} subclass.
 */
public class AllShopFragment extends Fragment {

    private RecyclerView recyclerView;
    private static AllShopFragment allShopFragment;

    public AllShopFragment() {
        // Required empty public constructor
    }
    public static AllShopFragment newInstance(){
        if(allShopFragment == null)
            allShopFragment = new AllShopFragment();
        return allShopFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_shop, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        setFakeData();
    }

    private void setFakeData() {
        List<Shop> shops= new ArrayList<>();
        Shop shop1 = new Shop(1,"ابو حسن للمفروشات","الوصف الخاص بالمتجر الخاص بالعميل الذى تم انشاءه",R.drawable.p1);
        shops.add(shop1);
        Shop shop2 = new Shop(1,"كوكى مان","الوصف الخاص بالمتجر الخاص بالعميل الذى تم انشاءه",R.drawable.p2);
        shops.add(shop2);
        Shop shop3 = new Shop(1,"ميكس للاحذية","الوصف الخاص بالمتجر الخاص بالعميل الذى تم انشاءه",R.drawable.p3);
        shops.add(shop3);
        Shop shop4 = new Shop(1,"التوحيد والنور","الوصف الخاص بالمتجر الخاص بالعميل الذى تم انشاءه",R.drawable.p4);
        shops.add(shop4);
        ShopAdapter sectionOfShopAdapter = new ShopAdapter(getContext(),shops);
        recyclerView.setAdapter(sectionOfShopAdapter);
    }

}

