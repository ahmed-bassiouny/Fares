package ahmed.bassiouny.fares.model;

/**
 * Created by bassiouny on 12/01/18.
 */

public class Shop {
    private int id;
    private String name;
    private String description;
    private int photo;

    public Shop(int id, String name,String description,int photo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPhoto() {
        return photo;
    }
}
