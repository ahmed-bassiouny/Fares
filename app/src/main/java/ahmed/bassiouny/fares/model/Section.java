package ahmed.bassiouny.fares.model;

/**
 * Created by bassiouny on 12/01/18.
 */

public class Section {
    private int id;
    private String name;

    public Section(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
