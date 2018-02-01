package ahmed.bassiouny.fares.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.interfaces.MyProfileInterface;

/**
 * Created by bassiouny on 11/01/18.
 */

public class MySettingAdapter extends RecyclerView.Adapter<MySettingAdapter.MyViewHolder> {

    private String[] settings;
    private MyProfileInterface myProfileInterface;

    public MySettingAdapter(Fragment fragment, String[] settings) {
        this.myProfileInterface = (MyProfileInterface) fragment;
        this.settings = settings;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private TextView tvSection;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvSection = itemView.findViewById(R.id.tv_section);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_my_section_of_shop_adapter, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        String setting = settings[position];
        holder.tvSection.setText(setting);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myProfileInterface.ClickItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return settings.length;
    }
}