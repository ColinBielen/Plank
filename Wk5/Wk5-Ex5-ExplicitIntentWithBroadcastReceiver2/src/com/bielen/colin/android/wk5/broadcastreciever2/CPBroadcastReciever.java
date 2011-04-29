package com.bielen.colin.android.wk5.broadcastreciever2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class CPBroadcastReciever extends BroadcastReceiver {
	final String tag = "ContactPicker";
	public static final int PICK_CONTACT = 1;
	public final String sValue1 = "Value1";
	public final String sValue2 = "Value2";
	public final String EXTRA_BUNDLE_ID1 = "1";
	public Bundle mExtras; 
	
	@Override
	public void onReceive(Context context, Intent intent) {
		String message = "got the broadcast";
		String message1 = " ";
		int iActivity = intent.getIntExtra(sValue1, 0);
		switch(iActivity){
		case 1:
			message = message + " from ExplicitIntent ";
			break;
		case 2:
			message = message + " from Activity 2 ";
			break;		
		}
		
		mExtras = intent.getBundleExtra(EXTRA_BUNDLE_ID1);
		if (mExtras.containsKey(sValue1))
			message1 = mExtras.getString(sValue1);
		
		message = message + " " + message1;
		
		Toast.makeText(context, message, Toast.LENGTH_LONG).show();
	   Intent intent1 = new Intent(Intent.ACTION_PICK,
                   Uri.parse("content://contacts/"));
	   intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );

	   Log.d(tag, " onReceive intent:  " + intent);    
	   context.startActivity(intent1);  		

	}

}
