package com.bielen.colin.android;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
// import android.provider.Contacts.People; // Deprecated class
import android.provider.ContactsContract.PhoneLookup;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class ContentPickerTester extends Activity {
  final String tag = "ContactPicker";
  public static final int PICK_CONTACT = 1;
	
  @Override
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    setContentView(R.layout.contentpickertester);
	
    Button button = (Button)findViewById(R.id.pick_contact_button);
	      
    button.setOnClickListener(new OnClickListener() {
     public void onClick(View _view) {
        Intent intent = new Intent(Intent.ACTION_PICK,
                                   Uri.parse("content://contacts/"));
        
        Log.d(tag,getLocalClassName() + " onClick intent:  " + intent);    
        startActivityForResult(intent, PICK_CONTACT);  
      } 
    });
  }
  
  @Override 
  public void onActivityResult(int reqCode, int resCode, Intent data) {
    super.onActivityResult(reqCode, resCode, data);
    Log.d(tag,getLocalClassName() + " reqCode:  " + reqCode + " resCode: " + resCode);
    Log.d(tag,getLocalClassName() + " data:  " + data);
      
    switch(reqCode) {
      case (PICK_CONTACT) : {
        if (resCode == Activity.RESULT_OK) {
          Uri contactData = data.getData();
          Log.d(tag,getLocalClassName() + " contactData:  " + contactData);
          Cursor c = managedQuery(contactData, null, null, null, null);
          c.moveToFirst();
          // People has been depreciated, use PhoneLookup instead
//          String name = c.getString(c.getColumnIndexOrThrow(People.NAME));
          String name = c.getString(c.getColumnIndexOrThrow(PhoneLookup.DISPLAY_NAME));
          Log.d(tag,getLocalClassName() + " name:  " + name);
          TextView tv = (TextView)findViewById(R.id.selected_contact_textview);
          tv.setText(name);
        }
        break;
      }
    }
  }
}
