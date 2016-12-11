package goldengirls.strip.vlasenko.goldengirls;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import goldengirls.strip.vlasenko.goldengirls.model.HistoryAction;


public class MyHistoryArrayAdapter extends ArrayAdapter<HistoryAction> {
    private final Context context;
    private final HistoryAction[] values;

    public MyHistoryArrayAdapter(Context context, HistoryAction[] values) {
        super(context, R.layout.one_history_view, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        HistoryAction historyAction = values[position];
        View rowView = inflater.inflate(R.layout.one_history_view, parent, false);
        int actionImg;
        switch (historyAction.getType()){
            case 1: actionImg = R.drawable.privat; break;
            case 2: actionImg = R.drawable.en1; break;
            case 3: actionImg = R.drawable.bar; break;
            default: actionImg = R.drawable.gg_logo;
        }
        ((ImageView) rowView.findViewById(R.id.history_action_img)).setImageResource(actionImg);
        ((TextView) rowView.findViewById(R.id.history_action_text)).setText(historyAction.getText());
        ((TextView) rowView.findViewById(R.id.history_action_time)).setText(historyAction.getTime());
        return rowView;
    }
}