package goldengirls.strip.vlasenko.goldengirls.model;



public class GirlsInfo {
    private String name;
    private String rating;

    public GirlsInfo(String name, String rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getRating() {
        return rating;
    }
}
