package ahmed.bassiouny.fares.view.activities;

import android.support.design.widget.TextInputEditText;
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
import ahmed.bassiouny.fares.model.Product;
import ahmed.bassiouny.fares.model.Section;
import ahmed.bassiouny.fares.toolbar.MyToolbar;
import ahmed.bassiouny.fares.utils.MyDialog;
import ahmed.bassiouny.fares.utils.MyIntentKey;

public class CreateProductActivity extends MyToolbar {


    private TextInputEditText etProductName;
    private Spinner spSections;
    private TextInputEditText etProductDesc;
    private TextInputEditText etPrice;
    private TextInputEditText etWholesalePrice;
    private TextInputEditText etWholesaleCount;
    private Spinner spOrderReadyAt;
    private TextInputEditText etAvailablePieces;
    private Button btnCreateProduct;

    // local variable
    private List<Integer> sectionsId;
    private List<String> sectionsName;
    private int shopId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product);
        setupMyToolbar(true, false, getString(R.string.create_product));
        findViewById();
        onClick();
        initObject();
        fetchSection();
    }

    private void initObject() {
        sectionsId = new ArrayList<>();
        sectionsName = new ArrayList<>();
        shopId = getIntent().getIntExtra(MyIntentKey.SHOP_ID, 0);
        if (shopId == 0)
            onBackPressed();
    }

    private void onClick() {
        btnCreateProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etProductName.getText().toString().trim().isEmpty()) {
                    etProductName.setError("برجاء ادخل اسم المنتج");
                } else if (etProductDesc.getText().toString().trim().isEmpty()) {
                    etProductDesc.setError("برجاء ادخل وصف المنتج");
                } else if (etPrice.getText().toString().trim().isEmpty() || etPrice.getText().toString().trim().equals("0")) {
                    etPrice.setError("برجاء ادخل سعر المنتج");
                } else if (etAvailablePieces.getText().toString().trim().isEmpty() || etAvailablePieces.getText().toString().trim().equals("0")) {
                    etAvailablePieces.setError("برجاء ادخل عدد قطع متوفرة للمنتج");
                } else {
                    float wholesalePrice = 0;
                    float wholesaleCount = 0;
                    try {
                        wholesalePrice = Float.parseFloat(etWholesalePrice.getText().toString());
                        wholesaleCount = Integer.parseInt(etWholesaleCount.getText().toString());
                    } catch (Exception e) {
                        etWholesalePrice.setText("0");
                        etWholesaleCount.setText("0");
                        return;
                    }
                    if (wholesalePrice > 0 && wholesaleCount == 0) {
                        etWholesaleCount.setError("برجاء ادخل عدد قطع للجمله");
                    }
                    if (wholesaleCount > 0 && wholesalePrice == 0) {
                        etWholesalePrice.setError("برجاء ادخل سعر المنتج للجمله");
                    } else {
                        Product product = new Product(shopId,sectionsId.get(spSections.getSelectedItemPosition())
                                ,etProductName.getText().toString(),etProductDesc.getText().toString()
                                ,etPrice.getText().toString(),etAvailablePieces.getText().toString()
                                ,String.valueOf(wholesaleCount),String.valueOf(wholesalePrice)
                                ,getReadyAtTime());
                    }
                }
            }
        });
    }

    private void findViewById() {
        etProductName = findViewById(R.id.et_product_name);
        spSections = findViewById(R.id.sp_sections);
        etProductDesc = findViewById(R.id.et_product_desc);
        etPrice = findViewById(R.id.et_price);
        etWholesalePrice = findViewById(R.id.et_wholesale_price);
        etWholesaleCount = findViewById(R.id.et_wholesale_count);
        spOrderReadyAt = findViewById(R.id.sp_order_ready_at);
        etAvailablePieces = findViewById(R.id.et_available_pieces);
        btnCreateProduct = findViewById(R.id.btn_create_product);
    }

    private void fetchSection() {
        final MyDialog dialog = new MyDialog();
        dialog.show(this);
        RequestAndResponse.getSections(new BaseResponseInterface<List<Section>>() {
            @Override
            public void onSuccess(List<Section> sections) {
                if (sections != null && sections.size() > 1) {
                    for (Section item : sections) {
                        sectionsId.add(item.getId());
                        sectionsName.add(item.getName());
                        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(CreateProductActivity.this,
                                android.R.layout.simple_spinner_item, sectionsName);
                        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spSections.setAdapter(dataAdapter);
                        dialog.hide();
                    }
                } else {
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
    private String getReadyAtTime(){
        // get product time to be available
        if(spOrderReadyAt.getSelectedItemPosition()==0)
            return "24";
        else
            return "48";
    }
}
