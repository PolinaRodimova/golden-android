package goldengirls.strip.vlasenko.goldengirls.model;


public class GirlsInfo {
    private String name;
    private String description;
    private int drawable;

    public GirlsInfo(String name, String description, int drawable) {
        this.name = name;
        this.description = description;
        this.drawable = drawable;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDrawable() {
        return drawable;
    }
}
