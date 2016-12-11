package goldengirls.strip.vlasenko.goldengirls;

import goldengirls.strip.vlasenko.goldengirls.model.GirlsInfo;
import goldengirls.strip.vlasenko.goldengirls.model.User;

public class GoldContext {
    private long userId;
    private User user;
    private ActionType action;
    private GirlsInfo girl;
    private String wife;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ActionType getAction() {
        return action;
    }

    public void setAction(ActionType action) {
        this.action = action;
    }

    public GirlsInfo getGirl() {
        return girl;
    }

    public void setGirl(GirlsInfo girl) {
        this.girl = girl;
    }

    public String getWife() {
        return wife;
    }

    public void setWife(String wife) {
        this.wife = wife;
    }
}
