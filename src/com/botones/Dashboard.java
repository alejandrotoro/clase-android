package com.botones;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Dashboard extends Activity {
    /** Called when the activity is first created. */
	
	TextView welcome;
	
	public void goBack(View view){
		Intent intent = new Intent(Dashboard.this, BotonesActivity.class);
		startActivity(intent);
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        Bundle bun = getIntent().getExtras();
        welcome = (TextView)this.findViewById(R.id.welcome_txt);
        welcome.setText("Bienvenido "+bun.getString("EMAIL"));
    }
    
    public boolean onKeyDown(int KeyCode, KeyEvent event){
    	if(KeyCode != KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0);{
    		return true;
    	}
    }

}
