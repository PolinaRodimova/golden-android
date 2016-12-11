package goldengirls.strip.vlasenko.goldengirls;


public enum ActionType {
    DANCE(1, "Приват"),
    ENTRY(2, "Вход в клуб"),
    BAR(3, "Виски в баре");

    private final int type;
    private final String text;

    ActionType(int type, String text) {
        this.type = type;
        this.text = text;
    }

    public int getType() {
        return type;
    }

    public String getText() {
        return text;
    }
}
