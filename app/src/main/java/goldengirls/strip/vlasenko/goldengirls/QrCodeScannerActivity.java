package goldengirls.strip.vlasenko.goldengirls;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.net.HttpURLConnection;
import java.util.Arrays;

import goldengirls.strip.vlasenko.goldengirls.model.HistoryAction;
import retrofit2.Call;
import retrofit2.Response;

import static goldengirls.strip.vlasenko.goldengirls.StaticProperties.CONTEXT;
import static goldengirls.strip.vlasenko.goldengirls.StaticProperties.HTTP_CLIENT;

public class QrCodeScannerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IntentIntegrator integrator = new IntentIntegrator(QrCodeScannerActivity.this);
        integrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                AlertView.showError(getBaseContext());
            } else {
                String userPhone = result.getContents();
                ActionType action = CONTEXT.getAction();
                sendUserActivity(userPhone, action);
            }
        } else {
            AlertView.showError(getBaseContext());
        }

        Intent intent = new Intent(QrCodeScannerActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    private void sendUserActivity(String userPhone, ActionType action) {
        try {
            ApiService apiService = HTTP_CLIENT.create(ApiService.class);
            HistoryAction actionAPI = new HistoryAction(Long.parseLong(userPhone), action.getText(),
                    action.getType());
            Call<Integer> call = apiService.registerAction(actionAPI);
            Response<Integer> response = call.execute();

            if (response.code() == HttpURLConnection.HTTP_OK) {
                AlertView.showSuccess(getBaseContext());
            } else {
                AlertView.showError(getBaseContext());
            }
        } catch (Exception e) {
            AlertView.showError(getBaseContext());
        }
    }
}
