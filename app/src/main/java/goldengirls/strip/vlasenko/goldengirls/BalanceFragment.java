package goldengirls.strip.vlasenko.goldengirls;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by polina.vlasenko on 10/12/16.
 */

public class BalanceFragment extends Fragment {
    public BalanceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.balance, container, false);
    }
}
