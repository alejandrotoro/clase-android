package com.botones;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Dashboard extends Activity {
    /** Called when the activity is first created. */
	
	TextView welcome;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        Bundle bun = getIntent().getExtras();
        welcome = (TextView)this.findViewById(R.id.welcome_txt);
        welcome.setText("Bienvenido "+bun.getString("EMAIL"));
    }

}
