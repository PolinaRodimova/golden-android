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
        ((ImageView) rowView.findViewById(R.id.history_action_img)).setImageResource(R.drawable.ic_menu_gallery);
        ((TextView) rowView.findViewById(R.id.history_action_text)).setText(historyAction.getText());
        ((TextView) rowView.findViewById(R.id.history_action_time)).setText(historyAction.getTime());
        return rowView;
    }
}