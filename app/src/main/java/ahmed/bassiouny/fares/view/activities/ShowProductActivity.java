package ahmed.bassiouny.fares.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.model.Product;
import ahmed.bassiouny.fares.toolbar.MyToolbar;
import ahmed.bassiouny.fares.view.adapter.ProductRelatedToAdapter;

public class ShowProductActivity extends MyToolbar {

    private ImageView ivMain;
    private ImageView ivSub1;
    private ImageView ivSub2;
    private ImageView ivSub3;
    private ImageView ivSub4;
    private TextView tvDescription;
    private RecyclerView recyclerView;
    private Button btnBuy,btnAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_product);
        setupMyToolbar(true,true,"بنطلون جينز");
        findViewById();
        onClick();
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
        recyclerView = findViewById(R.id.recycler_view);
        btnBuy = findViewById(R.id.btn_buy);
        btnAddToCart = findViewById(R.id.btn_add_to_cart);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }
    private void setMainImageFromSubImage(final ImageView subImage){
        subImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivMain.setImageDrawable(subImage.getDrawable());
            }
        });
    }
}
