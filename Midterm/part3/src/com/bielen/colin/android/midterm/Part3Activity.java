package com.bielen.colin.android.midterm;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Part3Activity extends Activity  implements OnClickListener{
	public static final String TAG = "MidermPart3Activity";
	
	public static String EXAMPLE_BROADCAST = "com.fsavage.classexample.EXAMPLE_BROADCAST1" ;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate:  Loading content view...");
        setContentView(R.layout.main);        
        Button blueButton = (Button) findViewById(R.id.bluebutton);
        // setOnClickListener onto button        
        Log.d(TAG, "onCreate: Setting button context listener.");
        blueButton.setOnClickListener((OnClickListener) this);
        Log.d(TAG, "onCreate:  Listener Set");

    } //end onCreate
    
    public void onClick(View v) {
        EditText et = (EditText) this.findViewById(R.id.mainTextInput);
        String message = et.getText().toString().trim();        
        Intent i = new Intent(EXAMPLE_BROADCAST);
        Log.d(TAG,"Sending Broadcast to "+EXAMPLE_BROADCAST);
        sendBroadcast(i.putExtra("message",message));
      
        
     }

    

}
