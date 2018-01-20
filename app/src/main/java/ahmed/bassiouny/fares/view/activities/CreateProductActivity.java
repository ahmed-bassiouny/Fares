package ahmed.bassiouny.fares.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.toolbar.MyToolbar;

public class CreateProductActivity extends MyToolbar {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product);
        setupMyToolbar(true,false,getString(R.string.create_product));
    }
}
