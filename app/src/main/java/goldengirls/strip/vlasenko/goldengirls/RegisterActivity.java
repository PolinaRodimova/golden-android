package goldengirls.strip.vlasenko.goldengirls;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.net.HttpURLConnection;

import goldengirls.strip.vlasenko.goldengirls.model.User;
import retrofit2.Call;
import retrofit2.Response;

import static goldengirls.strip.vlasenko.goldengirls.StaticProperties.CONTEXT;
import static goldengirls.strip.vlasenko.goldengirls.StaticProperties.HTTP_CLIENT;


public class RegisterActivity extends AppCompatActivity {
    private EditText mPhoneView;
    private EditText mNameView;
    private EditText mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mPhoneView = (EditText) findViewById(R.id.reg_phone);
        mNameView = (EditText) findViewById(R.id.reg_name);
        mPasswordView = (EditText) findViewById(R.id.reg_password);

        Button registerButton = (Button) findViewById(R.id.reg_button);
        registerButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String phone = mPhoneView.getText().toString();
                        String name = mNameView.getText().toString();
                        String password = mPasswordView.getText().toString();
                        User user = new User(Long.parseLong(phone), name, password);
                        user.setBalance(20000);
                        CONTEXT.setUser(user);
                        try {
                            ApiService apiService = HTTP_CLIENT.create(ApiService.class);
                            Call<User> call = apiService.saveUser(user);
                            Response<User> response = call.execute();

                            if (response.code() == HttpURLConnection.HTTP_OK) {
                                Intent intent = new Intent(RegisterActivity.this, ProfileActivity.class);
                                intent.setAction(Intent.ACTION_VIEW);
                                startActivity(intent);
                            } else {
                                AlertView.showError(RegisterActivity.this);
                            }
                        } catch (Exception e) {
                            AlertView.showError(RegisterActivity.this);
                        }
                    }
                }

        );

    }
}

