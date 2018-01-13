package ahmed.bassiouny.fares.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import ahmed.bassiouny.fares.R;

public class RateSuppliersActivity extends AppCompatActivity {


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
            TextView textView = new TextView(this);
            textView.setText("احمد بسيونى");
            textView.setTextSize(16f);
            textView.setTextColor(getResources().getColor(R.color.second_font));
            linearContainer.addView(textView);
            RatingBar ratingBar = new RatingBar(this, null, R.attr.ratingBarStyleIndicator);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER_HORIZONTAL;
            ratingBar.setLayoutParams(params);
            ratingBar.setNumStars(5);
            ratingBar.setIsIndicator(false);
            linearContainer.addView(ratingBar);
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
