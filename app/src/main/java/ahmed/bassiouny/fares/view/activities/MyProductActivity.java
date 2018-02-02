package ahmed.bassiouny.fares.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.api.config.BaseResponseInterface;
import ahmed.bassiouny.fares.api.request.RequestAndResponse;
import ahmed.bassiouny.fares.interfaces.MyProductInterface;
import ahmed.bassiouny.fares.model.Product;
import ahmed.bassiouny.fares.toolbar.MyToolbar;
import ahmed.bassiouny.fares.utils.MyDialog;
import ahmed.bassiouny.fares.utils.MyIntentKey;
import ahmed.bassiouny.fares.view.adapter.AllProductAdapter;
import ahmed.bassiouny.fares.view.adapter.MyProductAdapter;

public class MyProductActivity extends MyToolbar implements MyProductInterface {

    private RecyclerView recyclerView;
    private int shopId;
    private int sectionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_product);
        setupMyToolbar(true, true, getString(R.string.my_product));
        findViewById();
        fetchData();
    }

    private void fetchData() {
        shopId = getIntent().getIntExtra(MyIntentKey.SHOP_ID,0);
        sectionId = getIntent().getIntExtra(MyIntentKey.SECTION_ID,0);
        if(shopId==0 || sectionId==0){
            Toast.makeText(this, getString(R.string.try_again), Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        final MyDialog dialog = new MyDialog();
        dialog.show(this);
        RequestAndResponse.getProducts(shopId, sectionId, new BaseResponseInterface<List<Product>>() {
            @Override
            public void onSuccess(List<Product> products) {
                MyProductAdapter adapter = new MyProductAdapter(MyProductActivity.this,products);
                recyclerView.setAdapter(adapter);
                dialog.hide();
            }

            @Override
            public void onFailed(String errorMessage) {
                Toast.makeText(MyProductActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                dialog.hide();
            }
        });
    }

    private void findViewById() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void operationProduct(Product product, int operation) {
        switch (operation) {
            case VIEW:
                Intent view = new Intent(MyProductActivity.this,ShowProductActivity.class);
                view.putExtra(MyIntentKey.PRODUCT,product);
                startActivity(view);
                break;
            case EDIT:
                Intent edit = new Intent(MyProductActivity.this,CreateProductActivity.class);
                edit.putExtra(MyIntentKey.SHOP_ID, product.getShopId());
                edit.putExtra(MyIntentKey.PRODUCT,product);
                startActivityForResult(edit,1);
                break;
            case DELETE:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            fetchData();
        }
    }
}
