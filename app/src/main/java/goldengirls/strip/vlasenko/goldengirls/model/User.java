package goldengirls.strip.vlasenko.goldengirls.model;


import java.io.Serializable;

public class User implements Serializable {
    private String phone;
    private String name;
    private String password;
    private String status;
    private int balance;

    public User(String phone, String name, String password) {
        this.phone = phone;
        this.name = name;
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
}
