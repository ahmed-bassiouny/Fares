package ahmed.bassiouny.fares.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ahmed.bassiouny.fares.R;
import ahmed.bassiouny.fares.model.Section;
import ahmed.bassiouny.fares.toolbar.MyToolbar;
import ahmed.bassiouny.fares.view.adapter.SectionOfShopAdapter;

public class SectionsOfShopActivity extends MyToolbar {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sections_of_shop);
        setupMyToolbar(true,true,"Town Team");
        findViewById();
        //setFakeData();
    }
    private void findViewById(){
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
/*    private void  setFakeData(){
        List<Section> sections = new ArrayList<>();
        Section section = new Section(1,"قسم الملابس الرجالى");
        sections.add(section);
        Section section2 = new Section(1,"قسم السيدات");
        sections.add(section2);
        Section section3 = new Section(1," قسم السيدات");
        sections.add(section3);
        Section section4 = new Section(1,"قسم الاطفال");
        sections.add(section4);
        SectionOfShopAdapter sectionOfShopAdapter = new SectionOfShopAdapter(this,sections);
        recyclerView.setAdapter(sectionOfShopAdapter);
    }*/
}
