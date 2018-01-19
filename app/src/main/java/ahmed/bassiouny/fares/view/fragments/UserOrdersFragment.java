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

import java.util.ArrayList;
import java.util.List;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.interfaces.ParseObject;
import ahmed.bassiouny.fares.model.Order;
import ahmed.bassiouny.fares.view.adapter.UserOrdersAdapter;
import ahmed.bassiouny.fares.view.dialog.UserOrderetailsDialogActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserOrdersFragment extends Fragment implements ParseObject<Order> {


    private static UserOrdersFragment userOrdersFragment;
    private RecyclerView recyclerView;


    public UserOrdersFragment() {
        // Required empty public constructor
    }

    public static UserOrdersFragment newInstance() {
        if (userOrdersFragment == null)
            userOrdersFragment = new UserOrdersFragment();
        return userOrdersFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_orders, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        setFakeData();
    }

    private void setFakeData() {
        List<Order> orders = new ArrayList<>();
        Order order1 = new Order("20-9-2017",125,1);
        Order order2 = new Order("12-10-2017",189,2);
        Order order3 = new Order("9-1-2018",203,3);
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        UserOrdersAdapter userOrdersAdapter = new UserOrdersAdapter(getContext(),this,orders);
        recyclerView.setAdapter(userOrdersAdapter);
    }

    @Override
    public void parse(Order order) {
        startActivity(new Intent(getContext(), UserOrderetailsDialogActivity.class));
    }
}
