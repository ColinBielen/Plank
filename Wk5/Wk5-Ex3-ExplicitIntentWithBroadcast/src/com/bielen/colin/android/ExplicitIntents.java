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
	public static String EXAMPLE_BROADCAST = "com.fsavage.classexample.EXAMPLE_BROADCAST" ;

	public final String sValue1 = "Value1";
	public final String sValue2 = "Value2";
	public final String EXTRA_BUNDLE_ID1 = "1";
	public final String EXTRA_INT_ID2 = "2";
	public final String EXTRA_INT_ID3 = "3";

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d(TAG, getLocalClassName() + " intent: " + getIntent());
        Bundle extras = getIntent().getExtras();
        if (extras== null){
        	return;
        }
//	    String value1 = extras.getString("Value1");
//	    String value2 = extras.getString("Value2");

	    String value1 = extras.getString(sValue1);
	    String value2 = extras.getString(sValue2);
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
		Intent i = new Intent(this, ActivityTwo.class);
		i.putExtra(sValue1, text1);
		i.putExtra(sValue2, text2);
        Log.d(TAG, getLocalClassName() + " onClick intent: " + i);

		startActivity(i);
	}

    public void onClick1(View view){
     	
    	int iExplicitIntents = 1;
	    Resources myResources = getResources();
	    String text1 = myResources.getString(R.string.textA1);
	    String text2 = myResources.getString(R.string.textA2);
		Intent iBroadcast = new Intent(EXAMPLE_BROADCAST);
		Bundle bundle = new Bundle();
		bundle.putString(sValue1, text1);
		bundle.putString(sValue2, text2);

        sendBroadcast(iBroadcast
        	.putExtra(EXTRA_BUNDLE_ID1, bundle)
        	.putExtra(sValue1, iExplicitIntents));
        Log.d(TAG, getLocalClassName() + " onClick1 Explicit Intent broadcast: " + iBroadcast + " " + text1);
       
	}
}
