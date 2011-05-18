package com.bielen.colin.android.midterm.part4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class Part4BroadcastReceiver extends BroadcastReceiver {

	public static final String MESSAGE_KEY = "message";
	protected static final String TAG = "Part4BroadcastReceiver";
	
	@Override
	public void onReceive(Context context, Intent intent) {
		
		String message = intent.getStringExtra("message"); 
		Log.d(TAG,"GOT THE MESSAGE!!! message = '"+message+"'");		
	
		Intent i = new Intent(context,Part4Activity.class);
	    i.putExtra(MESSAGE_KEY,message);
		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(i);
		
	
	}

}
