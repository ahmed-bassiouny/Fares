package ahmed.bassiouny.fares.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ahmed.bassiouny.fares.R;

/**
 * Created by bassiouny on 11/01/18.
 */

public class UserOrderDetailsAdapter extends RecyclerView.Adapter<UserOrderDetailsAdapter.MyViewHolder> {


    public UserOrderDetailsAdapter() {
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View view) {
            super(view);

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_order_details_adapter, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}