package themejunky.com.testfallinghearts;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // new code
    public String buton_set_theme_go = "1";
    public String buton_more = "2";
    public String buton_rate = "3";
    public String finish = "4";
    public String todo = "";
    public String showinter = "";
    public String in_show = "1";
    public String in_dont = "2";
    public String load = "";
    public String loadon = "1";
    public String loadoff = "2";
    // end
    public static Activity fa;

    private SharedPreferences mPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashmain);

        mPref = getSharedPreferences("Template", MODE_PRIVATE);
        if (!mPref.getBoolean("reminder", false)) {
            Log.d("reminder", mPref.getBoolean("reminder", false) + "");


        } else {
            OnClickListen();

            mPref = getSharedPreferences("Template", MODE_PRIVATE);
            if (!mPref.getBoolean("reminder", false)) {
                Log.d("reminder", mPref.getBoolean("reminder", false) + "");

            }
        }


    }


    private void set() {
        Log.d("testsad", "set 1");
        if (Build.VERSION.SDK_INT >= 16) {
            Log.d("testsad", "set 2");
            Intent intent = new Intent(WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
            intent.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
                    new ComponentName(MainActivity.this, WaterDropMain.class));
            Log.d("testsad", "set 3");
            startActivity(intent);
            Log.d("testsad", "set 4");

            // finish();
        } else {
            Log.d("testsad", "set else");
            Toast.makeText(
                    MainActivity.this,
                    "Choose \'"
                            + MainActivity.this
                            .getString(R.string.app_name)
                            + "\' in the list to start the Live Wallpaper.",
                    Toast.LENGTH_SHORT).show();
            Intent var6 = new Intent();
            var6.setAction("android.service.wallpaper.LIVE_WALLPAPER_CHOOSER");
            MainActivity.this.startActivity(var6);
        }


    }


    public void OnClickListen() {


        Button var1 = (Button) findViewById(R.id.set_theme_go);
        Button var3 = (Button) findViewById(R.id.settings);

        var1.setOnClickListener(this);
        var3.setOnClickListener(this);

    }

    public boolean checkForInternetConnection() {

        ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        // ARE WE CONNECTED TO THE NET
        if (conMgr.getActiveNetworkInfo() != null
                && conMgr.getActiveNetworkInfo().isAvailable()
                && conMgr.getActiveNetworkInfo().isConnected()) {
            return true;
        } else
            return false;
    }

    // @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void onClick(View var1) {
        Log.d("testsad", "click: " + checkForInternetConnection());
        switch (var1.getId()) {
            case (R.id.set_theme_go):
                if (checkForInternetConnection()) {
                    set();
                    todo = buton_set_theme_go;
                    load = loadoff;
                } else {
                    set();
                }
                break;
            case (R.id.settings):
                Intent k = new Intent(MainActivity.this, Settings.class);
                startActivity(k);
                break;


        }
    }


}
