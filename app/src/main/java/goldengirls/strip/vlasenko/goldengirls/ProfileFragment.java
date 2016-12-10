package goldengirls.strip.vlasenko.goldengirls;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.List;

import goldengirls.strip.vlasenko.goldengirls.model.ArchieveInfo;
import goldengirls.strip.vlasenko.goldengirls.model.GirlsInfo;
import goldengirls.strip.vlasenko.goldengirls.model.HistoryAction;
import retrofit2.Call;
import retrofit2.Response;

import static goldengirls.strip.vlasenko.goldengirls.StaticProperties.CONTEXT;
import static goldengirls.strip.vlasenko.goldengirls.StaticProperties.HTTP_CLIENT;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ((ImageView) view.findViewById(R.id.userAvatar)).setImageResource(R.drawable.ic_menu_camera);
        ((TextView) view.findViewById(R.id.userName)).setText(CONTEXT.getUser().getName());
        ((TextView) view.findViewById(R.id.userStatus)).setText(CONTEXT.getUser().getStatus());
        int balance = CONTEXT.getUser().getBalance();
        ((TextView) view.findViewById(R.id.userBalance)).setText(balance + " Lucky bonuses");

        TableLayout archievesLayout = (TableLayout) view.findViewById(R.id.archieves);

        List<ArchieveInfo> archieves = getArchieves();
        TableRow currentRow = new TableRow(getContext());
        int counter = 1;
        for (ArchieveInfo info : archieves) {
            if (counter == 3) {
                archievesLayout.addView(currentRow);
                currentRow = new TableRow(getContext());
            }
            LinearLayout layout = new LinearLayout(getContext());
            layout.setOrientation(LinearLayout.VERTICAL);
            currentRow.addView(layout);
            ImageView gImg = new ImageView(getContext());
            gImg.setImageResource(R.drawable.ic_menu_camera);
            layout.addView(gImg);
            TextView name = new TextView(getContext());
            name.setText(info.getName());
            layout.addView(name);
            counter++;

        }
        archievesLayout.addView(currentRow);

        return view;
    }

    private List<ArchieveInfo> getArchieves()  {
        try {
            ApiService apiService = HTTP_CLIENT.create(ApiService.class);
            Call<List<HistoryAction>> call = apiService.getHistory(CONTEXT.getUser().getPhone());
            Response<List<HistoryAction>> response = call.execute();

            if (response.code() == HttpURLConnection.HTTP_OK) {
                return null;// todo
            } else {
                AlertView.showError(getActivity());
            }
        } catch (Exception e) {
            AlertView.showError(getActivity());
        }
        return Arrays.asList(new ArchieveInfo(1, "ачивка1", "описание"),
                new ArchieveInfo(1, "ачивка2", "описание"));
    }

}
