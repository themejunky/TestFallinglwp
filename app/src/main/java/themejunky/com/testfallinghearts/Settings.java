package themejunky.com.testfallinghearts;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import android.widget.Toast;


import java.util.Map;

public class Settings extends PreferenceActivity implements
		SharedPreferences.OnSharedPreferenceChangeListener,OnPreferenceClickListener {
	
	private MIP imagePreference1;
	private MIP imagePreference2;
	private MIP imagePreference3;
	private MIP shareToPreference;


	PreferenceCategory dialogBasedPrefCat;
	
	private void openLink(String var1) {
		this.startActivity(new Intent("android.intent.action.VIEW", Uri
				.parse(var1)));
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.adlayout); 
		addPreferencesFromResource(R.xml.wallpaper_settings);
		populatePreferencesDesc();
		
		if (checkForInternetConnection()) {
			admobbanner();
		}

		this.imagePreference1 = (MIP) this.findPreference("rate");
		this.imagePreference1.setOnPreferenceClickListener(this);
		this.imagePreference1.title = this.getResources().getString(
				R.string.recommend1_title);
		this.imagePreference1.mImage = R.drawable.rate;
		
		
		this.imagePreference3 = (MIP) this.findPreference("more");
		this.imagePreference3.setOnPreferenceClickListener(this);
		this.imagePreference3.title = this.getResources().getString(
				R.string.recommend3_title);
		this.imagePreference3.mImage = R.drawable.more;

		getPreferenceManager().getSharedPreferences()
				.registerOnSharedPreferenceChangeListener(this);
		getPreferenceManager().setSharedPreferencesName(
				WaterDropMain.SHARED_PREFS_NAME);
	}

	public void tst(String str) {
		Toast.makeText(Settings.this, str, Toast.LENGTH_LONG).show();
	}

	public void populatePreferencesDesc() {
		// Set up initial values for all list preferences
		Map<String, ?> sharedPreferencesMap = getPreferenceScreen()
				.getSharedPreferences().getAll();
		Preference pref;
		ListPreference listPref;
		CheckBoxPreference checkPref;
		for (Map.Entry<String, ?> entry : sharedPreferencesMap.entrySet()) {
			pref = findPreference(entry.getKey());
			if (pref instanceof ListPreference) {
				listPref = (ListPreference) pref;
				CharSequence[] mPositions = listPref.getEntries();
				int index = Integer.valueOf(listPref.getPreferenceManager()
						.getSharedPreferences().getString(entry.getKey(), "0"));

				if ((entry.getKey() == "horizontal_option") && (index < 10)) {
					index = 20;
				}
				((ListPreference) pref).setValue(index + "");

				if (index >= 10) {
					index = index / 10;
				}
			
			} else if(pref instanceof CheckBoxPreference){
				
			}
		}

	};

	@Override
	protected void onResume() {
		super.onResume();
		populatePreferencesDesc();
		// Set up a listener whenever a key changes
		getPreferenceScreen().getSharedPreferences()
				.registerOnSharedPreferenceChangeListener(this);
	}

	@Override
	protected void onDestroy() {
		getPreferenceManager().getSharedPreferences()
				.unregisterOnSharedPreferenceChangeListener(this);
		super.onDestroy();
	}

	
	private void shareThisApp() {
		String var1 = this.getString(R.string.share_title);
		String var2 = this.getString(R.string.share_text_prefix);
		String var3 = this.getString(R.string.share_text_content);
		Intent var4 = new Intent("android.intent.action.SEND");
		var4.setType("text/plain");
		var4.putExtra("android.intent.extra.SUBJECT", var1);
		var4.putExtra("android.intent.extra.TEXT", var2 + var3);
		this.startActivity(Intent.createChooser(var4, this.getTitle()));
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
	
	
	private void admobbanner() {


		DisplayMetrics dm = getResources().getDisplayMetrics();

		double density = dm.density * 160;
		double x = Math.pow(dm.widthPixels / density, 2);
		double y = Math.pow(dm.heightPixels / density, 2);
		double screenInches = Math.sqrt(x + y);



		LinearLayout adContainer = (LinearLayout) findViewById(R.id.ad_view);




	}
	
	// @Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
		Preference pref = findPreference(key);
		if (pref instanceof ListPreference) {
			ListPreference listPref = (ListPreference) pref;
			pref.setSummary(listPref.getEntry());
		}
	}

	

	
	public boolean onPreferenceClick(Preference var1) {
		if (var1 == this.imagePreference1) {
			System.out.println("imagePreference1 clicked!");
			this.openLink(this.getString(R.string.recommend1_url));
		} else if (var1 == this.imagePreference2) {
			this.openLink(this.getString(R.string.recommend2_url));
		} else if (var1 == this.imagePreference3) {
			this.openLink(this.getString(R.string.recommend3_url));
		} else if (var1 == this.shareToPreference) {
			this.shareThisApp();
		}

		return false;
	}
}
