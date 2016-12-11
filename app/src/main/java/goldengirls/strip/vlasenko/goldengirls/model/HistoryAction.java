package goldengirls.strip.vlasenko.goldengirls.model;


public class HistoryAction {
    private long userId;
    private Long girlId;
    private String text;
    private int type;
    private String time = "11-12-2016";

    public HistoryAction(long userId, String text, int type) {
        this.userId = userId;
        this.text = text;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public int getType() {
        return type;
    }

    public String getTime() {
        return time;
    }
}
