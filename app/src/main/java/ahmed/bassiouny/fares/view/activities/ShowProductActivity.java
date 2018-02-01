package ahmed.bassiouny.fares.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.model.Product;
import ahmed.bassiouny.fares.toolbar.MyToolbar;
import ahmed.bassiouny.fares.utils.MyIntentKey;
import ahmed.bassiouny.fares.utils.UserSharedPref;
import ahmed.bassiouny.fares.view.adapter.ProductRelatedToAdapter;

public class ShowProductActivity extends MyToolbar {

    private ImageView ivMain;
    private ImageView ivSub1;
    private ImageView ivSub2;
    private ImageView ivSub3;
    private ImageView ivSub4;
    private TextView tvDescription;
    private TextView tvWholesalePrice;
    private TextView tvWholesaleCount;
    private TextView tvCountProduct;
    private Button btnAddToCart;
    private Button btnBuy;
    private TextView tvProductPrice;

    // local variable
    private Product product;
    private boolean myProduct = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_product);
        setupMyToolbar(true, true, "");
        findViewById();
        onClick();
        setProduct();
    }

    private void setProduct() {
        product = getIntent().getParcelableExtra(MyIntentKey.PRODUCT);
        myProduct = UserSharedPref.getUserId(this) == product.getOwnerId();
        if (product == null) {
            Toast.makeText(this, R.string.try_again, Toast.LENGTH_SHORT).show();
            finish();
        }else {
            toolbarTitle.setText(product.getName());
            tvDescription.setText(product.getDescription());
            tvWholesalePrice.append(" "+product.getWholesalePrice());
            tvWholesaleCount.append(" "+product.getWholesaleCount());
            tvCountProduct.append(" "+product.getAvailablePieces());
            tvProductPrice.setText(getString(R.string.eg)+" "+product.getPrice());
            if(myProduct){
                btnBuy.setVisibility(View.GONE);
                btnAddToCart.setVisibility(View.GONE);
            }else {
                btnBuy.setVisibility(View.VISIBLE);
                btnAddToCart.setVisibility(View.VISIBLE);
            }
        }
    }


    private void onClick() {
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void findViewById() {
        ivMain = findViewById(R.id.iv_main);
        ivSub1 = findViewById(R.id.iv_sub1);
        ivSub2 = findViewById(R.id.iv_sub2);
        ivSub3 = findViewById(R.id.iv_sub3);
        ivSub4 = findViewById(R.id.iv_sub4);
        tvDescription = findViewById(R.id.tv_description);
        tvWholesalePrice = findViewById(R.id.tv_wholesale_price);
        tvWholesaleCount = findViewById(R.id.tv_wholesale_count);
        tvCountProduct = findViewById(R.id.tv_count_product);
        btnAddToCart = findViewById(R.id.btn_add_to_cart);
        btnBuy = findViewById(R.id.btn_buy);
        tvProductPrice = findViewById(R.id.tv_product_price);
    }

    private void setMainImageFromSubImage(final ImageView subImage) {
        subImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivMain.setImageDrawable(subImage.getDrawable());
            }
        });
    }
}
