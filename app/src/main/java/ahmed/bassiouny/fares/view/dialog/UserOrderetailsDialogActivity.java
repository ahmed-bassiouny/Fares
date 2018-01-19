package ahmed.bassiouny.fares.view.dialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.view.adapter.UserOrderDetailsAdapter;

public class UserOrderetailsDialogActivity extends AppCompatActivity{

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_order_details_dialog);
        findViewById();
    }


    private void findViewById() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        UserOrderDetailsAdapter adapter = new UserOrderDetailsAdapter();
        recyclerView.setAdapter(adapter);
        findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
