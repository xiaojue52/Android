package com.example.android1219.service;

import com.example.android1219.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

public class MyLocalService extends Service {
	private NotificationManager mNM;
	private LocalBroadcastManager broadcaster;
	public static final String COPA_RESULT = "com.example.android1219.REQUEST_PROCESSED";
	public static final String NAME ="name";

	private static final String TAG = "MyService";
	MediaPlayer player;

	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}

	private final IBinder mBinder = new LocalBinder();

	public class LocalBinder extends Binder {
		public MyLocalService getService() {
			return MyLocalService.this;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onCreate() {
		Toast.makeText(this, "My Service Created", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onCreate");
		mNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		Notification notification = new Notification(R.drawable.ic_launcher, "text",
                System.currentTimeMillis());
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, ThirdActivity.class), 0);

        // Set the info for the views that show in the notification panel.
        notification.setLatestEventInfo(this, "1",
                       "text", contentIntent);

		mNM.notify(1, notification);
		player = MediaPlayer.create(this, R.raw.test);
		player.setLooping(false); // Set looping
		broadcaster = LocalBroadcastManager.getInstance(this);
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, "My Service Stopped", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onDestroy");
		player.stop();
	}

	@Override
    public int onStartCommand(Intent intent, int flags, int startId) {
		Toast.makeText(this, "My Service Started", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onStart");
		
		player.start();
		
		int i=0;
		while(i<10){
			/*try {
				//Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			i++;
		}
        return START_STICKY;
    }

	public void play(){
		Toast.makeText(this, "My Service play", Toast.LENGTH_LONG).show();		
		player = MediaPlayer.create(this, R.raw.test1);
		player.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.sendResult("this is broadcaster test!");
	}
	 

	 public void sendResult(String message) {
	     Intent intent = new Intent(COPA_RESULT);
	     if(message != null)
	         intent.putExtra(MyLocalService.NAME, message);
	     broadcaster.sendBroadcast(intent);
	 }
}
