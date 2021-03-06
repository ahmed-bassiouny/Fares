package ahmed.bassiouny.fares.view.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.api.config.BaseResponseInterface;
import ahmed.bassiouny.fares.api.request.RequestAndResponse;
import ahmed.bassiouny.fares.model.Shop;
import ahmed.bassiouny.fares.model.User;
import ahmed.bassiouny.fares.utils.MyDialog;
import ahmed.bassiouny.fares.utils.MyHelper;
import ahmed.bassiouny.fares.utils.MyIntentKey;
import ahmed.bassiouny.fares.utils.UserSharedPref;
import ahmed.bassiouny.fares.view.activities.CreateProductActivity;
import ahmed.bassiouny.fares.view.activities.MySectionsOfShopActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyShopFragment extends Fragment {

    private static MyShopFragment myShopFragment;
    private ImageView ivShop;
    private TextView tvShopDesc, tvShopName;
    private TextView tvPhone;
    private TextView tvAddProduct;
    private TextView tvEditShop;
    private TextView tvHint;
    private TextView tvViewproducts;
    private Shop shop;

    public MyShopFragment() {
        // Required empty public constructor
    }

    public static MyShopFragment newInstance() {
        if (myShopFragment == null)
            myShopFragment = new MyShopFragment();
        return myShopFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_shop, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ivShop = view.findViewById(R.id.iv_shop);
        tvShopDesc = view.findViewById(R.id.tv_shop_desc);
        tvShopName = view.findViewById(R.id.tv_shop_name);
        tvPhone = view.findViewById(R.id.tv_phone);
        tvAddProduct = view.findViewById(R.id.tv_add_product);
        tvEditShop = view.findViewById(R.id.tv_edit_shop);
        tvHint = view.findViewById(R.id.tv_hint);
        tvViewproducts = view.findViewById(R.id.tv_view_products);
        onClick();
    }

    @Override
    public void onStart() {
        super.onStart();
        shop = UserSharedPref.getMyShop(getContext());
        if (shop == null || shop.getId() == 0) {
            fetchData();
        }else {
            setShopData();
        }
    }

    private void onClick() {
        tvEditShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shop == null)
                    return;
                Bundle bundle = new Bundle();
                bundle.putParcelable(MyIntentKey.SHOP, shop);
                MyHelper.goToFragment(getActivity(), new updateShopFragment(), true, bundle);
            }
        });
        tvViewproducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shop == null)
                    return;
                Intent intent = new Intent(getContext(), MySectionsOfShopActivity.class);
                intent.putExtra(MyIntentKey.SHOP_ID, shop.getId());
                startActivity(intent);
            }
        });
        tvAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shop == null)
                    return;
                Intent intent = new Intent(getContext(), CreateProductActivity.class);
                intent.putExtra(MyIntentKey.SHOP_ID, shop.getId());
                startActivity(intent);

            }
        });
    }

    private void fetchData() {
        final MyDialog dialog = new MyDialog();
        dialog.show(getActivity());
        RequestAndResponse.getMyShop(getContext(), new BaseResponseInterface<List<Shop>>() {
            @Override
            public void onSuccess(List<Shop> shops) {
                if (shops != null && shops.size() > 0) {
                    shop = shops.get(shops.size() - 1);
                    setShopData();
                    UserSharedPref.setMyShop(getContext(),shop);
                    dialog.hide();
                } else {
                    onFailed(getString(R.string.try_again));
                }
            }

            @Override
            public void onFailed(String errorMessage) {
                Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
                tvAddProduct.setEnabled(false);
                tvViewproducts.setEnabled(false);
                tvEditShop.setEnabled(false);
                dialog.hide();
                getActivity().onBackPressed();
            }
        });
    }
    private void setShopData(){
        tvShopName.setText(shop.getName());
        tvShopDesc.setText(shop.getDescription());
        tvPhone.setText(getString(R.string.phone) + " " + shop.getPhone());
        // todo load image
        if (shop.getName().isEmpty()) {
            tvHint.setVisibility(View.VISIBLE);
            tvAddProduct.setEnabled(false);
            tvViewproducts.setEnabled(false);
        } else {
            tvHint.setVisibility(View.INVISIBLE);
            tvAddProduct.setEnabled(true);
            tvViewproducts.setEnabled(true);
        }
    }
}
