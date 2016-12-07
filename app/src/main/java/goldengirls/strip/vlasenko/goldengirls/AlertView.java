package goldengirls.strip.vlasenko.goldengirls;

import android.content.Context;
import android.support.v7.app.AlertDialog;



public class AlertView {

    public static void showError(Context context){
        new AlertDialog.Builder(context)
                .setTitle("Техническая ошибка")
                .setMessage("В следующий раз Вам обязательно повезет, а пока вот вам котик")
                .setCancelable(true)
                .show();
    }


    public static void showSuccess(Context context){
        new AlertDialog.Builder(context)
                .setTitle("Success")
                .setCancelable(true)
                .show();
    }
}
