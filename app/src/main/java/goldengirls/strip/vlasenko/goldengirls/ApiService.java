package goldengirls.strip.vlasenko.goldengirls;


import java.util.List;

import goldengirls.strip.vlasenko.goldengirls.model.HistoryAction;
import goldengirls.strip.vlasenko.goldengirls.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @POST("/user")
    Call<User> saveUser(@Body User user);

    @GET("/user/{login}")
    Call<User> getUser(@Path("login")  String login);

    @POST("/action/{action}/{login}")
    Call<Integer> registerAction(@Path("action") String action, @Path("login") String login);

    @GET("/history//{login}")
    Call<List<HistoryAction>> getHistory(@Path("login") String login);
}
