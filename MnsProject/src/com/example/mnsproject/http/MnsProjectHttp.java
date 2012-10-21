package com.example.mnsproject.http;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import net.maxters.android.ntlm.NTLM;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

import com.example.mnsproject.dtos.MnsUserDto;
import com.example.mnsproject.exceptions.MnsLoginException;

/**
 * 
 * @author angelcereijo
 *
 */
public class MnsProjectHttp {
	
	private static final String TAG =  MnsProjectHttp.class.toString();
	
	private static final String MNS_DOMAIN = "medianet2k";
	private static final String MNS_PRINCIPAL_URL = "http://dedicaciones.medianet.es/mns.timetracking";
	private static final String MNS_COOKIE_SESSION = "ASP.NET_SessionId";

	/**
	 * 
	 * @param user
	 * @throws URISyntaxException
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws MnsLoginException
	 */
	public void login(MnsUserDto user) throws URISyntaxException, ClientProtocolException, IOException, MnsLoginException{
		
		URL url = new URL(MNS_PRINCIPAL_URL);
    	DefaultHttpClient client = new DefaultHttpClient();
    	NTLM.setNTLM(client, user.getUser(), user.getPassword(), MNS_DOMAIN,null,-1);
    	HttpGet get = new HttpGet(url.toURI());
 
    	HttpResponse resp = client.execute(get);
    	Log.i(TAG,"StatusCode: "+resp.getStatusLine().getStatusCode() +
    			" StatusLine: "+resp.getStatusLine().getReasonPhrase());
    	List<Cookie> cookies = client.getCookieStore().getCookies();
    	for(Cookie c : cookies){
    		Log.i(TAG,"Cookie - Name: "+c.getName()+" Value: "+c.getValue());
    		if(MNS_COOKIE_SESSION.equals(c.getName())){
    			user.setSessionId(c.getValue());
    		}
    	}
    	if(user.getSessionId() == null ){
    		throw new MnsLoginException();
    	}
	}
	
	
	
}
