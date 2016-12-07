package goldengirls.strip.vlasenko.goldengirls;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

import goldengirls.strip.vlasenko.goldengirls.model.GirlsInfo;


public class ClubFragment extends Fragment {
    public ClubFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        LinearLayout ll = new LinearLayout(getActivity());
        ListView view =  new ListView(getContext());//(ListView)inflater.inflate(R.layout.one_history_view, container, false);
        ll.addView(view);
        List<GirlsInfo> clubs = getClubs();
        ArrayAdapter<GirlsInfo> adapter = new GirlsArrayAdapter(getContext(), getClubs().toArray(new GirlsInfo[clubs.size()]));
        view.setAdapter(adapter);
        return ll;
    }

    private List<GirlsInfo> getClubs(){
        return Arrays.asList(new GirlsInfo("club1", "addr1"), new GirlsInfo("club2", "addr2"));
    }
}
