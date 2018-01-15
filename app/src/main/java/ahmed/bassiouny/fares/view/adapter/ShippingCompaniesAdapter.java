package ahmed.bassiouny.fares.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.interfaces.ParseObject;
import ahmed.bassiouny.fares.model.Product;
import ahmed.bassiouny.fares.model.ShippingCompanies;
import ahmed.bassiouny.fares.view.activities.ShowProductActivity;

/**
 * Created by bassiouny on 11/01/18.
 */

public class ShippingCompaniesAdapter extends RecyclerView.Adapter<ShippingCompaniesAdapter.MyViewHolder> {

    private List<ShippingCompanies> shippingCompanies;
    private Context context;
    private ParseObject parseObject;

    public ShippingCompaniesAdapter(Context context, List<ShippingCompanies> shippingCompanies) {
        this.shippingCompanies = shippingCompanies;
        this.context = context;
        parseObject = (ParseObject) context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private RadioButton rbShippingName;
        private TextView tvShippingSalary;

        public MyViewHolder(View view) {
            super(view);
            rbShippingName = view.findViewById(R.id.rb_shipping_name);
            tvShippingSalary = view.findViewById(R.id.tv_shipping_salary);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_shipping_companies, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final ShippingCompanies companies = shippingCompanies.get(position);
        holder.rbShippingName.setText(companies.getName());
        holder.tvShippingSalary.setText(companies.getPriceString());
        holder.rbShippingName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    parseObject.parse(companies.getPrice());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return shippingCompanies.size();
    }
}