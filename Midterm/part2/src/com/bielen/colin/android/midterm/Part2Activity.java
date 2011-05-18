package com.bielen.colin.android.midterm;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;

public class Part2Activity extends Activity  implements OnClickListener{
	public static final String TAG = "MidermPart2Activity";
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
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
               
     }

    
}

