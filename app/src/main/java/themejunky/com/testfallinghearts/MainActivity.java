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

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
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
    //private Main.CustomAlertDialog mDialog;
    public final static String APP_PNAME = "com.lwp.falling";
    private SharedPreferences mPref;
    // private static final int NOTE_RATE = 5 * 24 * 60 * 60 * 1000;
    private static final int NOTE_RATE = 2 * 60 * 1000; // -->> 1 min for
    // testing

    //private PlusOneButton mPlusOneButton;
    private static final int PLUS_ONE_REQUEST_CODE = 9000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashmain);
        // Important: don’t forget to change the last parameter to
        // LOG_TYPE.PRODUCTION when you are ready to release your application

        // fa=this;



        // launchMain();




        //OnClickListen();



        mPref = getSharedPreferences("Template", MODE_PRIVATE);
        if (!mPref.getBoolean("reminder", false)) {
            Log.d("reminder", mPref.getBoolean("reminder", false) + "");
            startNotifyService();

        }


        // final Handler handler = new Handler();
        // handler.postDelayed(new Runnable() {
        // @Override
        // public void run() {
        // thing();
        // }
        // }, 5001);

        else {
            OnClickListen();

            mPref = getSharedPreferences("Template", MODE_PRIVATE);
            if (!mPref.getBoolean("reminder", false)) {
                Log.d("reminder", mPref.getBoolean("reminder", false) + "");
                startNotifyService();

            }

            // end
        }
        // Load.fa.finish();



    }

    private void startNotifyService() {
        SharedPreferences.Editor e = mPref.edit();
        e.putBoolean("reminder", true);
        e.commit();
        Intent intent = new Intent(this, Notif.class);
        PendingIntent sender = PendingIntent.getBroadcast(this, 192837, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + NOTE_RATE,
                sender);
    }

    private void set() {
        Log.d("testsad","set 1");
        if (Build.VERSION.SDK_INT >= 16) {
            Log.d("testsad","set 2");
            Intent intent = new Intent(WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
            intent.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
                    new ComponentName(MainActivity.this, WaterDropMain.class));
            Log.d("testsad","set 3");
            startActivity(intent);
            Log.d("testsad","set 4");

            // finish();
        } else {
            Log.d("testsad","set else");
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

    class CustomAlertDialog extends AlertDialog {

        public CustomAlertDialog(Context var2) {
            super(var2);
        }

        public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
            boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
            // Main.this.finish();
            return bool;
        }
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
    }

    @Override
    public void onStart() {
        super.onStart();
        /**
         * start google analysis
         */
        //EasyTracker.getInstance(this).activityStart(this); // Add this method.
    }

    @Override
    public void onStop() {
        super.onStop();
        /**
         * stop google analysis
         */
        //	EasyTracker.getInstance(this).activityStop(this); // Add this method.
    }



    private void thing() {

        // Load.fa.finish();

    }




    @Override
    public void onPause() {

        super.onPause();
    }

    @Override
    public void onBackPressed() {
        if (checkForInternetConnection()) {
            todo = finish;


        } else {
            this.finish();
        }
    }



    public void OnClickListen() {


        Button var1 = (Button) findViewById(R.id.set_theme_go);
        Button var2 = (Button) findViewById(R.id.more);
        Button var3 = (Button) findViewById(R.id.settings);
        // Button var3 = (Button)findViewById(R.id.description);
        // Button var4 = (Button)findViewById(R.id.site);
        Button var5 = (Button) findViewById(R.id.rateBtn);
        ImageButton ib = (ImageButton) findViewById(R.id.i1);
        ImageButton ib2 = (ImageButton) findViewById(R.id.i2);
        ImageButton ib3 = (ImageButton) findViewById(R.id.i3);
        //ImageButton ibr = (ImageButton) findViewById(R.id.rateBtn);


        var1.setOnClickListener(this);
        var2.setOnClickListener(this);
        var3.setOnClickListener(this);
        // var4.setOnClickListener(this);
        var5.setOnClickListener(this);

        ib.setOnClickListener(this);
        ib2.setOnClickListener(this);
        ib3.setOnClickListener(this);
        //ibr.setOnClickListener(this);
        //	 mPlusOneButton = (PlusOneButton) findViewById(R.id.plus_one_button);
    }

    public boolean isPackageInstalled(String var1) {
        boolean var3;
        try {
            this.createPackageContext(var1, Context.CONTEXT_INCLUDE_CODE);
        } catch (PackageManager.NameNotFoundException var4) {
            var3 = false;
            return var3;
        }

        var3 = true;
        return var3;
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
        Log.d("testsad","click: " + checkForInternetConnection());
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
            case (R.id.more):
                if (checkForInternetConnection()) {
                    todo = buton_more;



                    // interstitial = new InterstitialAd(this,
                    // getString(R.string.ads_interstitial));
                    // AdRequest adRequest2 = new AdRequest();
                    // interstitial.loadAd(adRequest2);
                    // interstitial.setAdListener(this);
                } else {
                    this.startActivity(new Intent("android.intent.action.VIEW", Uri
                            .parse("market://search?q=pub:LiveWallpaperThemes")));
                }
                // end new

                // old code
                //
                // end old
                break;
            // case (R.id.description):
            // this.startActivity(new Intent("android.intent.action.VIEW",
            // Uri.parse("market://details?id=com.jb.gokeyboard.theme.greenflamepro")));
            // break;
            // case (R.id.site):
            // this.startActivity(new Intent("android.intent.action.VIEW",
            // Uri.parse("http://www.studio4apps.com/")));
            // break;
            case (R.id.settings):


                Intent k = new Intent(MainActivity.this, Settings.class);
                startActivity(k);
                break;
            case (R.id.i1):

                startActivity(new Intent(
                        "android.intent.action.VIEW",
                        Uri.parse("market://details?id=com.lwp.summerflowers")));

                break;
            case (R.id.i2):

                startActivity(new Intent(
                        "android.intent.action.VIEW",
                        Uri.parse("market://details?id=com.lwp.dandelion")));

                break;
            case (R.id.i3):

                startActivity(new Intent(
                        "android.intent.action.VIEW",
                        Uri.parse("market://details?id=com.lwp.fireskull")));

                break;
            case (R.id.rateBtn):
                // new code
                if (checkForInternetConnection()) {
                    todo = buton_rate;



                    // interstitial = new InterstitialAd(this,
                    // getString(R.string.ads_interstitial));
                    // AdRequest adRequest3 = new AdRequest();
                    // interstitial.loadAd(adRequest3);
                    // interstitial.setAdListener(this);
                } else {
                    Rate();
                }
                // end new

                // old
                // Rate();
                // end old
        }

    }

    private void Rate() {
        // TODO Auto-generated method stub
        Intent i = new Intent(Intent.ACTION_VIEW,
                Uri.parse("market://details?id=" + MainActivity.APP_PNAME));
        startActivity(i);
    }

    public void launchMain() {
        // finish();
        // startActivity(new Intent(Splash.this, Main.class));
        // replace MainApp.class with the actual name of the class in your app.
        Intent i = new Intent(MainActivity.this, Load.class);
        startActivity(i);

    }
}
