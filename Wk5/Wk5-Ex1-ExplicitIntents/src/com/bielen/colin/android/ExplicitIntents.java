package com.bielen.colin.android;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class ExplicitIntents extends Activity {
    /** Called when the activity is first created. */
	final String TAG = "ExplicitIntent";

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d(TAG, getLocalClassName() + " intent: " + getIntent());
        Bundle extras = getIntent().getExtras();
        if (extras== null){
        	return;
        }
        String value1 = extras.getString("Value1");
	    String value2 = extras.getString("Value2");
	    Log.d(TAG, getLocalClassName() + " extras: " + value1 + " " + value2);
	       	    
	    if (value1 != null && value2 !=null){
	    	EditText text1= (EditText) findViewById(R.id.EditText01);
	 	    EditText text2 = (EditText) findViewById(R.id.EditText02);
	 	    text1.setText(value1);
	 	    text2.setText(value2);
	    }
    }
    public void onClick(View view){
	    Resources myResources = getResources();
	    String text1 = myResources.getString(R.string.textB1);
	    String text2 = myResources.getString(R.string.textB2);
		Intent i = new Intent(this, com.bielen.colin.android.ActivityTwo.class);
		i.putExtra("Value1", text1);
		i.putExtra("Value2", text2);
        Log.d(TAG, getLocalClassName() + " onClick intent: " + i);

		startActivity(i);
	}

}
