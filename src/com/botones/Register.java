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

public class Register extends Activity {

	EditText email;
	EditText password;
	EditText v_password;
	String email_s;
	String password_s;
	String v_password_s;
	
	public void goBack(View view){
		Intent intent = new Intent(Register.this, BotonesActivity.class);
		startActivity(intent);
	}
	
	public void validate(View view){
		Resources res = getResources();
		String message;
		email = (EditText)this.findViewById(R.id.email);
		password = (EditText)this.findViewById(R.id.password);
		v_password = (EditText)this.findViewById(R.id.verify_password);
		email_s = email.getText().toString().trim();
		password_s = password.getText().toString().trim();
		v_password_s = v_password.getText().toString().trim();
		
		if(email_s.equals("")){
			message = res.getString(R.string.email_blank);
			error(message);
		}else if(password_s.equals("")){
			message = res.getString(R.string.password_blank);
			error(message);
		}else if(!password_s.equals(v_password_s)){
			message = res.getString(R.string.pass_missmatch);
			error(message);
		}else {
			register(email_s);
		}
	}
	
	public void register(String email){
		Bundle bun = new Bundle();
		bun.putString("EMAIL", email);
		Intent intent = new Intent(Register.this, Dashboard.class);
		intent.putExtras(bun);
		startActivity(intent);
	}
	
	public void error(String error){
		/** De esta forma se llaman las listas del archivo string_array.xml */
		Vibrator vibrar = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		vibrar.vibrate(800);
		Toast.makeText(this, error, Toast.LENGTH_LONG).show();
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
    }

}
