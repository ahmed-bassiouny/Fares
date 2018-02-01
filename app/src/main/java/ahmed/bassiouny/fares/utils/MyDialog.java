package ahmed.bassiouny.fares.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;

import ahmed.bassiouny.fares.R;
import dmax.dialog.SpotsDialog;


/**
 * Created by bassiouny on 31/01/18.
 */

public class MyDialog {

    private static AlertDialog dialog;

    public static void show(Context context) {
        if (dialog == null) {
            dialog = new SpotsDialog(context,"تحميل");
            dialog.setCancelable(false);
            dialog.show();
        }
    }

    public static void hide() {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
