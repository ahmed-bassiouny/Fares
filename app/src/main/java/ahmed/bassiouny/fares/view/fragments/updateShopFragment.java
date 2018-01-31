package ahmed.bassiouny.fares.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ahmed.bassiouny.fares.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class updateShopFragment extends Fragment {


    private static updateShopFragment updateShopFragment;

    public updateShopFragment() {
        // Required empty public constructor
    }

    public static updateShopFragment newInstance() {
        if (updateShopFragment == null)
            updateShopFragment = new updateShopFragment();
        return updateShopFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_shop, container, false);
    }

}
