package com.botones;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BotonesActivity extends Activity {
    /** Called when the activity is first created. */
	EditText texto;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        texto = (EditText)this.findViewById(R.id.caja_txt);
    }
    
    public void guardar(View text){
    	Toast.makeText(this, "cualquier vaina "+texto.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}