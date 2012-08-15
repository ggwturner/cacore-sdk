        
package test.gov.nih.nci.cacoresdk.domain.other.differentpackage.associations;

import gov.nih.nci.cacoresdk.domain.other.differentpackage.associations.IceCream;

import javax.ws.rs.core.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.FileWriter;
import java.io.File;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.entity.FileEntity;
import org.apache.cxf.jaxrs.client.WebClient;

import org.apache.cxf.common.util.Base64Utility;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Iterator;

import test.gov.nih.nci.cacoresdk.SDKRESTfulTestBase;
import gov.nih.nci.system.applicationservice.ApplicationException;

public class IceCreamResourceTest extends SDKRESTfulTestBase
{
	public static String getTestCaseName()
	{
		return "IceCream  RESTful Resource Test Case";
	}

	
	/**
	 * Uses Nested Search Criteria for search
	 * Verifies that the results are returned 
	 * Verifies size of the result set
	 * Verifies that none of the attributes are null
	 * 
	 * @throws Exception
	 */
	public void testGet() throws Exception
	{
		
	  try {
 
 		IceCream searchObject = new IceCream();
 		Collection results = getApplicationService().search("gov.nih.nci.cacoresdk.domain.other.differentpackage.associations.IceCream",searchObject );
		String id = "";
		
		if(results != null && results.size() > 0)
		{
			IceCream obj = (IceCream) ((List)results).get(0);
		
			         id = obj.getId().getExtension();
			
		}
		else
			return;

		if(id.equals(""))
			return;
			
		String url = baseURL + "/rest/IceCream/"+id;

 
		WebClient client = WebClient.create(url);
		client.type("application/xml").accept("application/xml");		
		Response response = client.get();
 
		if (response.getStatus() == Status.NOT_ACCEPTABLE.getStatusCode()) {
			InputStream is = (InputStream) response.getEntity();
			org.jdom.input.SAXBuilder builder = new org.jdom.input.SAXBuilder(
					false);
			org.jdom.Document jDoc = builder.build(is);
			assertEquals(jDoc.getRootElement().getName(), "response");
		}
		else if (response.getStatus() == Status.NOT_FOUND.getStatusCode()) {
			InputStream is = (InputStream) response.getEntity();
			org.jdom.input.SAXBuilder builder = new org.jdom.input.SAXBuilder(
					false);
			org.jdom.Document jDoc = builder.build(is);
			assertEquals(jDoc.getRootElement().getName(), "response");
		}
 		else if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
			   + response.getStatus());
		}
 
 		File myFile = new File("IceCream"+"XML.xml");	
 			
		System.out.println("writing data to file "+myFile.getAbsolutePath());
		FileWriter myWriter = new FileWriter(myFile);

		BufferedReader br = new BufferedReader(
                         new InputStreamReader(((InputStream)response.getEntity())));
 
		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			myWriter.write(output);
			System.out.println(output);
		}
 
		myWriter.flush();
 		myWriter.close();
	  } catch (Exception e) {
		e.printStackTrace();
		throw e;
	  }
		
	}

	public void testSearch() throws Exception
	{
		
	  try {
 
		
			
		String url = baseURL + "/rest/IceCream/search;id=*";
		WebClient client = WebClient.create(url);
		client.type("application/xml").accept("application/xml");		
		Response response = client.get();

		if (response.getStatus() == Status.NOT_ACCEPTABLE.getStatusCode()) {
			InputStream is = (InputStream) response.getEntity();
			org.jdom.input.SAXBuilder builder = new org.jdom.input.SAXBuilder(
					false);
			org.jdom.Document jDoc = builder.build(is);
			assertEquals(jDoc.getRootElement().getName(), "response");
		}
		else if (response.getStatus() == Status.NOT_FOUND.getStatusCode()) {
			InputStream is = (InputStream) response.getEntity();
			org.jdom.input.SAXBuilder builder = new org.jdom.input.SAXBuilder(
					false);
			org.jdom.Document jDoc = builder.build(is);
			assertEquals(jDoc.getRootElement().getName(), "response");
		}
 		else if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
			   + response.getStatus());
		}
 
 		File myFile = new File("IceCream_Search"+"XML.xml");						
		System.out.println("writing data to file "+myFile.getAbsolutePath());
		FileWriter myWriter = new FileWriter(myFile);

		BufferedReader br = new BufferedReader(
                         new InputStreamReader(((InputStream)response.getEntity())));
 
		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			myWriter.write(output);
			System.out.println(output);
		}
 
		myWriter.flush();
 		myWriter.close();
 		
	  } catch (Exception e) {
		e.printStackTrace();
	  }
		
	}	



