package ahmed.bassiouny.fares.view.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.interfaces.MyTitle;
import ahmed.bassiouny.fares.toolbar.MyToolbar;
import ahmed.bassiouny.fares.utils.MyHelper;
import ahmed.bassiouny.fares.view.fragments.AllShopFragment;
import ahmed.bassiouny.fares.view.fragments.MyProductsCartFragment;
import ahmed.bassiouny.fares.view.fragments.ProfileFragment;

public class HomeActivity extends MyToolbar
        implements NavigationView.OnNavigationItemSelectedListener,MyTitle {
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setupMyToolbar(false, true, "");
        NavigationView navigationView = findViewById(R.id.nav_view);
        drawer = findViewById(R.id.drawer_layout);
        setDrawerLayout(drawer);

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
    }

    @Override
    public void onBackPressed() {
        drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        final int id = item.getItemId();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (id) {
                    case R.id.profile:
                        MyHelper.goToFragment(HomeActivity.this, ProfileFragment.newInstance(), false, null);
                        break;
                    case R.id.all_shops:
                        MyHelper.goToFragment(HomeActivity.this, AllShopFragment.newInstance(), false, null);
                        break;
                    case R.id.shop_cart:
                        MyHelper.goToFragment(HomeActivity.this, MyProductsCartFragment.newInstance(), false, null);
                        break;
                }
            }
        }, 250);
        drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void changeTitle(String title) {
        toolbarTitle.setText(title);
    }
}
