package com.jiyuan.pmis.soap;

import java.util.List;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.os.AsyncTask;
import android.util.Log;

public class Soap {
	private SoapObject request = null;;

	/**
	 * @param namespace
	 * @param method
	 */
	public Soap(String namespace, String method) {
		request = new SoapObject(namespace, method);
	}

	public void setPropertys(List<PropertyInfo> args) {

		for (int i = 0; i < args.size(); i++) {
			request.addProperty(args.get(i));
		}
	}

	private SoapSerializationEnvelope envelope;
	private HttpTransportSE androidHttpTransport;
	private String ret;
	private boolean finished = false;
	private String soapAction;
	private boolean hasException = false;
	public String getResponse(String url, String soapAction) throws Exception {
		envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		// Set output SOAP object
		envelope.setOutputSoapObject(request);
		
		// Create HTTP call object
		androidHttpTransport = new HttpTransportSE(url,10000);

		// Invole web service
		
		AsyncCallWS task = new AsyncCallWS();
        task.execute(); 
        while(!this.finished){
        	Thread.sleep(500);
        }
        if (hasException)
        	throw new Exception();
		Log.e("pmis",ret);
		return ret;
	}
	
	private class AsyncCallWS extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
        	finished = false;
        	hasException = false;
        	try {
				androidHttpTransport.call(soapAction, envelope);
				// Get the response
	    		SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
	    		// Assign it to fahren static variable
	    		ret = response.toString();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				hasException = true;
			} 
    		
        	finished = true;
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
        	
        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected void onProgressUpdate(Void... values) {

        }

    }

}
