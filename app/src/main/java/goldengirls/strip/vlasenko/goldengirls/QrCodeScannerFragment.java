package goldengirls.strip.vlasenko.goldengirls;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Arrays;

import static goldengirls.strip.vlasenko.goldengirls.StaticProperties.CONTEXT;


public class QrCodeScannerFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.qrcode_scanner, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item,
                Arrays.asList("entry", "dance"));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner spinner = (Spinner) view.findViewById(R.id.user_actions);
        spinner.setAdapter(adapter);
        spinner.setPrompt("Actions");
        final Button mButton = (Button) view.findViewById(R.id.scan_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String action = spinner.getSelectedItem().toString();
                CONTEXT.setAction(action);
                Intent intent = new Intent(getActivity(), QrCodeScannerActivity.class);
                intent.setAction(Intent.ACTION_VIEW);
                startActivity(intent);
            }
        });
        return view;
    }

}
