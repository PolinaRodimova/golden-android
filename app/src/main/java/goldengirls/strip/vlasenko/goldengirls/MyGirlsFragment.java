package goldengirls.strip.vlasenko.goldengirls;


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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import goldengirls.strip.vlasenko.goldengirls.model.GirlsInfo;
import goldengirls.strip.vlasenko.goldengirls.model.HistoryAction;

import static goldengirls.strip.vlasenko.goldengirls.StaticProperties.CONTEXT;

public class MyGirlsFragment  extends Fragment {
    public MyGirlsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        GridView view = new GridView(getContext());
        view.setNumColumns(2);
        List<GirlsInfo> list = getGirls();
        ArrayAdapter<GirlsInfo> adapter = new GirlsArrayAdapter(
                getResources().getColor(R.color.colorAccent2),
                getActivity(),
                getActivity().getBaseContext(),
                list.toArray(new GirlsInfo[list.size()]));
        view.setAdapter(adapter);

        return view;
    }

    private List<GirlsInfo> getGirls() {
        return Arrays.asList(new GirlsInfo("Мелани", "Утонченая красотка", R.drawable.melani, true),
                new GirlsInfo("Алиса", "За нордической сдержанностью Алисы скрывается бешеный сибирский темперамент, а ее прикосновение пьянит, как молодое вино.", R.drawable.alisa, true),
                new GirlsInfo("Николь", "Неукротимая, как ветер и ласковая, как ручной зверек", R.drawable.nikol,  false),
                new GirlsInfo("Полночь", "Девчонка из соседнего двора, дерзкая и шаловливая, но одновременно женственная и чувственная.", R.drawable.polnch,  false),
                new GirlsInfo("Хлоя", "Изящное создание с точеной фигуркой статуэтки, модельной внешностью и шальным блеском в глазах\n", R.drawable.hloya,  false)
                );
    }
}
