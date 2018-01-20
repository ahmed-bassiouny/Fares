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
public class CreateShopFragment extends Fragment {


    private static CreateShopFragment createShopFragment;

    public CreateShopFragment() {
        // Required empty public constructor
    }

    public static CreateShopFragment newInstance() {
        if (createShopFragment == null)
            createShopFragment = new CreateShopFragment();
        return createShopFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_shop, container, false);
    }

}
