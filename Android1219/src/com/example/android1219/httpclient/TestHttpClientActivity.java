package com.example.android1219.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import com.example.android1219.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class TestHttpClientActivity extends Activity {

	private Context context;
	private Button test_get;
	@Override
	protected void onCreate(Bundle b){
		super.onCreate(b);
		context = this;
		this.setContentView(R.layout.test_httpclient_activity);
		this.test_get = (Button)this.findViewById(R.id.test_get);
		this.test_get.setOnClickListener(Test_Get);
	}
	private OnClickListener Test_Get = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String content =  getContentFromURL("http://www.baidu.com");
			Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
		}
		
	};
	private String getContentFromURL(String url){
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		HttpResponse response;
		try {
			response = httpClient.execute(httpGet);
			Toast.makeText(context, response.getStatusLine().toString(), Toast.LENGTH_LONG).show();
			HttpEntity entity = response.getEntity();
			if (entity!=null){
				InputStream in = entity.getContent();
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				StringBuilder sb = new StringBuilder();
				String line = null;
				while((line=reader.readLine())!=null){
					sb.append(line+"\n");
				}
				return sb.toString();
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "-1";
	}
	private interface Test{
		public void run();
	}
	private Test test = new Test(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
		}
		
	};
}
