package goldengirls.strip.vlasenko.goldengirls;


import java.util.List;

import goldengirls.strip.vlasenko.goldengirls.model.HistoryAction;
import goldengirls.strip.vlasenko.goldengirls.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @POST("/user")
    Call<User> saveUser(@Body User user);

    @GET("/user/{login}")
    Call<User> getUser(@Path("login")  String login);

    @POST("/action")
    Call<Integer> registerAction(@Body HistoryAction action);

    @GET("/action/")
    Call<List<HistoryAction>> getHistory(@Query("user") String login);
}
