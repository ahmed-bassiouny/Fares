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
public class MyShopFragment extends Fragment {

    private static MyShopFragment myShopFragment;

    public MyShopFragment() {
        // Required empty public constructor
    }

    public static MyShopFragment newInstance() {
        if (myShopFragment == null)
            myShopFragment = new MyShopFragment();
        return myShopFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_shop, container, false);
    }

}
