package com.botones;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgotPassword extends Activity {

	String[] users = {"a@b.com", "12345"};
	EditText email;
	String email_s;
	
	public void goBack(View view){
		Intent intent = new Intent(ForgotPassword.this, BotonesActivity.class);
		startActivity(intent);
	}
	
	public void validate(View view){
		Resources res = getResources();
		String message;
		email = (EditText)this.findViewById(R.id.email);
		email_s = email.getText().toString().trim();
		
		if(email_s.equals("")){
			message = res.getString(R.string.email_blank);
			error(message);
		}else if(!email_s.equals(users[0])){
			message = res.getString(R.string.email_missmatch);
			error(message);
		}else {
			message = res.getString(R.string.pass);
			forgot(message, users[1]);
		}
	}
	
	public void error(String error){
		/** De esta forma se llaman las listas del archivo string_array.xml */
		Vibrator vibrar = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		vibrar.vibrate(800);
		Toast.makeText(this, error, Toast.LENGTH_LONG).show();
	}
	
	public void forgot(String message, String pass){
		/** De esta forma se llaman las listas del archivo string_array.xml */
		Vibrator vibrar = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		vibrar.vibrate(800);
		Toast.makeText(this, message+pass, Toast.LENGTH_LONG).show();
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);
    }

}
