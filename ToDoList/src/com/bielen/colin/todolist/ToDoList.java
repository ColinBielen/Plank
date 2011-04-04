package com.bielen.colin.todolist;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
/**
 * Way simple ToDoList to see what android is all about. 
 * ...and to try eclipse for a java project instead of just git/svn browsing and C/C++
 * 
 * @author cbielen
 *
 */
public class ToDoList extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //UI Setup:
        
        setContentView(R.layout.main);
        ListView myListView = (ListView)findViewById(R.id.ListView01);
        final EditText myEditText = (EditText)findViewById(R.id.EditText01);
        final List<String> toDoItems = new ArrayList<String>();
        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,toDoItems);

        myListView.setAdapter(aa);
        //Add the Key Listener and Stuff.
        
        myEditText.setOnKeyListener(new OnKeyListener() {

			public boolean onKey(View v, int keyCode, KeyEvent event) {
				
				if(KeyEvent.ACTION_DOWN == event.getAction()) {
					if(keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
						
						toDoItems.add(myEditText.getText().toString());
						aa.notifyDataSetChanged();
						myEditText.setText("");
						return true;
					} //end DPADCENTER check.
					return false;
				} //end ACTION_DOWN check. 			
				return false;
			}//end onKey()
        	
        });//end setOnKeyListener
        
        
    } //end onCreate()
} //end ToDoList()