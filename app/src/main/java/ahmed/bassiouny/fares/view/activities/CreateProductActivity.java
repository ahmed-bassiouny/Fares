package ahmed.bassiouny.fares.view.activities;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.api.config.BaseResponseInterface;
import ahmed.bassiouny.fares.api.request.RequestAndResponse;
import ahmed.bassiouny.fares.model.Section;
import ahmed.bassiouny.fares.toolbar.MyToolbar;
import ahmed.bassiouny.fares.utils.MyDialog;

public class CreateProductActivity extends MyToolbar {


    private TextInputEditText etShopName;
    private Spinner spSections;
    private TextInputEditText etShopDesc;
    private TextInputEditText etPrice;
    private TextInputEditText etWholesalePrice;
    private TextInputEditText etWholesaleCount;
    private Spinner spOrderReadyAt;
    private TextInputEditText etAvailablePieces;
    private Button btnCreateProduct;

    // local variable
    private List<Integer> sectionsId;
    private List<String> sectionsName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product);
        setupMyToolbar(true,false,getString(R.string.create_product));
        findViewById();
        onClick();
        initObject();
        fetchSection();
    }

    private void initObject() {
        sectionsId = new ArrayList<>();
        sectionsName = new ArrayList<>();
    }

    private void onClick() {
        btnCreateProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void findViewById() {
        etShopName = findViewById(R.id.et_shop_name);
        spSections = findViewById(R.id.sp_sections);
        etShopDesc = findViewById(R.id.et_shop_desc);
        etPrice = findViewById(R.id.et_price);
        etWholesalePrice = findViewById(R.id.et_wholesale_price);
        etWholesaleCount = findViewById(R.id.et_wholesale_count);
        spOrderReadyAt = findViewById(R.id.sp_order_ready_at);
        etAvailablePieces = findViewById(R.id.et_available_pieces);
        btnCreateProduct = findViewById(R.id.btn_create_product);
    }

    private void fetchSection(){
        final MyDialog dialog = new MyDialog();
        dialog.show(this);
        RequestAndResponse.getSections(new BaseResponseInterface<List<Section>>() {
            @Override
            public void onSuccess(List<Section> sections) {
                if(sections != null && sections.size()>1) {
                    for (Section item : sections) {
                        sectionsId.add(item.getId());
                        sectionsName.add(item.getName());
                        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(CreateProductActivity.this,
                                android.R.layout.simple_spinner_item, sectionsName);
                        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spSections.setAdapter(dataAdapter);
                        dialog.hide();
                    }
                }else {
                    onFailed(getString(R.string.try_again));
                }
            }

            @Override
            public void onFailed(String errorMessage) {
                Toast.makeText(CreateProductActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                dialog.hide();
                finish();
            }
        });
    }
}
