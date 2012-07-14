package com.botones;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BotonesActivity extends Activity {
    /** Called when the activity is first created. */
	
	public void aboutUs(View view){
		Intent intent = new Intent(BotonesActivity.this, AboutUs.class);
		startActivity(intent);
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}