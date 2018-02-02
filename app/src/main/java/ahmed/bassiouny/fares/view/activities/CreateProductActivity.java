package ahmed.bassiouny.fares.view.activities;

import android.app.Activity;
import android.content.Intent;
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
    private List<Integer> sectionsId; // for spinner section id
    private List<String> sectionsName; // for spinner section value
    private int shopId;
    private boolean editProduct = false; // this view for create and edit product
    private Product product; // current product in eit mode

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
        product = getIntent().getParcelableExtra(MyIntentKey.PRODUCT);
        if(product != null) {
            editProduct = true;
        }
    }

    private void setProductDataInEditMode() {
        etProductName.setText(product.getName());
        etProductDesc.setText(product.getDescription());
        spSections.setSelection(getSectionPositionFromId(product.getSectionId()),true);
        etPrice.setText(product.getPrice());
        etWholesalePrice.setText(product.getWholesalePrice());
        etWholesaleCount.setText(product.getWholesaleCount());
        spOrderReadyAt.setSelection(getReadyAtTimePosition(product.getOrderReadyAt()));
        etAvailablePieces.setText(product.getAvailablePieces());
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
                    } else if(editProduct){
                        final MyDialog dialog = new MyDialog();
                        dialog.show(CreateProductActivity.this);
                        product.setName(etProductName.getText().toString());
                        product.setDescription(etProductDesc.getText().toString());
                        product.setPrice(etPrice.getText().toString());
                        product.setWholesalePrice(String.valueOf(wholesalePrice));
                        product.setWholesaleCount(String.valueOf(wholesaleCount));
                        product.setAvailablePieces(etAvailablePieces.getText().toString());
                        product.setOrderReadyAt(getReadyAtTimeValue());
                        RequestAndResponse.updateProduct(CreateProductActivity.this, product, new BaseResponseInterface<Product>() {
                            @Override
                            public void onSuccess(Product product) {
                                Toast.makeText(CreateProductActivity.this, R.string.product_created, Toast.LENGTH_SHORT).show();
                                dialog.hide();
                                Intent intent = new Intent();
                                setResult(Activity.RESULT_OK, intent);
                                finish();
                            }

                            @Override
                            public void onFailed(String errorMessage) {
                                Toast.makeText(CreateProductActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                                dialog.hide();
                            }
                        });
                    }else {
                        final MyDialog dialog = new MyDialog();
                        dialog.show(CreateProductActivity.this);
                        Product product = new Product(shopId, sectionsId.get(spSections.getSelectedItemPosition())
                                , etProductName.getText().toString(), etProductDesc.getText().toString()
                                , etPrice.getText().toString(), etAvailablePieces.getText().toString()
                                , String.valueOf(wholesaleCount), String.valueOf(wholesalePrice)
                                , getReadyAtTimeValue());
                        RequestAndResponse.createProduct(CreateProductActivity.this, product, new BaseResponseInterface<Product>() {
                            @Override
                            public void onSuccess(Product product) {
                                Toast.makeText(CreateProductActivity.this, R.string.product_created, Toast.LENGTH_SHORT).show();
                                dialog.hide();
                                Intent intent = new Intent(CreateProductActivity.this, ShowProductActivity.class);
                                intent.putExtra(MyIntentKey.PRODUCT, product);
                                startActivity(intent);
                                finish();
                            }

                            @Override
                            public void onFailed(String errorMessage) {
                                Toast.makeText(CreateProductActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                                dialog.hide();
                            }
                        });
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
                        // if this screen for edit i waiting to load section
                        // and set data in screen , choose section
                        if(editProduct){
                            setProductDataInEditMode();
                        }
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

    private String getReadyAtTimeValue() {
        // get product time to be available
        if (spOrderReadyAt.getSelectedItemPosition() == 0)
            return "24";
        else
            return "48";
    }
    private int getReadyAtTimePosition(String item) {
        // get product time to be available
        if (item.equals("24"))
            return 0;
        else
            return 1;
    }
    private int getSectionPositionFromId(int sectionId){
        int size = sectionsId.size();
        for(int i=0;i<size;i++){
            if(sectionsId.get(i)==sectionId){
                return i;
            }
        }
        return 0;
    }
}
