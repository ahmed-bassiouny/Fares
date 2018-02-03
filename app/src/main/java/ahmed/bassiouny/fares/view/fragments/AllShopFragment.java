package ahmed.bassiouny.fares.view.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.api.config.BaseResponseInterface;
import ahmed.bassiouny.fares.api.request.RequestAndResponse;
import ahmed.bassiouny.fares.interfaces.ParseObject;
import ahmed.bassiouny.fares.model.Shop;
import ahmed.bassiouny.fares.utils.MyDialog;
import ahmed.bassiouny.fares.utils.MyIntentKey;
import ahmed.bassiouny.fares.view.activities.AllSectionsWithProductActivity;
import ahmed.bassiouny.fares.view.adapter.ShopAdapter;

/**
 * private RecyclerView recyclerView;
 * <p>
 * A simple {@link Fragment} subclass.
 */
public class AllShopFragment extends Fragment implements ParseObject<Shop>{

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
        fetchData();
    }
    private void fetchData(){
        final MyDialog dialog = new MyDialog();
        dialog.show(getContext());
        RequestAndResponse.getMyShops(getContext(), new BaseResponseInterface<List<Shop>>() {
            @Override
            public void onSuccess(List<Shop> shops) {
                ShopAdapter adapter = new ShopAdapter(AllShopFragment.this,shops);
                recyclerView.setAdapter(adapter);
                dialog.hide();
            }

            @Override
            public void onFailed(String errorMessage) {
                Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
                dialog.hide();
            }
        });
    }


    @Override
    public void parse(Shop shop) {
        Intent intent = new Intent(getContext(), AllSectionsWithProductActivity.class);
        intent.putExtra(MyIntentKey.SHOP,shop);
        startActivity(intent);
    }
}

