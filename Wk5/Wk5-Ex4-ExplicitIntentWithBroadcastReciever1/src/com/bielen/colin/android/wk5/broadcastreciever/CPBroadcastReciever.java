package com.bielen.colin.android.wk5.broadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CPBroadcastReciever extends BroadcastReceiver {
	public final String sValue1 = "Value1";
	public final String sValue2 = "Value2";
	public final String EXTRA_BUNDLE_ID1 = "1";

	@Override
	public void onReceive(Context context, Intent intent) {
		
		String message = "got the broadcast";
		// TODO Auto-generated method stub
		int iActivity = intent.getIntExtra(sValue1, 0);
		switch(iActivity){
		case 1:
			message = message + "from ExplicitIntent";
			break;
		case 2:
			message = message + "from Activity 2";
			break;		
		}
		Toast.makeText(context, message, Toast.LENGTH_LONG).show();
		

	}

}
