package ahmed.bassiouny.fares.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.toolbar.MyToolbar;

public class EditProfileActivity extends MyToolbar {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_edit_profile);
        setupMyToolbar(true,true,getResources().getStringArray(R.array.my_setting)[0]);
    }
}
