package ahmed.bassiouny.fares.view.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.api.config.BaseResponseInterface;
import ahmed.bassiouny.fares.api.request.RequestAndResponse;
import ahmed.bassiouny.fares.model.Shop;
import ahmed.bassiouny.fares.utils.MyDialog;
import ahmed.bassiouny.fares.utils.MyIntentKey;
import ahmed.bassiouny.fares.view.activities.CreateShopActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class updateShopFragment extends Fragment {

    private Shop shop;

    private TextInputEditText etShopName;
    private TextInputEditText etShopDesc;
    private TextInputEditText etPhone;
    private Button btnCreateShop;

    public updateShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_shop, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etShopName = view.findViewById(R.id.et_shop_name);
        etShopDesc = view.findViewById(R.id.et_shop_desc);
        etPhone = view.findViewById(R.id.et_phone);
        btnCreateShop = view.findViewById(R.id.btn_create_shop);
        getDataFromIntentAndSetData();
        btnCreateShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etShopName.getText().toString().isEmpty()) {
                    etShopName.setError(getString(R.string.invalid_name));
                } else if (etShopDesc.getText().toString().isEmpty()) {
                    etShopDesc.setError(getString(R.string.invalid_description));
                } else {
                    final MyDialog dialog= new MyDialog();
                    dialog.show(getActivity());
                    shop.setName(etShopName.getText().toString());
                    shop.setDescription(etShopDesc.getText().toString());
                    RequestAndResponse.updateMyShop(getContext(), shop, new BaseResponseInterface<Shop>() {
                        @Override
                        public void onSuccess(Shop shop) {
                            Toast.makeText(getContext(), getString(R.string.shop_updated), Toast.LENGTH_SHORT).show();
                            getActivity().onBackPressed();
                            dialog.hide();
                        }

                        @Override
                        public void onFailed(String errorMessage) {
                            Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
                            dialog.hide();
                        }
                    });
                }
            }
        });
    }

    private void getDataFromIntentAndSetData() {
        shop = getArguments().getParcelable(MyIntentKey.SHOP);
        if (shop == null) {
            getActivity().onBackPressed();
            return;
        } else {
            etShopName.setText(shop.getName());
            etShopDesc.setText(shop.getDescription());
            etPhone.setText(shop.getPhone());
        }

    }

}
