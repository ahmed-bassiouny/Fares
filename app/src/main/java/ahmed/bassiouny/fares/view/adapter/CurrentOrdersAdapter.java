package ahmed.bassiouny.fares.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.model.Order;
import ahmed.bassiouny.fares.model.Product;
import ahmed.bassiouny.fares.view.activities.ShowProductActivity;

/**
 * Created by bassiouny on 11/01/18.
 */

public class CurrentOrdersAdapter extends RecyclerView.Adapter<CurrentOrdersAdapter.MyViewHolder> {

    private List<Order> orders;
    private Context context;

    public CurrentOrdersAdapter(Context context, List<Order> orders) {
        this.orders = orders;
        this.context = context;
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
                .inflate(R.layout.item_current_orders_adapter, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Order order = orders.get(position);
        holder.tvOrderDate.setText(order.getDate()+" تاريخ الطلب ");
        holder.tvOrderNumber.setText(order.getNumber()+" رقم الطلب ");
        switch (order.getStatus()){
            case 1:
                holder.tvFirstStatus.setCompoundDrawablesWithIntrinsicBounds(null,null,context.getResources().getDrawable(R.drawable.online_circle),null);
                break;
            case 2:
                holder.tvSecondStatus.setCompoundDrawablesWithIntrinsicBounds(null,null,context.getResources().getDrawable(R.drawable.online_circle),null);
                break;
            case 3:
                holder.tvThirdStatus.setCompoundDrawablesWithIntrinsicBounds(null,null,context.getResources().getDrawable(R.drawable.online_circle),null);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return orders.size();
    }
}