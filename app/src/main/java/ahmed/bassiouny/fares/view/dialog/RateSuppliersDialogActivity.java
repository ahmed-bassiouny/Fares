package ahmed.bassiouny.fares.view.dialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import ahmed.bassiouny.fares.R;

public class RateSuppliersDialogActivity extends AppCompatActivity {


    private ImageView ivClose;
    private LinearLayout linearContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_suppliers);
        ivClose = findViewById(R.id.iv_close);
        linearContainer = findViewById(R.id.linear_container);
        onClick();
        setRateBarForSupplier(2);
    }

    private void setRateBarForSupplier(int numberOfSupplier) {
        for(int i=0 ;i <numberOfSupplier ; i++ ) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER;
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            linearLayout.setTextDirection(View.TEXT_DIRECTION_LTR);
            linearLayout.setLayoutParams(params);
            TextView textView = new TextView(this);
            textView.setText("احمد بسيونى");
            textView.setTextSize(18f);
            textView.setPadding(10,10,0,0);
            textView.setGravity(Gravity.CENTER_VERTICAL);
            textView.setTextColor(getResources().getColor(R.color.first_font));
            linearLayout.addView(textView);
            RatingBar ratingBar = new RatingBar(this, null, R.attr.ratingBarStyleIndicator);
            ratingBar.setNumStars(5);
            ratingBar.setIsIndicator(false);
            linearLayout.addView(ratingBar);
            linearContainer.addView(linearLayout);
        }
    }

    private void onClick() {
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
