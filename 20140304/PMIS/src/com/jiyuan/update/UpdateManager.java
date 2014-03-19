package com.jiyuan.update;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.ksoap2.serialization.PropertyInfo;
import com.google.gson.Gson;
import com.jiyuan.pmis.constant.Constant;
import com.jiyuan.pmis.soap.Soap;
import com.jiyuan.pmis.structure.Version;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class UpdateManager {

	private String curVersion;
	private String newVersion;
	private int curVersionCode;
	private int newVersionCode;
	private String updateInfo;
	private UpdateCallback callback;
	private Context ctx;
    
	private int progress;  
	private Boolean hasNewVersion;
	private Boolean canceled;

	//��Ÿ���APK�ļ���·��
	public static final String UPDATE_DOWNURL = "http://115.29.16.108:8080/pmis/download/PMIS.apk";
	//��Ÿ���APK�ļ���Ӧ�İ汾˵��·��
	//public static final String UPDATE_CHECKURL = "http://www.www.baidu.com/test_update/update_version.txt";
	public static final String UPDATE_APKNAME = "pmis.apk";
	//public static final String UPDATE_VERJSON = "ver.txt";
	public static final String UPDATE_SAVENAME = "pmis.apk";
	private static final int UPDATE_CHECKCOMPLETED = 1;
	 private static final int UPDATE_DOWNLOADING = 2; 
	 private static final int UPDATE_DOWNLOAD_ERROR = 3; 
	 private static final int UPDATE_DOWNLOAD_COMPLETED = 4; 
	 private static final int UPDATE_DOWNLOAD_CANCELED = 5;

	 //�ӷ�����������apk����ļ���
	 private String savefolder = "/mnt/sdcard/pmis/";
	 //private String savefolder = "/sdcard/";
		//public static final String SAVE_FOLDER =Storage. // "/mnt/innerDisk";
	public UpdateManager(Context context, UpdateCallback updateCallback) {
		ctx = context;
		callback = updateCallback;
		//savefolder = context.getFilesDir();
		canceled = false;
		getCurVersion();
	}
	
	public String getNewVersionName()
	{
		return newVersion;
	}
	
	public String getUpdateInfo()
	{
		return updateInfo;
	}

	private void getCurVersion() {
		try {
			PackageInfo pInfo = ctx.getPackageManager().getPackageInfo(
					ctx.getPackageName(), 0);
			curVersion = pInfo.versionName;
			curVersionCode = pInfo.versionCode;
		} catch (NameNotFoundException e) {
			Log.e("update", e.getMessage());
			curVersion = "1.1.1000";
			curVersionCode = 111000;
		}

	}

	public void checkUpdate() {		
		hasNewVersion = false;
		new Thread(){
			// ***************************************************************
			/**
			 * @by wainiwann add
			 * 
			 */
			@Override
			public void run() {
				/*Log.i("@@@@@", ">>>>>>>>>>>>>>>>>>>>>>>>>>>getServerVerCode() ");
				try {

					String verjson = NetHelper.httpStringGet(UPDATE_CHECKURL);
					Log.i("@@@@", verjson
							+ "**************************************************");
					JSONArray array = new JSONArray(verjson);

					if (array.length() > 0) {
						JSONObject obj = array.getJSONObject(0);
						try {
							newVersionCode = Integer.parseInt(obj.getString("verCode"));
							newVersion = obj.getString("verName");
							updateInfo = "";
							Log.i("newVerCode", newVersionCode
									+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
							Log.i("newVerName", newVersion
									+ "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
							if (newVersionCode > curVersionCode) {
								hasNewVersion = true;
							}
						} catch (Exception e) {
							newVersionCode = -1;
							newVersion = "";
							updateInfo = "";
							
						}
					}
				} catch (Exception e) {
					Log.e("update", e.getMessage());
				}*/
				Looper.prepare();
				Soap soap = new Soap(Constant.login_namespace, "getVersion");
				List<PropertyInfo> args = new ArrayList<PropertyInfo>();
				PropertyInfo arg0 = new PropertyInfo();
				arg0.setName("pingtai");
				arg0.setValue("android");
				arg0.setType(String.class);

				args.add(arg0);
				soap.setPropertys(args);
				Version version = null;
				try {
					String ret = soap.getResponse(Constant.login_url, Constant.login_url
							+ "/getVersion");
					version = new Gson().fromJson(ret, Version.class);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					newVersionCode = -1;
					newVersion = "";
					updateInfo = "";
					e.printStackTrace();
				}
				if (version!=null){
					if (version.bbh!=null&&!version.bbh.equals(curVersion)){
						newVersion = version.bbh;
						newVersionCode = -1;
						updateInfo = "";
						hasNewVersion = true;
						versionInfo = new Version();
						versionInfo.bbh = newVersion;
						versionInfo.wjdx = version.wjdx;
					}
				}
				updateHandler.sendEmptyMessage(UPDATE_CHECKCOMPLETED);
			};
			// ***************************************************************
		}.start();

	}

	public void update() {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		
		intent.setDataAndType(
				Uri.fromFile(new File(savefolder, UPDATE_SAVENAME)),
				"application/vnd.android.package-archive");
		ctx.startActivity(intent);
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	public void downloadPackage() 
	{
		
		
		new Thread() {			
			 @Override  
		        public void run() {  
		            try {  
		                URL url = new URL(UPDATE_DOWNURL);  
		              
		                HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
		                conn.connect();  
		                int length = conn.getContentLength();  
		                InputStream is = conn.getInputStream();  
		                  
		               
		                File ApkFile = new File(savefolder,UPDATE_SAVENAME);
		                File folder = new File(savefolder);
		                if (!folder.exists())
		                	folder.mkdirs();
		                
		                if(ApkFile.exists())
		                {
		                	ApkFile.delete();
		                }
		                
		                FileOutputStream fos = new FileOutputStream(ApkFile);  
		                 
		                int count = 0;  
		                byte buf[] = new byte[512];  
		                  
		                do{  
		                	
		                    int numread = is.read(buf);  
		                    count += numread;  
		                    progress =(int)(((float)count / length) * 100);  
		                   
		                    updateHandler.sendMessage(updateHandler.obtainMessage(UPDATE_DOWNLOADING)); 
		                    if(numread <= 0){      
		                        
		                    	updateHandler.sendEmptyMessage(UPDATE_DOWNLOAD_COMPLETED);
		                        break;  
		                    }  
		                    fos.write(buf,0,numread);  
		                }while(!canceled);  
		                if(canceled)
		                {
		                	updateHandler.sendEmptyMessage(UPDATE_DOWNLOAD_CANCELED);
		                }
		                fos.close();  
		                is.close();  
		            } catch (MalformedURLException e) {  
		                e.printStackTrace(); 
		                
		                updateHandler.sendMessage(updateHandler.obtainMessage(UPDATE_DOWNLOAD_ERROR,e.getMessage()));
		            } catch(IOException e){  
		                e.printStackTrace();  
		                
		                updateHandler.sendMessage(updateHandler.obtainMessage(UPDATE_DOWNLOAD_ERROR,e.getMessage()));
		            }  
		              
		        } 
		}.start();
	}

	public void cancelDownload()
	{
		canceled = true;
	}
	
	Handler updateHandler = new Handler() 
	{
		@Override
		public void handleMessage(Message msg) {

			switch (msg.what) {
			case UPDATE_CHECKCOMPLETED:
				
				callback.checkUpdateCompleted(hasNewVersion, versionInfo);
				break;
			case UPDATE_DOWNLOADING:
				
				callback.downloadProgressChanged(progress);
				break;
			case UPDATE_DOWNLOAD_ERROR:
				
				callback.downloadCompleted(false, msg.obj.toString());
				break;
			case UPDATE_DOWNLOAD_COMPLETED:
				
				callback.downloadCompleted(true, "");
				break;
			case UPDATE_DOWNLOAD_CANCELED:
				
				callback.downloadCanceled();
			default:
				break;
			}
		}
	};

	private Version versionInfo;
	public interface UpdateCallback {
		public void checkUpdateCompleted(Boolean hasUpdate,
				Version version);
		public void downloadProgressChanged(int progress);
		public void downloadCanceled();
		public void downloadCompleted(Boolean sucess, CharSequence errorMsg);
	}

}
