package ahmed.bassiouny.fares.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.interfaces.ParseObject;
import ahmed.bassiouny.fares.model.Order;

/**
 * Created by bassiouny on 11/01/18.
 */

public class UserOrdersAdapter extends RecyclerView.Adapter<UserOrdersAdapter.MyViewHolder> {

    private List<Order> orders;
    private Context context;
    private ParseObject parseObject;

    public UserOrdersAdapter(Context context, Fragment fragment, List<Order> orders) {
        this.orders = orders;
        this.context = context;
        this.parseObject = (ParseObject) fragment;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvOrderNumber;
        private TextView tvOrderDate;
        private Button btnDelivered;
        private Button btnShowMore;
        private TextView tvFirstStatus,tvSecondStatus,tvThirdStatus;

        public MyViewHolder(View view) {
            super(view);
            tvOrderNumber = view.findViewById(R.id.tv_order_number);
            tvOrderDate = view.findViewById(R.id.tv_order_date);
            btnDelivered = view.findViewById(R.id.btn_delivered);
            btnShowMore = view.findViewById(R.id.btn_show_more);

            tvFirstStatus = view.findViewById(R.id.tv_first_status);
            tvSecondStatus = view.findViewById(R.id.tv_second_status);
            tvThirdStatus = view.findViewById(R.id.tv_third_status);

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_orders_adapter, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Order order = orders.get(position);
        holder.tvOrderDate.setText(order.getDate()+" تاريخ الطلب ");
        holder.tvOrderNumber.setText(order.getNumber()+" رقم الطلب ");
        switch (order.getStatus()){
            case 1:
                holder.tvFirstStatus.setCompoundDrawablesWithIntrinsicBounds(null,context.getResources().getDrawable(R.drawable.online_circle),null,null);
                break;
            case 2:
                holder.tvFirstStatus.setCompoundDrawablesWithIntrinsicBounds(null,context.getResources().getDrawable(R.drawable.online_circle),null,null);
                holder.tvSecondStatus.setCompoundDrawablesWithIntrinsicBounds(null,context.getResources().getDrawable(R.drawable.online_circle),null,null);
                holder.btnDelivered.setVisibility(View.INVISIBLE);
                break;
            case 3:
                holder.tvFirstStatus.setCompoundDrawablesWithIntrinsicBounds(null,context.getResources().getDrawable(R.drawable.online_circle),null,null);
                holder.tvSecondStatus.setCompoundDrawablesWithIntrinsicBounds(null,context.getResources().getDrawable(R.drawable.online_circle),null,null);
                holder.tvThirdStatus.setCompoundDrawablesWithIntrinsicBounds(null,context.getResources().getDrawable(R.drawable.online_circle),null,null);
                holder.btnDelivered.setVisibility(View.GONE);
                break;
        }
        holder.btnShowMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseObject.parse(order);
            }
        });

    }

    @Override
    public int getItemCount() {
        return orders.size();
    }
}