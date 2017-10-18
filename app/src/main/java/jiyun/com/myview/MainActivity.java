package jiyun.com.myview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Bitmap bitmap = loadBitmap();
        img.setImageBitmap(bitmap);

    }

    private void initView() {
        img = (ImageView) findViewById(R.id.img);
    }

    private Bitmap loadBitmap() {

        try {
            InputStream inputStream = getAssets().open("qm.jpg");
            BitmapRegionDecoder decoder = BitmapRegionDecoder.newInstance(inputStream, false);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            Rect rect = new Rect(15000, 300, 15600, 700);
            Bitmap bitmap = decoder.decodeRegion(rect, options);
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;


        }






















    }
}

