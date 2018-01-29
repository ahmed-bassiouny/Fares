package ahmed.bassiouny.fares.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;

import ahmed.bassiouny.fares.R;

/**
 * Created by bassiouny on 29/01/18.
 */

public class MyProgressBar {

    private static ProgressBar progressBar;
    private static Activity activity;

    public  static void setActivity(Activity activity){
        MyProgressBar.activity = activity;
    }
    public  static void show(){
        if(progressBar==null)
            progressBar = activity.findViewById(R.id.progress);
        progressBar.setVisibility(View.VISIBLE);
    }
    public  static void hide(){
        if(progressBar==null)
            progressBar = activity.findViewById(R.id.progress);
        progressBar.setVisibility(View.GONE);
    }
}
