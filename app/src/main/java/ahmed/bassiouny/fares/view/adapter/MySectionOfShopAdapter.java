package ahmed.bassiouny.fares.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.interfaces.ParseObject;
import ahmed.bassiouny.fares.model.Section;
import ahmed.bassiouny.fares.view.activities.AllProductActivity;

/**
 * Created by bassiouny on 11/01/18.
 */

public class MySectionOfShopAdapter extends RecyclerView.Adapter<MySectionOfShopAdapter.MyViewHolder> {

    private List<Section> sections;
    private Context context;
    private ParseObject parseObject;

    public MySectionOfShopAdapter(Context context, List<Section> sections) {
        this.context=context;
        this.sections = sections;
        parseObject = (ParseObject) context;
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
        final Section section = sections.get(position);
        holder.tvSection.setText(section.getName());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseObject.parse(section);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sections.size();
    }
}