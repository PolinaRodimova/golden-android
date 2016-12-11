package goldengirls.strip.vlasenko.goldengirls;


import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import goldengirls.strip.vlasenko.goldengirls.model.GirlsInfo;

import static goldengirls.strip.vlasenko.goldengirls.StaticProperties.CONTEXT;

public class GirlsArrayAdapter extends ArrayAdapter<GirlsInfo> {
    private final Context context;
    private final GirlsInfo[] values;
    private final int color;
    private final ProfileActivity activity;

    public GirlsArrayAdapter(int color, FragmentActivity activity, Context context, GirlsInfo[] values) {
        super(context, R.layout.one_girl_view, values);
        this.color = color;
        this.context = context;
        this.values = values;
        this.activity = (ProfileActivity)activity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final GirlsInfo info = values[position];
        View rowView = inflater.inflate(R.layout.one_girl_view, parent, false);
        ImageView imgG = (ImageView) rowView.findViewById(R.id.girl_img);
        imgG.setImageResource(info.getDrawable());
        imgG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CONTEXT.setGirl(info);
                activity.displayView(R.id.girl_profile);
            }
        });
        TextView textView = (TextView) rowView.findViewById(R.id.girl_text);
        String text = info.getName();
        if (info.isOnline()){
            text = text + " (сегодня в клубе!)";
        }
        textView.setText(text);
        Button likeButton = (Button) rowView.findViewById(R.id.girl_button);
        likeButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view.setBackgroundColor(color);
                    }
                }
        );

        return rowView;
    }
}