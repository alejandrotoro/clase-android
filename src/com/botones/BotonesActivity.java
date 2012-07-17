package com.botones;

import java.io.ObjectOutputStream.PutField;

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
		}else if(!email_s.equals(users[0]) || !password_s.equals(users[1])){
			message = res.getString(R.string.incorrects);
			error(message);
		}else{
			login(email_s);
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
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}