package ahmed.bassiouny.fares.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import ahmed.bassiouny.fares.model.Section;

/**
 * Created by bassiouny on 01/02/18.
 */

public class SectionsResponse extends ParentResponse {

    @SerializedName(DATA_KEY)
    private List<Section> sections;

    public List<Section> getSections() {
        if(sections == null)
            sections = new ArrayList<>();
        return sections;
    }
}
