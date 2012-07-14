package com.botones;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

public class AboutUs extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);
    }
    
    /* 
    @Override
    public void onCreateOptionsMenu(Menu menu){
    	getMenuInflater().inflate(R.menu.about_us, menu);
    	return true;
    }
    */
}