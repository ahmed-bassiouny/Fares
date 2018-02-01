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

    private AlertDialog dialog;

    public void show(Context context) {
        dialog = new SpotsDialog(context, "تحميل");
        dialog.setCancelable(false);
        dialog.show();
    }

    public void hide() {
        if (dialog.isShowing())
            dialog.dismiss();
    }
}
