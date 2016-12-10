package goldengirls.strip.vlasenko.goldengirls;

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

import org.w3c.dom.Text;

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

        View view = inflater.inflate(R.layout.fragment_clubs, container, false);

        ((ImageView) view.findViewById(R.id.club_news)).setImageResource(R.drawable.action_today);

        List<GirlsInfo> girls = getGirls();
        int i = 1;
        for (GirlsInfo info : girls) {
            ImageView imgG = (ImageView) view.findViewWithTag("img" + i);
            TextView textView = (TextView) view.findViewWithTag("text" + i);

            imgG.setImageResource(getGirlImg(info.getName()));
            textView.setText(info.getName());
            Button likeButton = (Button) view.findViewWithTag("button" + i);
            likeButton.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            view.setBackgroundColor(getResources().getColor(R.color.colorAccent2));
                        }
                    }
            );
            i++;

        }
        return view;
    }

    private int getGirlImg(String name) {
        if ("саша".equalsIgnoreCase(name)) {
            return R.drawable.sasha;
        } else if ("моник".equalsIgnoreCase(name)) {
            return R.drawable.monik;
        } else if ("мелани".equalsIgnoreCase(name)) {
            return R.drawable.melani;
        } else if ("алиса".equalsIgnoreCase(name)) {
            return R.drawable.alisa;
        }
        return R.drawable.alisa;

    }

    private List<GirlsInfo> getGirls() {
        return Arrays.asList(new GirlsInfo("Мелани", "rate1"), new GirlsInfo("Моник", "rate2"),
                new GirlsInfo("Саша", "rate2"),new GirlsInfo("Алиса", "rate2"));
    }
}
