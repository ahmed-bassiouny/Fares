package ahmed.bassiouny.fares.view.activities;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.api.config.BaseResponseInterface;
import ahmed.bassiouny.fares.api.request.RequestAndResponse;
import ahmed.bassiouny.fares.api.response.ParentResponse;
import ahmed.bassiouny.fares.toolbar.MyToolbar;
import ahmed.bassiouny.fares.utils.MyDialog;
import ahmed.bassiouny.fares.utils.MyProgressBar;
import ahmed.bassiouny.fares.utils.UserSharedPref;

public class CreateShopActivity extends MyToolbar {


    private TextInputEditText etPhone;
    private Button btnSendCode;
    private TextInputEditText etCode;
    private Button etCreateShop;
    private TextView tvResendCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_shop);
        setupMyToolbar(true,false,getString(R.string.my_shop));
        findViewById();
        onClick();
    }

    private void findViewById() {
        etPhone = findViewById(R.id.et_phone);
        btnSendCode = findViewById(R.id.btn_send_code);
        etCode = findViewById(R.id.et_code);
        etCreateShop = findViewById(R.id.et_create_shop);
        tvResendCode = findViewById(R.id.tv_resend_code);
    }
    private void onClick(){
        btnSendCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etPhone.getText().toString().length() !=11){
                    etPhone.setError(getString(R.string.invalid_phone));
                }else {
                    Toast.makeText(CreateShopActivity.this, "تم ارساال الكود بنجاح", Toast.LENGTH_SHORT).show();
                    etCode.setText("5896");
                    etCreateShop.setEnabled(true);
                }
            }
        });
        etCreateShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MyDialog dialog= new MyDialog();
                dialog.show(CreateShopActivity.this);
                RequestAndResponse.createShop(CreateShopActivity.this, etPhone.getText().toString(), new BaseResponseInterface<ParentResponse>() {
                    @Override
                    public void onSuccess(ParentResponse parentResponse) {
                        Toast.makeText(CreateShopActivity.this, R.string.shop_created, Toast.LENGTH_SHORT).show();
                        UserSharedPref.setUserHasShop(CreateShopActivity.this,true);
                        dialog.hide();
                        finish();
                    }

                    @Override
                    public void onFailed(String errorMessage) {
                        Toast.makeText(CreateShopActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                        dialog.hide();
                    }
                });
            }
        });
    }
}
