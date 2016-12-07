package goldengirls.strip.vlasenko.goldengirls.model;


public class HistoryAction {
    private String text;
    private String img;
    private String time = "18-10-2016";

    public HistoryAction(String text, String img) {
        this.text = text;
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public String getImg() {
        return img;
    }

    public String getTime() {
        return time;
    }
}
