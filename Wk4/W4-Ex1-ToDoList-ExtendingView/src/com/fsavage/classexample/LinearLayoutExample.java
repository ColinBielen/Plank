package com.fsavage.classexample;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class LinearLayoutExample extends Activity {
	private static final String TAG = " LayoutSelector ";    

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Inflate the desired view
      setContentView(R.layout.linear);

        Log.d(TAG, "onCreate:  Now we will create get references to our UI widgets");
        
        // Get references to UI widgets
        ListView myListView = (ListView)findViewById(R.id.myListView);
        final EditText myEditText = (EditText)findViewById(R.id.myEditText);
        
        // Create the array list of to do items
        final ArrayList<String> todoItems = new ArrayList<String>();
	   // Create the array adapter to bind the array to the listview
        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>(this,        		
        		R.layout.todolist_item,
        		//android.R.layout.simple_list_item_1,
        		todoItems);
//	    Bind the array adapter to the listview
        myListView.setAdapter(aa);
//        
        myEditText.setOnKeyListener(new OnKeyListener() {
        	public boolean onKey (View v, int keyCode, KeyEvent event) {
        		if (event.getAction() == KeyEvent.ACTION_DOWN)
        			if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER){
        				todoItems.add(0, myEditText.getText().toString());
        				aa.notifyDataSetChanged();
           				Log.d(TAG, "onCreate: new item added to list: " +
myEditText.getText().toString());
        				myEditText.setText("");
        				return true;
        			}
        			return false;
        		}
        	});       
     
    }
    
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, getLocalClassName() + ": onStart : TaskId: "+ getTaskId());
        Log.d(TAG, getLocalClassName() + ": isTaskRoot:" + isTaskRoot());
        Log.d(TAG, getLocalClassName() + ": Intent:" + getIntent().toString());

    }
    
    @Override
    public void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: things are still in memory, dont need to go thru onCreate");
    }   

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }
    
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }
    
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}

