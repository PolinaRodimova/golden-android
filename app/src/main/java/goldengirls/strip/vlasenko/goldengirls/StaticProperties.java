package goldengirls.strip.vlasenko.goldengirls;


import android.net.http.RequestQueue;
import android.os.StrictMode;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StaticProperties {

    static {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

    }

    public final static Gson GSON = new Gson();
    public final static GoldContext CONTEXT = new GoldContext();
    public final static String SERVER_PATH = "http://ya.ru";
    public final static Retrofit HTTP_CLIENT = new Retrofit.Builder()
            .baseUrl(SERVER_PATH)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
