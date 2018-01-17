package themejunky.com.testfallinghearts;



import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class Notif extends BroadcastReceiver {

	@SuppressWarnings("deprecation")
	@Override
	public void onReceive(Context context, Intent arg1) {
		String noti_first_half = context.getString(R.string.noti_rate_first_half);
		String noti_second_half = context.getString(R.string.noti_rate_second_half);
		String noti_title = context.getString(R.string.noti_rate_title);
		//Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + Main.APP_PNAME));
		Intent intent = new Intent();
		intent.setClassName("com.lwp.falling","com.lwp.falling.NotifLayout");
		//startActivity(intent);
		PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
		NotificationManager nm = (NotificationManager)
				context.getSystemService(Context.NOTIFICATION_SERVICE);
		Notification notif = new Notification(R.mipmap.ic_launcher, noti_title,System.currentTimeMillis());
		notif.flags = Notification.DEFAULT_LIGHTS | Notification.FLAG_AUTO_CANCEL;
		CharSequence from = noti_first_half;
		CharSequence message = noti_second_half;
		//notif.setLatestEventInfo(context, from, message, pendingIntent);
		nm.notify(2, notif);
	}

}
