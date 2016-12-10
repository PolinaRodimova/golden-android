package goldengirls.strip.vlasenko.goldengirls.model;


import java.io.ObjectInput;
import java.io.Serializable;

public class User implements Serializable {
    private Long id;
    private String name;
    private String password;
    private String status;
    private int balance;

    public User(Long phone, String name, String password) {
        this.id = phone;
        this.name = name;
        this.password = password;
    }

    public String getPhone() {
        return String.valueOf(id);
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status == null ? "новичок" : status;
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
