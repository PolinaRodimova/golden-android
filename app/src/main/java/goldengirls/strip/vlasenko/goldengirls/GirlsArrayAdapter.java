package goldengirls.strip.vlasenko.goldengirls;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import goldengirls.strip.vlasenko.goldengirls.model.GirlsInfo;

public class GirlsArrayAdapter extends ArrayAdapter<GirlsInfo> {
    private final Context context;
    private final GirlsInfo[] values;

    public GirlsArrayAdapter(Context context, GirlsInfo[] values) {
        super(context, R.layout.one_girl_view, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        GirlsInfo girlsInfo = values[position];
        View rowView = inflater.inflate(R.layout.one_girl_view, parent, false);
        ((ImageView) rowView.findViewById(R.id.girl_img)).setImageResource(R.drawable.ic_menu_share);
        ((TextView) rowView.findViewById(R.id.girl_name)).setText(girlsInfo.getName());
        ((TextView) rowView.findViewById(R.id.girl_rating)).setText(girlsInfo.getRating());
        final View girlButton = rowView.findViewById(R.id.girl_button);
        girlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                girlButton.setBackgroundColor(Color.BLUE);
            }
        });
        return rowView;
    }
}