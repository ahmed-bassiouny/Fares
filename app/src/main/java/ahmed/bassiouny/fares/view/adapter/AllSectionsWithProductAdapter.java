package ahmed.bassiouny.fares.view.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.model.Product;
import ahmed.bassiouny.fares.model.Section;

/**
 * Created by bassiouny on 11/01/18.
 */

public class AllSectionsWithProductAdapter extends RecyclerView.Adapter<AllSectionsWithProductAdapter.MyViewHolder> {

    private List<Section> sections;
    private Context context;

    public AllSectionsWithProductAdapter(Context context, List<Section> sections) {
        this.sections = sections;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        private TextView tvSectionName;
        private RecyclerView recyclerViewSection;
        private SectionProductsAdapter adapter;
        public MyViewHolder(View view) {
            super(view);
            tvSectionName = view.findViewById(R.id.tv_section_name);
            recyclerViewSection = view.findViewById(R.id.recycler_view_section);
            recyclerViewSection.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            adapter = new SectionProductsAdapter(context);
            recyclerViewSection.setAdapter(adapter);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_all_sections_with_product_adapter, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Section section = sections.get(position);
        holder.tvSectionName.setText(section.getName());
        holder.adapter.setData(section.getProducts());

    }

    @Override
    public int getItemCount() {
        return sections.size();
    }
}