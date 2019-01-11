package swust.chen.tinkerandroid;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fix = findViewById(R.id.txt_fix);
        fix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });
    }

    private void init() {
        File file = new File(Environment.getExternalStorageDirectory(), "patch.apk");
        if (file.exists()) {
            Log.i("test", "文件存在");
            TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), file.getAbsolutePath());
        } else {
            Log.i("test", "文件不存在");
        }
    }
}