//***************************************************


	public void testIceCream1()
	{
		try
		{
	
		String url = baseURL + "/rest/IceCream/search;id=*/utensilCollection";
 
		WebClient client = WebClient.create(url);
		client.type("application/xml").accept("application/xml");		
		Response response = client.get();
 
		if (response.getStatus() == Status.NOT_ACCEPTABLE.getStatusCode()) {
			InputStream is = (InputStream) response.getEntity();
			org.jdom.input.SAXBuilder builder = new org.jdom.input.SAXBuilder(
					false);
			org.jdom.Document jDoc = builder.build(is);
			assertEquals(jDoc.getRootElement().getName(), "response");
		}
		else if (response.getStatus() == Status.NOT_FOUND.getStatusCode()) {
			InputStream is = (InputStream) response.getEntity();
			org.jdom.input.SAXBuilder builder = new org.jdom.input.SAXBuilder(
					false);
			org.jdom.Document jDoc = builder.build(is);
			assertEquals(jDoc.getRootElement().getName(), "response");
		}
 		else if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
			   + response.getStatus());
		}
 
 		File myFile = new File("IceCream_Search"+"XML.xml");						
		System.out.println("writing data to file "+myFile.getAbsolutePath());
		FileWriter myWriter = new FileWriter(myFile);

		BufferedReader br = new BufferedReader(
                         new InputStreamReader(((InputStream)response.getEntity())));
 
		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			myWriter.write(output);
			System.out.println(output);
		}
 
		myWriter.flush();
 		myWriter.close();
 		
 		
		}
		catch(Exception e)
		{
			  e.printStackTrace();
			  ResponseBuilder builder = Response.status(Status.INTERNAL_SERVER_ERROR);
			  builder.type("application/xml");
			  StringBuffer buffer = new StringBuffer();
			  buffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			  buffer.append("<response>");
			  buffer.append("<type>ERROR</type>");
			  buffer.append("<code>INTERNAL_ERROR_4</code>");
			  buffer.append("<message>Failed to Query due to: "+e.getMessage()+"</message>");
			  buffer.append("</response>");
			  builder.entity(buffer.toString());
			  throw new WebApplicationException(builder.build());
		}

	}

	

					
			
	public void testgetUtensilCollection()
	{
		try
		{
		IceCream searchObject = new IceCream();
 		Collection results4 = getApplicationService().search("gov.nih.nci.cacoresdk.domain.other.differentpackage.associations.IceCream",searchObject );
		String id = "";
		
		if(results4 != null && results4.size() > 0)
		{
			IceCream obj = (IceCream) ((List)results4).get(0);
		
			         id = obj.getId().getExtension();
			
		}
		else
			return;

		if(id.equals(""))
			return;
			
			String url = baseURL + "/rest/IceCream/"+id+"/utensilCollection";

			WebClient client = WebClient.create(url);
			client.type("application/xml").accept("application/xml");		
			Response response = client.get();

			if (response.getStatus() == Status.NOT_ACCEPTABLE.getStatusCode()) {
				InputStream is = (InputStream) response.getEntity();
				org.jdom.input.SAXBuilder builder = new org.jdom.input.SAXBuilder(
						false);
				org.jdom.Document jDoc = builder.build(is);
				assertEquals(jDoc.getRootElement().getName(), "response");
			}
			else if (response.getStatus() == Status.NOT_FOUND.getStatusCode()) {
				InputStream is = (InputStream) response.getEntity();
				org.jdom.input.SAXBuilder builder = new org.jdom.input.SAXBuilder(
						false);
				org.jdom.Document jDoc = builder.build(is);
				assertEquals(jDoc.getRootElement().getName(), "response");
			}
			else if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				   + response.getStatus());
			}

			File myFile = new File("IceCream_Search"+"XML.xml");						
			System.out.println("writing data to file "+myFile.getAbsolutePath());
			FileWriter myWriter = new FileWriter(myFile);

			BufferedReader br = new BufferedReader(
				 new InputStreamReader(((InputStream)response.getEntity())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				myWriter.write(output);
				System.out.println(output);
			}

			myWriter.flush();
			myWriter.close();
		}
		catch(Exception e)
		{
			  e.printStackTrace();
			  ResponseBuilder builder = Response.status(Status.INTERNAL_SERVER_ERROR);
			  builder.type("application/xml");
			  StringBuffer buffer = new StringBuffer();
			  buffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			  buffer.append("<response>");
			  buffer.append("<type>ERROR</type>");
			  buffer.append("<code>INTERNAL_ERROR_4</code>");
			  buffer.append("<message>Failed to Query due to: "+e.getMessage()+"</message>");
			  buffer.append("</response>");
			  builder.entity(buffer.toString());
			  throw new WebApplicationException(builder.build());
		}
			
	}
	

	


//********************************************************End

}