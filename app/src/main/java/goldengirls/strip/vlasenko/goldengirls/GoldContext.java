package goldengirls.strip.vlasenko.goldengirls;

import goldengirls.strip.vlasenko.goldengirls.model.GirlsInfo;
import goldengirls.strip.vlasenko.goldengirls.model.User;

public class GoldContext {
    private long userId;
    private User user;
    private String action;
    private GirlsInfo girl;

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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public GirlsInfo getGirl() {
        return girl;
    }

    public void setGirl(GirlsInfo girl) {
        this.girl = girl;
    }
}
