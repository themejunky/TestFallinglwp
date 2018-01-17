package themejunky.com.testfallinghearts;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class NotifLayout extends Activity


        implements View.OnClickListener {

    //private PlusOneButton mPlusOneButton;
    private static final int PLUS_ONE_REQUEST_CODE = 9000;


    public void OnClickListen() {

        Button var1 = (Button) findViewById(R.id._rate);
        Button var2 = (Button) findViewById(R.id._no);


        var1.setOnClickListener(this);
        var2.setOnClickListener(this);


    }


    public void onClick(View var1) {
        switch (var1.getId()) {
            case (R.id._rate):

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + MainActivity.APP_PNAME));
                startActivity(i);

                break;
            case (R.id._no):

                NotifLayout.this.finish();

        }

    }


    public void onCreate(Bundle var1) {
        super.onCreate(var1);


        setContentView(R.layout.splashnr);

        OnClickListen();

        // mPlusOneButton = (PlusOneButton) findViewById(R.id.plus_one_button);

    }

    protected void onResume() {
        super.onResume();
        // Refresh the state of the +1 button each time the activity receives focus.
        // mPlusOneButton.initialize("https://market.android.com/details?id=" + getPackageName(), PLUS_ONE_REQUEST_CODE);


    }


    protected void onDestroy() {
        super.onDestroy();
    }


}