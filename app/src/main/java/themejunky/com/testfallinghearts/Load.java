package themejunky.com.testfallinghearts;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class Load extends Activity {

	//final Context context = this;
	//public static Activity fa;

	public String in_show= "1";
	public String in_dont= "2";
	public String todo = "";
//	private PlusOneButton mPlusOneButton;
	private static final int PLUS_ONE_REQUEST_CODE = 9000;
	
	public void onCreate(Bundle var1) {
		super.onCreate(var1);

		//fa = this;
		setContentView(R.layout.g);
		todo=in_show;
		
		
		
		
		
		
		
		final ImageView animImageView = (ImageView) findViewById(R.id.ivAnimation);
		animImageView.setBackgroundResource(R.drawable.anim);
		animImageView.post(new Runnable() {
			@Override
			public void run() {
				AnimationDrawable frameAnimation = (AnimationDrawable) animImageView
						.getBackground();
				frameAnimation.start();
			}
		});
		
		
		
		//Toast.makeText(getApplicationContext(), "Loading ...", Toast.LENGTH_SHORT).show();
		
		final Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				
			
				finish();
			}
		}, 7000);
		
		 Button buttonStart = (Button)findViewById(R.id.ratebutton);        
	     buttonStart.setOnClickListener(startListener); 

	   // mPlusOneButton = (PlusOneButton) findViewById(R.id.plus_one_button);

		
	}

	
    private OnClickListener startListener = new OnClickListener() {
        public void onClick(View v) {
        	todo=in_dont;
        	
        	//finish();   
        	//interstitial.stopLoading();
        	
        	
        	startActivity(new Intent("android.intent.action.VIEW",
        			Uri.parse("market://details?id=" + MainActivity.APP_PNAME)));
        	
        	//System.exit(0);
        }
    };

    @Override
	public void onDestroy() {
		
    
		
		super.onDestroy();
	}
    
    @Override
    public void onPause() {
    	todo=in_dont;
    super.onPause();
    
    }
	
    
	protected void onResume() {
	    super.onResume();
	    // Refresh the state of the +1 button each time the activity receives focus.
	   // mPlusOneButton.initialize("https://market.android.com/details?id=" + getPackageName(), PLUS_ONE_REQUEST_CODE);
	    
	   
	    
	}
	

	@Override
	public void onBackPressed() {
		Toast.makeText(getApplicationContext(), "Loading , please wait", Toast.LENGTH_SHORT).show();
	}




}
