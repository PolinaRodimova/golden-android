package goldengirls.strip.vlasenko.goldengirls;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import static goldengirls.strip.vlasenko.goldengirls.StaticProperties.CONTEXT;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ((ImageView) view.findViewById(R.id.userAvatar)).setImageResource(R.drawable.ic_menu_camera);
        ((TextView) view.findViewById(R.id.userName)).setText(CONTEXT.getUser().getName());
        ((TextView) view.findViewById(R.id.userStatus)).setText(CONTEXT.getUser().getStatus());
        int balance = CONTEXT.getUser().getBalance();
        ((TextView) view.findViewById(R.id.userBalance)).setText(balance + " Lucky Money" );
        return view;
    }

}
