package goldengirls.strip.vlasenko.goldengirls;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.util.Hashtable;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.WHITE;
import static goldengirls.strip.vlasenko.goldengirls.StaticProperties.CONTEXT;


public class QrCodeFragment extends Fragment {

    public QrCodeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ImageView view = new ImageView(getContext());
        try {
            Bitmap bm = encodeAsBitmap(CONTEXT.getUser().getPhone(), BarcodeFormat.QR_CODE, 150, 150);
            if (bm != null) {
                view.setImageBitmap(bm);
            }
        } catch (WriterException e) {
            AlertView.showError(getContext());
        }
        return view;
    }

    static Bitmap encodeAsBitmap(String contents,
                                 BarcodeFormat format,
                                 int desiredWidth,
                                 int desiredHeight) throws WriterException {
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>(2);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        MultiFormatWriter writer = new MultiFormatWriter();
        BitMatrix result = writer.encode(contents, format, desiredWidth, desiredHeight, hints);
        int width = result.getWidth();
        int height = result.getHeight();
        int[] pixels = new int[width * height];
        // All are 0, or black, by default
        for (int y = 0; y < height; y++) {
            int offset = y * width;
            for (int x = 0; x < width; x++) {
                pixels[offset + x] = result.get(x, y) ? BLACK : WHITE;
            }
        }

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return bitmap;
    }

}