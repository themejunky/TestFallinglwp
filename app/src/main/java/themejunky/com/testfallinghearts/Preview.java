package themejunky.com.testfallinghearts;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;

public class Preview extends Activity {

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		Intent intent = new Intent();
	    /*
         * Open live wallpaper preview (API Level 16 or greater).
         */
		if (Build.VERSION.SDK_INT >= 16) {
		
			intent.setAction(WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
			String pkg = "com.lwp.falling.effect3";
			String cls = WaterDropMain.class.getCanonicalName();
			
			intent.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
					new ComponentName(pkg, cls));
		} else {
		     /*
	             * Open live wallpaper picker (API Level 15 or lower).
	             * 
	             * Display a quick little message (toast) with instructions.
	             */
			intent.setAction(WallpaperManager.ACTION_LIVE_WALLPAPER_CHOOSER);
			Resources res = getResources();
		}
		startActivityForResult(intent, 0);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);
		finish();
	}
}
