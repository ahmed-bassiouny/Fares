package ahmed.bassiouny.fares.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.api.config.BaseResponseInterface;
import ahmed.bassiouny.fares.api.request.RequestAndResponse;
import ahmed.bassiouny.fares.model.Section;
import ahmed.bassiouny.fares.model.Shop;
import ahmed.bassiouny.fares.toolbar.MyToolbar;
import ahmed.bassiouny.fares.utils.MyDialog;
import ahmed.bassiouny.fares.utils.MyIntentKey;
import ahmed.bassiouny.fares.view.adapter.AllSectionsWithProductAdapter;

public class AllSectionsWithProductActivity extends MyToolbar {

    RecyclerView recyclerView;
    Shop shop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_sections_with_product);
        setupMyToolbar(true,true,"");
        shop = getIntent().getParcelableExtra(MyIntentKey.SHOP);
        if(shop == null){
            Toast.makeText(this, R.string.try_again, Toast.LENGTH_SHORT).show();
            finish();
        }else {
            toolbarTitle.setText(shop.getName());
            findViewById();
            fetchData();
        }

    }


    public void findViewById() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
    }

    private void fetchData(){
        final MyDialog dialog = new MyDialog();
        dialog.show(this);
        RequestAndResponse.getShop(this, 9, new BaseResponseInterface<List<Section>>() {
            @Override
            public void onSuccess(List<Section> sections) {
                AllSectionsWithProductAdapter adapter = new AllSectionsWithProductAdapter(AllSectionsWithProductActivity.this,sections);
                recyclerView.setAdapter(adapter);
                dialog.hide();
            }

            @Override
            public void onFailed(String errorMessage) {
                Toast.makeText(AllSectionsWithProductActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                dialog.hide();
            }
        });
    }
}
