package il.ac.shenkar.SmartToDoList;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.DropBoxManager;

public class ReminderBroadCastReceiver extends BroadcastReceiver
{

	@TargetApi(16)
	@Override
	public void onReceive(Context context, Intent intent)
	{
		Intent myIntent = new Intent(context, MainActivity.class);
		PendingIntent pendingintent = PendingIntent.getActivity(context,0, myIntent, 0);
		String output = intent.getStringExtra("msg");
		
		NotificationManager notmanaget = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
		Notification not = new Notification.Builder(context)
					.setContentTitle("Task Reminder")
					.setContentText(output).setSmallIcon(R.drawable.yello_note_backround)
					.setContentIntent(pendingintent).build();
		// to delete the notification after it been preased
		not.flags |= Notification.FLAG_AUTO_CANCEL;
		
		notmanaget.notify(0,not);
		
		
		
		
		

	}

}
