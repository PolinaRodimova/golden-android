package goldengirls.strip.vlasenko.goldengirls;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import static goldengirls.strip.vlasenko.goldengirls.StaticProperties.CONTEXT;

public class WifeFragment extends android.support.v4.app.Fragment {
    public WifeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wife, container, false);
        final EditText wifeText = (EditText) view.findViewById(R.id.wifeText);
        String wife = CONTEXT.getWife();
        if (wife != null && !wife.trim().isEmpty()) {
            wifeText.setText(wife);
        }
        view.findViewById(R.id.wifeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = wifeText.getText().toString();
                if (text.trim().isEmpty()) {
                    text = null;
                }
                CONTEXT.setWife(text);
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.setAction(Intent.ACTION_VIEW);
                startActivity(intent);


            }
        });

        return view;

    }
}
