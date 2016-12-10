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
        ((ImageView) view.findViewById(R.id.userAvatar)).setImageResource(R.drawable.profile_img);
        ((TextView) view.findViewById(R.id.userName)).setText(CONTEXT.getUser().getName());
        ((TextView) view.findViewById(R.id.userStatus)).setText(CONTEXT.getUser().getStatus());
        int balance = CONTEXT.getUser().getBalance();
        ((TextView) view.findViewById(R.id.userBalance)).setText(balance + " Lucky Money");

        LinearLayout archievesLayout = (LinearLayout) view.findViewById(R.id.archieve_row);

        List<ArchieveInfo> archieves = getArchieves();
        ((ImageView)view.findViewById(R.id.archievei1)).setImageResource(R.drawable.alco);
        ((TextView)view.findViewById(R.id.archivet1)).setText("Алкомастер");

        ((ImageView)view.findViewById(R.id.archievei2)).setImageResource(R.drawable.circle);
        ((TextView)view.findViewById(R.id.archivet2)).setText("Профи по приватам");

        return view;
    }

//    private void addArchieve(ArchieveInfo info, LinearLayout archievesLayout){
//        LinearLayout layout = new LinearLayout(getContext());
//        layout.setOrientation(LinearLayout.VERTICAL);
//        ImageView gImg = new ImageView(getContext());
//        gImg.setAdjustViewBounds(true);
//        gImg.setMaxHeight(200);
//        gImg.setMinimumHeight(200);
//        gImg.setImageResource(info.getId());
//        layout.addView(gImg);
//        TextView name = new TextView(getContext());
//        name.setText(info.getName());
//        layout.addView(name);
//        archievesLayout.addView(layout);
//    }

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
        return Arrays.asList(new ArchieveInfo(R.drawable.circle, "Профи по приватам", "описание"),
                new ArchieveInfo(R.drawable.alco, "Алкомастер", "описание"));
    }

}
