package goldengirls.strip.vlasenko.goldengirls;

import android.content.Context;
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

        final List<GirlsInfo> girls = getGirls();
        int i = 1;
        for (final GirlsInfo info : girls) {
            ImageView imgG = (ImageView) view.findViewWithTag("img" + i);
            TextView textView = (TextView) view.findViewWithTag("text" + i);

            imgG.setImageResource(info.getDrawable());
            imgG.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CONTEXT.setGirl(info);
                    ((ProfileActivity)getActivity()).displayView(R.id.girl_profile);
                }
            });
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

    private List<GirlsInfo> getGirls() {
        return Arrays.asList(new GirlsInfo("Мелани", "Утонченая красотка", R.drawable.melani),
                new GirlsInfo("Моник", "Прекрасно двигается и восхитительно поет", R.drawable.monik),
                new GirlsInfo("Саша", "Изящное создание с точеной фигуркой статуэтки", R.drawable.sasha),
                new GirlsInfo("Алиса", "За нордической сдержанностью Алисы скрывается бешеный сибирский темперамент, а ее прикосновение пьянит, как молодое вино.", R.drawable.alisa));
    }
}
