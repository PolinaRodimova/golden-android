package goldengirls.strip.vlasenko.goldengirls;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.List;

import goldengirls.strip.vlasenko.goldengirls.model.GirlsInfo;

import static goldengirls.strip.vlasenko.goldengirls.StaticProperties.CONTEXT;


public class ClubFragment extends Fragment {
    public ClubFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_clubs, container, false);
        ((ImageView) view.findViewById(R.id.club_news)).setImageResource(R.drawable.action_today);
        GridView girlsGrid = new GridView(getContext());
        girlsGrid.setNumColumns(2);
        List<GirlsInfo> list = getGirls();
        ArrayAdapter<GirlsInfo> adapter = new GirlsArrayAdapter(
                getResources().getColor(R.color.colorAccent2),
                getActivity(),
                getActivity().getBaseContext(),
                list.toArray(new GirlsInfo[list.size()]));
        girlsGrid.setAdapter(adapter);
        ((LinearLayout)view.findViewById(R.id.girls_club)).addView(girlsGrid);
        return view;
    }

    private List<GirlsInfo> getGirls() {
        return Arrays.asList(new GirlsInfo("Мелани", "Утонченая красотка", R.drawable.melani),
                new GirlsInfo("Моник", "Прекрасно двигается и восхитительно поет", R.drawable.monik),
                new GirlsInfo("Саша", "Изящное создание с точеной фигуркой статуэтки", R.drawable.sasha),
                new GirlsInfo("Алиса", "За нордической сдержанностью Алисы скрывается бешеный сибирский темперамент, а ее прикосновение пьянит, как молодое вино.", R.drawable.alisa));
    }
}
