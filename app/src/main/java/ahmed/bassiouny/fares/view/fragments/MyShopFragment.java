package ahmed.bassiouny.fares.view.fragments;


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
import ahmed.bassiouny.fares.utils.MyDialog;
import ahmed.bassiouny.fares.utils.MyHelper;
import ahmed.bassiouny.fares.utils.MyIntentKey;

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
        onClick();
        fetchData();
    }

    private void onClick() {
        tvEditShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(shop == null)
                    return;
                Bundle bundle = new Bundle();
                bundle.putParcelable(MyIntentKey.SHOP,shop);
                MyHelper.goToFragment(getActivity(),new updateShopFragment(),true,bundle);
            }
        });
    }

    private void fetchData() {
        MyDialog.show(getContext());
        RequestAndResponse.getMyShop(getContext(), new BaseResponseInterface<List<Shop>>() {
            @Override
            public void onSuccess(List<Shop> shops) {
                if (shops != null && shops.size() > 0) {
                    shop = shops.get(shops.size() - 1);
                    tvShopName.setText(shop.getName());
                    tvShopDesc.setText(shop.getDescription());
                    tvPhone.append(shop.getPhone());
                    // todo load image
                    if (shop.getName().isEmpty()) {
                        // i need to complete information
                        tvHint.setVisibility(View.VISIBLE);
                        tvAddProduct.setEnabled(false);
                    } else {
                        // information completed
                        tvHint.setVisibility(View.INVISIBLE);
                        tvAddProduct.setEnabled(true);
                    }
                    MyDialog.hide();
                } else {
                    onFailed(getString(R.string.try_again));
                }
            }

            @Override
            public void onFailed(String errorMessage) {
                Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
                tvAddProduct.setEnabled(false);
                tvEditShop.setEnabled(false);
                MyDialog.hide();
                getActivity().onBackPressed();
            }
        });
    }
}
