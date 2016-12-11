package goldengirls.strip.vlasenko.goldengirls;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.timessquare.CalendarPickerView;

import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import goldengirls.strip.vlasenko.goldengirls.model.GirlsInfo;
import goldengirls.strip.vlasenko.goldengirls.model.HistoryAction;
import retrofit2.Call;
import retrofit2.Response;

import static goldengirls.strip.vlasenko.goldengirls.StaticProperties.CONTEXT;
import static goldengirls.strip.vlasenko.goldengirls.StaticProperties.HTTP_CLIENT;


public class GirlProfileFragment extends Fragment {
    public GirlProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.girl_profile, container, false);
        GirlsInfo girl = CONTEXT.getGirl();
        ((ImageView) view.findViewById(R.id.girlAvatar)).setImageResource(girl.getDrawable());
        ((TextView) view.findViewById(R.id.girlName)).setText(girl.getName());
        ((TextView) view.findViewById(R.id.girlDescription)).setText(girl.getDescription());
        (view.findViewById(R.id.girl_p_button1)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setBackgroundColor(getResources().getColor(R.color.colorAccent2));
            }
        });
        (view.findViewById(R.id.girl_p_button2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AlertView.showMessage(getContext(), "Вы уверенны?", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (sendAction()) {
                            view.setBackgroundColor(getResources().getColor(R.color.colorAccent2));
                        }
                        dialogInterface.cancel();
                    }
                });
            }
        });
        CalendarPickerView calendar = (CalendarPickerView) view.findViewById(R.id.calendar);
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);
        Calendar cccc = Calendar.getInstance();
        cccc.setTime(new Date());
        Date today = cccc.getTime();
        cccc.add(Calendar.DATE, 1);
        Date tomorrow = cccc.getTime();
        cccc.add(Calendar.DATE, 3);
        Date oneMore = cccc.getTime();


        calendar.init(today, nextYear.getTime())
                .inMode(CalendarPickerView.SelectionMode.MULTIPLE)
                .withSelectedDates(Arrays.asList(today, tomorrow, oneMore));


        return view;
    }

    private boolean sendAction() {
        try {
            ApiService apiService = HTTP_CLIENT.create(ApiService.class);
            HistoryAction action = new HistoryAction(CONTEXT.getUser().getId(), "Приват с очаровательной " + CONTEXT.getGirl().getName(),
                    ActionType.DANCE.getType());
            Call<Integer> call = apiService.registerAction(action);
            Response<Integer> response = call.execute();
            if (response.code() == HttpURLConnection.HTTP_OK) {
                AlertView.showSuccess(getContext());
                return true;
            }
        } catch (Exception e) {
        }
        AlertView.showMessage(getContext(), "Действие выполнено", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        return false;
    }

}
