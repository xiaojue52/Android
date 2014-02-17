package com.jiyuan.pmis.soap;

import java.io.IOException;
import java.util.List;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

public class Soap {
	private SoapObject request = null;;
	/**
	 * @param namespace
	 * @param method
	 */
	public Soap(String namespace, String method){
		request = new SoapObject(namespace, method);
	}
	public void setPropertys(List<PropertyInfo> args){

		for(int i=0;i<args.size();i++){
			request.addProperty(args.get(i));
		}
	}
	public String getResponse(String url,String soapAction) throws Exception {
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		//Set output SOAP object
		envelope.setOutputSoapObject(request);
		//Create HTTP call object
		HttpTransportSE androidHttpTransport = new HttpTransportSE(url);

			//Invole web service
			androidHttpTransport.call(soapAction, envelope);
			//Get the response
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			//Assign it to fahren static variable
			String ret = response.toString();
			System.out.println(ret);
			return ret;
	}
}
