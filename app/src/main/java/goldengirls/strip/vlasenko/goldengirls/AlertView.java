package goldengirls.strip.vlasenko.goldengirls;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class AlertView {

    public static void showError(Context context){
        LinearLayout view = new LinearLayout(context);
        ImageView cat = new ImageView(context);
        cat.setImageResource(R.drawable.cat);
        view.addView(cat);
        TextView textView = new TextView(context);
        textView.setText("В следующий раз Вам обязательно повезет, а пока вот вам котик");
        view.addView(textView);
        new AlertDialog.Builder(context)
                .setTitle("Техническая ошибка")
                .setView(view)
                .setNegativeButton(R.string.label_ok
                        , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setCancelable(true)
                .show();
    }


    public static void showSuccess(Context context){
        new AlertDialog.Builder(context)
                .setTitle("Success")
                .setCancelable(true)
                .show();
    }

    public static void showMessage(Context context, String text, DialogInterface.OnClickListener listener){
        new AlertDialog.Builder(context)
                .setTitle(text)
                .setCancelable(true)
                .setPositiveButton(R.string.label_yes, listener)
                .setNegativeButton(R.string.label_no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .show();
    }
}
