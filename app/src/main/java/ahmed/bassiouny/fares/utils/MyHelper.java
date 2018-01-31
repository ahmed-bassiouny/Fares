package ahmed.bassiouny.fares.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import ahmed.bassiouny.fares.R;

/**
 * Created by bassiouny on 13/01/18.
 */

public class MyHelper {

    public static void goToFragment(FragmentActivity fragmentActivity,
                                    Fragment fragment, boolean supportBack,
                                    @Nullable Bundle bundle) {
        FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.my_frame_layout_main, fragment);
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        if (supportBack)
            fragmentTransaction.addToBackStack("back");
        fragmentTransaction.commit();
    }

    public static String getValueFromString(String item) {
        if (item == null)
            return "";
        return item;
    }
}
