package com.example.android1219.service;

import com.example.android1219.R;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
//http://stackoverflow.com/questions/4300291/example-communication-between-activity-and-service-using-messaging
public class ThirdActivity extends Activity {
	private Context context;
	Button btnStart, btnStop, btnBind, btnUnbind, btnUpby1, btnUpby10,btnBundle;
    TextView textStatus;
    private BroadcastReceiver receiver;
    //Messenger mService = null;
    boolean mIsBound;
	public ThirdActivity() {
		// TODO Auto-generated constructor stub
		context = this;
	}
	@Override
	public void onCreate(Bundle b){
		super.onCreate(b);
		this.restoreMe(b);
		this.setContentView(R.layout.third_activity);
		Button btn = (Button)this.findViewById(R.id.button3);
		btnStart = (Button)this.findViewById(R.id.startService);
		btnStop = (Button)this.findViewById(R.id.stopService);
		this.btnStart.setOnClickListener(TestStartService);
		this.btnStop.setOnClickListener(StopStartService);
		
		btnBind = (Button)this.findViewById(R.id.bindService);
		this.btnUnbind = (Button)this.findViewById(R.id.unbBindService);
		this.btnBind.setOnClickListener(this.BindService);
		this.btnUnbind.setOnClickListener(this.UnbindService);
		this.textStatus = (TextView)this.findViewById(R.id.textStatus);
		this.btnBundle = (Button)this.findViewById(R.id.testBundle);
		this.btnBundle.setOnClickListener(TestBundle);
		btn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(context,"this is third activity", Toast.LENGTH_LONG).show();
				Intent it = new Intent();
				it.putExtra("ret", "1");
				setResult(RESULT_OK,it);
				finish();
			}
			
		});
		
		
		receiver = new BroadcastReceiver() {
	        @Override
	        public void onReceive(Context context, Intent intent) {
	            String s = intent.getStringExtra(MyLocalService.NAME);
	            // do something here.
	            textStatus.setText(s);
	        }
	    };
	}
	private OnClickListener TestStartService = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			startService(new Intent(context,MyLocalService.class));
		}
		
	};
	private OnClickListener StopStartService = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			stopService(new Intent(context,MyLocalService.class));
		}
		
	};
	private OnClickListener BindService = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			doBindService();
		}
		
	};
	private OnClickListener UnbindService = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			doUnbindService();
		}
		
	};
	
	private Button.OnClickListener TestBundle = new Button.OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			textStatus.setText("1");
		}
		
	};
	@Override
	protected void onSaveInstanceState(Bundle outState){
		super.onSaveInstanceState(outState);
		outState.putString("textStatus", textStatus.getText().toString());
	}
	private void restoreMe(Bundle state){
		if (state!=null){
			textStatus.setText(state.getString("textStatus"));
		}
	}
	private MyLocalService mService;
	private ServiceConnection mConn = new ServiceConnection(){

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			mService = ((MyLocalService.LocalBinder)service).getService();
			Toast.makeText(context, "建立连接", Toast.LENGTH_LONG).show();
			mService.play();
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			mService = null;
			Toast.makeText(context, "失去连接", Toast.LENGTH_LONG).show();
		}
		
	};
	private void doBindService(){
		bindService(new Intent(this,MyLocalService.class),mConn,Context.BIND_AUTO_CREATE);
		mIsBound = true;
	}
	private void doUnbindService(){
		if (mIsBound){
			unbindService(mConn);
	        mIsBound = false;
		}
	}
	@Override
	protected void onDestroy() {
	    super.onDestroy();
	    doUnbindService();
	}
	@Override
	protected void onStart() {
	    super.onStart();
	    LocalBroadcastManager.getInstance(this).registerReceiver(receiver, new IntentFilter(MyLocalService.COPA_RESULT));
	}

	@Override
	protected void onStop() {
	    LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
	    super.onStop();
	}

}
