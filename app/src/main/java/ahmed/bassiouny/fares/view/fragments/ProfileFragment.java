package ahmed.bassiouny.fares.view.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.interfaces.MyProfileInterface;
import ahmed.bassiouny.fares.view.activities.EditProfileActivity;
import ahmed.bassiouny.fares.view.activities.RateSuppliersActivity;
import ahmed.bassiouny.fares.view.adapter.MySettingAdapter;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements MyProfileInterface{


    private CircleImageView profileImage;
    private TextView tvName;
    private TextView tvPhone;
    private TextView tvAddress;
    private RecyclerView recyclerView;
    private static ProfileFragment profileFragment;
    
    public ProfileFragment() {
        // Required empty public constructor
    }
    public static ProfileFragment newInstance(){
        if(profileFragment == null)
            profileFragment = new ProfileFragment();
        return profileFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        profileImage = view.findViewById(R.id.profile_image);
        tvName = view.findViewById(R.id.tv_name);
        tvPhone = view.findViewById(R.id.tv_phone);
        tvAddress = view.findViewById(R.id.tv_address);
        recyclerView = view.findViewById(R.id.recycler_view);
        
        setSettingData();
    }

    private void setSettingData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        MySettingAdapter mySettingAdapter = new MySettingAdapter(this,getResources().getStringArray(R.array.my_setting));
        recyclerView.setAdapter(mySettingAdapter);
    }

    @Override
    public void ClickItem(int position) {
        switch (position){
            case 0:
                startActivity(new Intent(getContext(), EditProfileActivity.class));
                break;
            case 3:
                startActivity(new Intent(getContext(), RateSuppliersActivity.class));
                break;
        }
    }
}
