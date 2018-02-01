package ahmed.bassiouny.fares.view.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.model.Shop;
import ahmed.bassiouny.fares.utils.MyIntentKey;

/**
 * A simple {@link Fragment} subclass.
 */
public class updateShopFragment extends Fragment {

    private Shop shop;

    public updateShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_shop, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDataFromIntentAndSetData();
    }

    private void getDataFromIntentAndSetData() {
        shop = getArguments().getParcelable(MyIntentKey.SHOP);
        if(shop == null)
            getActivity().onBackPressed();

    }

}
