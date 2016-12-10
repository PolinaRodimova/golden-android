package goldengirls.strip.vlasenko.goldengirls;


import android.net.http.RequestQueue;
import android.os.StrictMode;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StaticProperties {

    static {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

    }

    public final static Gson GSON = new Gson();
    public final static GoldContext CONTEXT = new GoldContext();
    public final static String SERVER_PATH = "http://138.68.91.70:8080";//http://mygirls.olhovsky.me:8080";
    public final static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(5, TimeUnit.SECONDS)
            .connectTimeout(5, TimeUnit.SECONDS)
            .build();
    public final static Retrofit HTTP_CLIENT = new Retrofit.Builder()
            .baseUrl(SERVER_PATH)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
