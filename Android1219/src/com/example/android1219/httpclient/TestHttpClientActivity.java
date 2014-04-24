package com.example.android1219.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import com.example.android1219.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class TestHttpClientActivity extends Activity {

	private Context context;
	private Button test_get;

	@Override
	protected void onCreate(Bundle b) {
		super.onCreate(b);
		context = this;
		this.setContentView(R.layout.test_httpclient_activity);
		this.test_get = (Button) this.findViewById(R.id.test_get);
		this.test_get.setOnClickListener(Test_Get);
	}

	private OnClickListener Test_Get = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String content = getContentFromURL("http://www.baidu.com");
			// String content = "testTimeout("http://www.baidu.com");
			Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
		}

	};

	public void post(View v) {

		String ret = this.getData();
		Toast.makeText(context, ret, Toast.LENGTH_SHORT).show();
	}

	private String getContentFromURL(String url) {
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		HttpResponse response;
		InputStream in;
		try {
			response = httpClient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				in = entity.getContent();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(in));
				StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
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

	private ProgressDialog pd;
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message mes){
			Toast.makeText(context, mes.getData().getString("mes"), Toast.LENGTH_LONG).show();
			pd.dismiss();
		}
	};

	public void AnscPost(View v) {
		pd = ProgressDialog.show(context, "数据加载中", "请稍后。。。。。。");
		new Thread() {
			@Override
			public void run() {
				String ret = getData();
				Bundle b = new Bundle();
				b.putString("mes", ret);
				Message mes = new Message();
				mes.setData(b);
				handler.sendMessage(mes);
			}
		}.start();
	};

	private String getData() {
		// 创建请求对象
		HttpPost post;
		// 创建客户端对象
		HttpClient client;
		// 创建发送请求的对象
		HttpResponse response;
		// 创建接收返回数据的对象
		HttpEntity entity;
		// 创建流对象
		InputStream is;
		UrlEncodedFormEntity urlEntity;
		{
			post = new HttpPost("http://192.168.1.101:8000/SSHProject/getCostomizeHqlData.action");
			client = new DefaultHttpClient();
			// 参数设置
			List<BasicNameValuePair> pairs = new ArrayList<BasicNameValuePair>();
			pairs.add(new BasicNameValuePair("name", "llllllllll"));
			try {
				// 用UrlEncodedFormEntity来封装List对象
				urlEntity = new UrlEncodedFormEntity(pairs);
				// 设置使用的Entity
				post.setEntity(urlEntity);

				try {
					// 客户端开始向指定的网址发送请求
					response = client.execute(post);
					// 获得请求的Entity
					if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
						entity = response.getEntity();
						is = entity.getContent();
						// 下面是读取数据的过程
						BufferedReader br = new BufferedReader(
								new InputStreamReader(is));
						String line = null;
						StringBuffer sb = new StringBuffer();
						while ((line = br.readLine()) != null) {
							sb.append(line);
						}
						System.out.println(sb.toString());
						//Toast.makeText(context, sb.toString(),
						//		Toast.LENGTH_SHORT).show();
						return sb.toString();
					}
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "error";
	}
}
