package ahmed.bassiouny.fares.toolbar;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
    public TextView toolbarTitle;
    private ImageView ivBack;
    private ImageView ivMenu;

    public void setupMyToolbar(boolean showBack,boolean showCart,String title) {

        ivCart = findViewById(R.id.iv_cart);
        tvShopCartNumber = findViewById(R.id.tv_shop_cart_number);
        toolbarTitle = findViewById(R.id.toolbar_title);
        ivBack = findViewById(R.id.iv_back);
        ivMenu = findViewById(R.id.iv_menu);
        toolbarTitle.setText(title);
        if(showBack) {
            ivBack.setVisibility(View.VISIBLE);
            ivMenu.setVisibility(View.INVISIBLE);
        }else {
            ivBack.setVisibility(View.INVISIBLE);
            ivMenu.setVisibility(View.VISIBLE);
        }
        if(!showCart){
            ivCart.setVisibility(View.INVISIBLE);
            tvShopCartNumber.setVisibility(View.INVISIBLE);
        }
    }
    public void setDrawerLayout(final DrawerLayout drawer){
        ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
    }
}
