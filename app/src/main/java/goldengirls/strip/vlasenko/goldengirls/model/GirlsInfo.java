package goldengirls.strip.vlasenko.goldengirls.model;


public class GirlsInfo {
    private String name;
    private String description;
    private int drawable;
    private boolean online;

    public GirlsInfo(String name, String description, int drawable) {
        this(name, description, drawable, false);
    }

    public GirlsInfo(String name, String description, int drawable, boolean online) {
        this.name = name;
        this.description = description;
        this.drawable = drawable;
        this.online = online;
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

    public boolean isOnline() {
        return online;
    }
}
