package goldengirls.strip.vlasenko.goldengirls;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.HttpURLConnection;

import goldengirls.strip.vlasenko.goldengirls.model.User;
import retrofit2.Call;
import retrofit2.Response;

import static goldengirls.strip.vlasenko.goldengirls.StaticProperties.CONTEXT;
import static goldengirls.strip.vlasenko.goldengirls.StaticProperties.HTTP_CLIENT;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final EditText login = (EditText) findViewById(R.id.loginText);
        final EditText password = (EditText) findViewById(R.id.passwordText);

        Button buttonSign = (Button) findViewById(R.id.buttonSign);
        buttonSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginStr = login.getText().toString();
                String pwdStr = password.getText().toString();
                User user = new User(Long.parseLong(loginStr), "Илюха", pwdStr);
                user.setStatus("новичок");
                try {
                    ApiService apiService = HTTP_CLIENT.create(ApiService.class);
                    Call<User> call = apiService.getUser(loginStr);
                    Response<User> response = call.execute();

                    if (response.code() == HttpURLConnection.HTTP_OK) {
                        CONTEXT.setUser(response.body());
                        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                        intent.setAction(Intent.ACTION_VIEW);
                        startActivity(intent);
                    } else {
                        AlertView.showError(MainActivity.this);
                        CONTEXT.setUser(user);
                        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                        intent.setAction(Intent.ACTION_VIEW);
                        startActivity(intent);
                    }
                } catch (Exception e) {
                    AlertView.showError(MainActivity.this);
                    CONTEXT.setUser(user);
                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    intent.setAction(Intent.ACTION_VIEW);
                }

                }
        });
        Button buttonRegister = (Button) findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                intent.setAction(Intent.ACTION_VIEW);
                startActivity(intent);
            }
        });
    }

}
