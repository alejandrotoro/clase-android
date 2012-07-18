package com.botones;

import java.io.IOException;
import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BotonesActivity extends Activity {
    /** Called when the activity is first created. */
	
	String[] users = {"a@b.com", "12345"};
	EditText email;
	EditText password;
	String email_s;
	String password_s;
	
	/** Funci—n para hacer vibrar el dispositivo si hay un error,
	 * toma din‡micamente un item de los strings para mostrar el mensaje de error
    */
	
	public void validate(View view){
		Resources res = getResources();
		String message;
		email = (EditText)this.findViewById(R.id.email);
		password = (EditText)this.findViewById(R.id.password);
		email_s = email.getText().toString().trim();
		password_s = password.getText().toString().trim();
		
		if(email_s.equals("")){
			message = res.getString(R.string.email_blank);
			error(message);
		}else if(password_s.equals("")){
			message = res.getString(R.string.password_blank);
			error(message);
		}else{
			/** login(email_s); */
		    // Create a new HttpClient and Post Header
		    HttpClient httpclient = new DefaultHttpClient();
		    HttpPost httppost = new HttpPost("http://192.168.0.11:4567/api/v1/authenticate.json");
		    /** httppost.setRequestProperty("Authorization", encodedString); */
		    try {
		        // Add your data
		    	List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
		    	nameValuePairs.add(new BasicNameValuePair("user[email]", email_s));
		    	nameValuePairs.add(new BasicNameValuePair("user[pass]", password_s));
		        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

		        // Execute HTTP Post Request
		        HttpResponse response = httpclient.execute(httppost);
	    		int status = response.getStatusLine().getStatusCode();

	    		if(status == 200){
	    			HttpEntity e = response.getEntity();
	    			String data = EntityUtils.toString(e);
	    			login(data);
	    		}else {
	    			HttpEntity e = response.getEntity();
	    			String data = EntityUtils.toString(e);
					error(data);
	    		}
		        
		    } catch (ClientProtocolException e) {
				message = res.getString(R.string.connection_error);
				error(message);
		    } catch (IOException e) {
				message = res.getString(R.string.connection_error);
				error(message);
		    }
		}
	}
	
	public void login(String email){
		Bundle bun = new Bundle();
		bun.putString("EMAIL", email);
		Intent intent = new Intent(BotonesActivity.this, Dashboard.class);
		intent.putExtras(bun);
		startActivity(intent);
	}
	
	public void error(String error){
		/** De esta forma se llaman las listas del archivo string_array.xml */
		Vibrator vibrar = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		vibrar.vibrate(800);
		Toast.makeText(this, error, Toast.LENGTH_LONG).show();
	}
	
	public void register(View view){
		Intent intent = new Intent(BotonesActivity.this, Register.class);
		startActivity(intent);
	}
	
	public void forgot(View view){
		Intent intent = new Intent(BotonesActivity.this, ForgotPassword.class);
		startActivity(intent);
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}