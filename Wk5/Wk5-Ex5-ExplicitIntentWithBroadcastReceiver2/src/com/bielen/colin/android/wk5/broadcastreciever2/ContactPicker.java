package com.bielen.colin.android.wk5.broadcastreciever2;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
// import android.provider.Contacts.People; // Deprecated
import android.provider.ContactsContract.PhoneLookup;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class ContactPicker extends Activity {
  final String tag = "ContactPicker";
  @Override
 
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    setContentView(R.layout.main);
    
    Intent intent = getIntent();
    Log.d(tag,getLocalClassName() + " intent: " + intent);
    String dataPath = intent.getData().toString();
    Log.d(tag,getLocalClassName() + " data: " + dataPath);
    String sAction = intent.getAction();
    Log.d(tag,getLocalClassName() + " action: " + sAction);
    
    final Uri data = Uri.parse(dataPath + "people/");
    final Cursor c = managedQuery(data, null, null, null, null);
    
 // People has been depreciated, use PhoneLookup instead
//    String[] from = new String[] {People.NAME};
    String[] from = new String[] {PhoneLookup.DISPLAY_NAME};
    int[]  to = new int[] { R.id.itemTextView };
        
    SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                                                          R.layout.listitemlayout,
                                                          c,
                                                          from,
                                                          to);
    ListView lv = (ListView)findViewById(R.id.contactListView);
    lv.setAdapter(adapter);
    lv.setOnItemClickListener(new OnItemClickListener() {
      public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
        // Move the cursor to the selected item
        c.moveToPosition(pos);
        // Extract the row id.
        int rowId = c.getInt(c.getColumnIndexOrThrow("_id"));
        // Construct the result URI.
        Uri outURI = Uri.parse(data.toString() + rowId);
        Intent outData = new Intent();
        outData.setData(outURI);
        Log.d(tag,getLocalClassName() + " onItemClick: outData: " +  outData);
        Log.d(tag,getLocalClassName() + " onItemClick: Activity.RESULT_OK " +  Activity.RESULT_OK);
        setResult(Activity.RESULT_OK, outData);
        finish();
      }
    });
  }
}
