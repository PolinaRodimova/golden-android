package goldengirls.strip.vlasenko.goldengirls;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.List;

import goldengirls.strip.vlasenko.goldengirls.model.ArchieveInfo;
import goldengirls.strip.vlasenko.goldengirls.model.HistoryAction;
import retrofit2.Call;
import retrofit2.Response;

import static goldengirls.strip.vlasenko.goldengirls.StaticProperties.CONTEXT;
import static goldengirls.strip.vlasenko.goldengirls.StaticProperties.HTTP_CLIENT;

public class QuestFragment extends Fragment {

    public QuestFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TableLayout view = new TableLayout(getContext());
        int progress = getProgress();
        view.addView(createRow(inflater, container, R.drawable.privat2, "Закажи приват с двумя девушками", "В подарок ты получишь 500 Lucky Money", 100, View.INVISIBLE));
        view.addView(createRow(inflater, container,  progress < 100  ? R.drawable.bar : R.drawable.bar2, "Выпей коктейль в баре", "В подарок ты получишь вкусный десерт", progress, progress < 100 ? View.VISIBLE : View.INVISIBLE));
        view.addView(createRow(inflater, container, R.drawable.friend, "Пригласи друга", "Приведи друга и получи скидку 10% на бар", 0, View.INVISIBLE));
        return view;
    }

    private View createRow(LayoutInflater inflater, ViewGroup container, int resource, String text, String desc, int progress, int visible) {
        View view = inflater.inflate(R.layout.quest_block, container, false);
        ImageView img = (ImageView) view.findViewById(R.id.quest_img);
        img.setImageResource(resource);
        TextView textView = (TextView) view.findViewById(R.id.quest_name);
        textView.setText(text);
        TextView descView = (TextView) view.findViewById(R.id.quest_description);
        descView.setText(desc);
        ProgressBar progressView = (ProgressBar) view.findViewById(R.id.quest_progress);
        progressView.setVisibility(visible);
        progressView.setProgress(progress);
        return view;
    }

    private int getProgress() {
        try {
            ApiService apiService = HTTP_CLIENT.create(ApiService.class);
            Call<List<HistoryAction>> call = apiService.getHistory(CONTEXT.getUser().getPhone());
            Response<List<HistoryAction>> response = call.execute();

            if (response.code() == HttpURLConnection.HTTP_OK) {
                return 50;
            } else {
                AlertView.showError(getActivity());
            }
        } catch (Exception e) {
            AlertView.showError(getActivity());
        }
        return 50;
    }

}
