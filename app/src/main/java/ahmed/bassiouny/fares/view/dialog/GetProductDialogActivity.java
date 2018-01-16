package ahmed.bassiouny.fares.view.dialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.interfaces.ParseObject;

public class GetProductDialogActivity extends AppCompatActivity implements ParseObject<Integer> {

    private RadioGroup radioGroup;
    private ImageView ivClose;
    private TextView tvTitle;
    private TextView etShippingCart;
    private TextView tvProductsCost;
    private TextView tvTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_product_dialog);
        findViewById();
        setFakeData();
    }

    private void setFakeData() {

        RadioButton radioButton = new RadioButton(this);
        radioButton.setText("ارامكس ( 100 جنية )");
        radioButton.setTextColor(getResources().getColor(R.color.first_font));
        radioButton.setTag(100);
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tvTotal.setText(getString(R.string.total)+"640 جنية");
                }
            }
        });
        radioGroup.addView(radioButton);
        RadioButton radioButton1 = new RadioButton(this);
        radioButton1.setText("الشركة التجارية ( 90 جنية )");
        radioButton.setTag(90);
        radioButton1.setTextColor(getResources().getColor(R.color.first_font));
        radioGroup.addView(radioButton1);
        tvProductsCost.append("540 جنية");
        tvTotal.append("540 جنية");
        radioButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tvTotal.setText(getString(R.string.total)+"630 جنية");
                }
            }
        });

    }

    private void findViewById() {
        ivClose = findViewById(R.id.iv_close);
        tvTitle = findViewById(R.id.tv_title);
        etShippingCart = findViewById(R.id.et_shipping_cart);
        radioGroup = findViewById(R.id.radio_group);
        tvProductsCost = findViewById(R.id.tv_products_cost);
        tvTotal = findViewById(R.id.tv_total);
    }

    @Override
    public void parse(Integer price) {

    }
}
