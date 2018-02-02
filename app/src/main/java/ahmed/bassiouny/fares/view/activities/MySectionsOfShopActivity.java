package ahmed.bassiouny.fares.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.api.config.BaseResponseInterface;
import ahmed.bassiouny.fares.api.request.RequestAndResponse;
import ahmed.bassiouny.fares.interfaces.ParseObject;
import ahmed.bassiouny.fares.model.Section;
import ahmed.bassiouny.fares.toolbar.MyToolbar;
import ahmed.bassiouny.fares.utils.MyDialog;
import ahmed.bassiouny.fares.utils.MyIntentKey;
import ahmed.bassiouny.fares.view.adapter.MySectionOfShopAdapter;

public class MySectionsOfShopActivity extends MyToolbar implements ParseObject<Section> {

    private RecyclerView recyclerView;
    private int shopId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sections_of_shop);
        setupMyToolbar(true, true, getString(R.string.view_my_sections));
        findViewById();
        fetchData();
    }

    private void findViewById() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        shopId = getIntent().getIntExtra(MyIntentKey.SHOP_ID, 0);
    }

    @Override
    public void parse(Section section) {
        Intent intent = new Intent(MySectionsOfShopActivity.this,MyProductActivity.class);
        intent.putExtra(MyIntentKey.SHOP_ID,shopId);
        intent.putExtra(MyIntentKey.SECTION_ID,section.getId());
        startActivity(intent);
    }

    private void fetchData() {
        final MyDialog dialog = new MyDialog();
        dialog.show(this);
        RequestAndResponse.getShop(this, shopId, new BaseResponseInterface<List<Section>>() {
            @Override
            public void onSuccess(List<Section> sections) {
                MySectionOfShopAdapter adapter = new MySectionOfShopAdapter(MySectionsOfShopActivity.this, sections);
                recyclerView.setAdapter(adapter);
                dialog.hide();
            }

            @Override
            public void onFailed(String errorMessage) {
                Toast.makeText(MySectionsOfShopActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                dialog.hide();
            }
        });
    }
}
