package ahmed.bassiouny.fares.utils;

import android.content.Context;
import android.graphics.Color;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by bassiouny on 31/01/18.
 */

public class MyDialog {

    private static SweetAlertDialog pDialog;

    public static void show(Context context) {
        if (pDialog == null) {
            pDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
            pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
            pDialog.setTitleText("من فضلك انتظر ...");
            pDialog.setCancelable(false);
            pDialog.show();
        }
    }

    public static void hide() {
        if(pDialog.isShowing()){
            pDialog.dismissWithAnimation();
        }
    }
}
