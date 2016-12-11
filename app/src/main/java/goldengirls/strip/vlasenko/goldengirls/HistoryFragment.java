package goldengirls.strip.vlasenko.goldengirls;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import goldengirls.strip.vlasenko.goldengirls.model.HistoryAction;
import goldengirls.strip.vlasenko.goldengirls.model.User;
import retrofit2.Call;
import retrofit2.Response;

import static goldengirls.strip.vlasenko.goldengirls.StaticProperties.CONTEXT;
import static goldengirls.strip.vlasenko.goldengirls.StaticProperties.HTTP_CLIENT;


public class HistoryFragment extends Fragment {

    public HistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        LinearLayout ll = new LinearLayout(getActivity());
        ListView view = new ListView(getContext());
        ll.addView(view);
        List<HistoryAction> list = getHistory();
        ArrayAdapter<HistoryAction> adapter = new MyHistoryArrayAdapter(getActivity(),
                list.toArray(new HistoryAction[list.size()]));
        view.setAdapter(adapter);
        return ll;
    }

    private List<HistoryAction> getHistory() {
        long id = CONTEXT.getUser().getId();
        try {
            ApiService apiService = HTTP_CLIENT.create(ApiService.class);
            Call<List<HistoryAction>> call = apiService.getHistory(CONTEXT.getUser().getPhone());
            Response<List<HistoryAction>> response = call.execute();

            if (response.code() == HttpURLConnection.HTTP_OK) {
                return response.body();
            }
        } catch (Exception e) {
        }
        return Arrays.asList(
                new HistoryAction(id, "Привет с очаровательной Мелани", ActionType.DANCE.getType()),
                new HistoryAction(id, ActionType.BAR.getText(), ActionType.BAR.getType()),
                new HistoryAction(id, ActionType.BAR.getText(), ActionType.BAR.getType()),
                new HistoryAction(id, ActionType.BAR.getText(), ActionType.BAR.getType()),
                new HistoryAction(id, ActionType.ENTRY.getText(), ActionType.ENTRY.getType()));
    }

}
