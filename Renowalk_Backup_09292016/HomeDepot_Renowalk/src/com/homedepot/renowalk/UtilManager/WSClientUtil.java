package com.homedepot.renowalk.UtilManager;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.homedepot.renowalk.TestDriver;

@SuppressWarnings("deprecation")
public class WSClientUtil extends TestDriver{
	
	@SuppressWarnings({})
	public static void fnWebServicePost(StringEntity inputRequest, String sRespTagName) {

		@SuppressWarnings("resource")
		DefaultHttpClient httpClient = new DefaultHttpClient();
		try {
			
			
			HttpPost postRequest = new HttpPost(sSoapActionUrl);
			
			postRequest.addHeader("Authorization", mEnvSheetData.get(iMasterRowId).get("Authorization"));
			//postRequest.addHeader("SOAPAction", mEnvSheetData.get(iMasterRowId).get("SOAPAction"));
			postRequest.addHeader("SOAPAction",sSoapActionUrl);
			postRequest.addHeader("Accept", mEnvSheetData.get(iMasterRowId).get("Accept"));
			postRequest.addHeader("Content-Type", mEnvSheetData.get(iMasterRowId).get("Content-Type"));
			
			inputRequest.setContentType(mEnvSheetData.get(iMasterRowId).get("Content-Type"));
			postRequest.setEntity(inputRequest);
	 
			HttpResponse response = httpClient.execute(postRequest);
	        System.out.println( response.getStatusLine().getStatusCode());
	        System.out.println( response.getEntity().getContent());

	        try {
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(response.getEntity().getContent());

				doc.getDocumentElement().normalize();
    
				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				String sStatus = doc.getElementsByTagName(sRespTagName).item(0).getTextContent();
				log.info("WebService status is : "+sStatus);
				System.out.println(sStatus);
			
			} catch (ParserConfigurationException e) {
				log.error("WebService post call failed",e);
				e.printStackTrace();
			} catch (SAXException e) {
				log.error("WebService post call failed",e);
				e.printStackTrace();
			}
	 
		  }  catch (IOException e) {
	 
			  log.error("WebService post call failed",e);
	 
		  }
		finally
		{
			httpClient.getConnectionManager().shutdown();
		}

	}
	
	public static StringEntity fnGetInputXMLRequest(String sWSOperation) throws UnsupportedEncodingException
	{
		String sInputXML="";
		StringEntity sEInputRequest = null;	
		
			try {
				if(sWSOperation.equalsIgnoreCase("Properties"))
				{
					sSoapActionUrl = mEnvSheetData.get(iMasterRowId).get("SOAPAction")+"/update/addOrder";	
					sInputXML = "<addProperty>" +
								"<property>" +mTestPhaseData.get(iTC_ID).get("Property_Id")+ "</property>" +
								"</addProperty>";
				}
								
				if(!sInputXML.equalsIgnoreCase(""))
				{
					sEInputRequest = new StringEntity(sInputXML);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error("fnGetInputXMLRequest failed for "+sWSOperation,e);
			}
			///////////////////////////////////////////////////////////////////////////////////////////////////
		
		///////////////////////////////////////////////////////////////////////////////////////////////////
		
		return (StringEntity) sEInputRequest;
		
	}
	
}
