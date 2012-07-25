package net.pikanji.sharedpreferencesclient;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;

public class MainActivity extends Activity {
    private static final String TAG = "SharedPreferencesClient.MainActivity";
    private static final String FILE_PATH = "/data/data/net.pikanji.sharedpreferencesserver/shared_prefs/test_file.xml";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            Log.e(TAG, "File not found");
            return;
        }
        
        InputStream in = null;
        try {
          in = new BufferedInputStream(new FileInputStream(file));
          byte readBytes[] = new byte[in.available()];
          in.read(readBytes);
          in.close();
          Log.e(TAG, new String(readBytes));
        } catch (Exception e) {
          Log.e(TAG, e.getMessage());
        }
    }
}
