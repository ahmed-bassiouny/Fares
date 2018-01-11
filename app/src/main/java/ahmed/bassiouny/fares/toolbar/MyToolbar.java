package ahmed.bassiouny.fares.toolbar;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ahmed.bassiouny.fares.R;

/**
 * Created by bassiouny on 11/01/18.
 */

public class MyToolbar extends AppCompatActivity {

    private ImageView ivCart;
    private TextView tvShopCartNumber;
    private TextView toolbarTitle;
    private ImageView ivBack;

    public void setupMyToolbar(boolean showBack,boolean showCart,String title) {

        ivCart = findViewById(R.id.iv_cart);
        tvShopCartNumber = findViewById(R.id.tv_shop_cart_number);
        toolbarTitle = findViewById(R.id.toolbar_title);
        ivBack = findViewById(R.id.iv_back);
        toolbarTitle.setText(title);
        if(!showBack)
            ivBack.setVisibility(View.INVISIBLE);
        if(!showCart){
            ivCart.setVisibility(View.INVISIBLE);
            tvShopCartNumber.setVisibility(View.INVISIBLE);
        }
    }
}
