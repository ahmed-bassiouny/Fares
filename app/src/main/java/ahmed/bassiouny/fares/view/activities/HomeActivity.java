package ahmed.bassiouny.fares.view.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.toolbar.MyToolbar;
import ahmed.bassiouny.fares.utils.MyHelper;
import ahmed.bassiouny.fares.view.fragments.AllShopFragment;
import ahmed.bassiouny.fares.view.fragments.CreateShopFragment;
import ahmed.bassiouny.fares.view.fragments.MyShopFragment;
import ahmed.bassiouny.fares.view.fragments.UserOrdersFragment;
import ahmed.bassiouny.fares.view.fragments.MyProductsCartFragment;
import ahmed.bassiouny.fares.view.fragments.ProfileFragment;

public class HomeActivity extends MyToolbar
        implements NavigationView.OnNavigationItemSelectedListener {
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
        MyHelper.goToFragment(HomeActivity.this, AllShopFragment.newInstance(), false, null);

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
                        toolbarTitle.setText(R.string.profile);
                        MyHelper.goToFragment(HomeActivity.this, ProfileFragment.newInstance(), false, null);
                        break;
                    case R.id.all_shops:
                        toolbarTitle.setText(R.string.shops);
                        MyHelper.goToFragment(HomeActivity.this, AllShopFragment.newInstance(), false, null);
                        break;
                    case R.id.shop_cart:
                        toolbarTitle.setText(R.string.shop_cart);
                        MyHelper.goToFragment(HomeActivity.this, MyProductsCartFragment.newInstance(), false, null);
                        break;
                    case R.id.current_orders:
                        toolbarTitle.setText(R.string.current_orders);
                        MyHelper.goToFragment(HomeActivity.this, UserOrdersFragment.newInstance(), false, null);
                        break;
                    case R.id.create_shop:
                        toolbarTitle.setText(R.string.create_shop);
                        MyHelper.goToFragment(HomeActivity.this, CreateShopFragment.newInstance(), false, null);
                        break;
                    case R.id.my_shop:
                        toolbarTitle.setText(R.string.my_shop);
                        MyHelper.goToFragment(HomeActivity.this, MyShopFragment.newInstance(), false, null);
                        break;
                }
            }
        }, 250);
        drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
