package com.bielen.colin.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class LayoutSectionMain extends Activity implements View.OnClickListener{


	private static final String TAG = "LayoutSelector";        
	private RadioGroup mRadioGroup;
	private CheckBox mCheckBoxEx;
	    
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);

	        // Inflate your view
	        setContentView(R.layout.main);
	        Log.d(TAG, "onCreate:  Get references to our UI widgets");
	        mRadioGroup = (RadioGroup) findViewById(R.id.radio_group);
	        mCheckBoxEx = (CheckBox)findViewById(R.id.check1);
	        Button clearButton = (Button) findViewById(R.id.button_doit);
	        // setOnClickListener onto button
	 clearButton.setOnClickListener(this);
	    }
	    
	    public void onClick(View v) {
	        int iRBSelected = mRadioGroup.getCheckedRadioButtonId();
	        boolean bIsChecked = mCheckBoxEx.isChecked();
	        Log.d(TAG, "onClick: Checkbox is checked: " + bIsChecked);
	        String message = "";
	        switch(iRBSelected){
	         case R.id.radio_button_linear: 
	        	 Log.d(TAG, "onClick:  radio_button_linear");
	        	 startActivity(new Intent(LayoutSectionMain.this,LinearLayoutExample.class));   
	            break;
	         case R.id.radio_button_relative1: 
	         	Log.d(TAG, "onClick:  radio_button_relative ");
	         	message = "onClick:  radio_button_ relative ";
	         //	Toast.makeText(this, message, Toast.LENGTH_LONG).show();
	         	 startActivity(new Intent(LayoutSectionMain.this,RelativeLayoutExample.class));
	        	    break;
	         case R.id.radio_button_mixed: 
	        	 message = "onClick:  radio_button_ mixed ";

	             Log.d(TAG, "onClick:  radio_button_relative ");
	             startActivity(new Intent(LayoutSectionMain.this,MixedLayoutExample.class));  

	        	 //Toast.makeText(this, message, Toast.LENGTH_LONG).show();
	        	    break;
	         case R.id.radio_button_table: 
	         	Log.d(TAG, "onClick:  radio_button_table");
	         	message = "onClick:  radio_button_ mixed ";
	             startActivity(new Intent(LayoutSectionMain.this,TableLayoutExample.class));  	         	
	         	//Toast.makeText(this, message, Toast.LENGTH_LONG).show();
	        	    break;

	         default:
	         	break;
	         }
	         mRadioGroup.clearCheck();
	         
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

	
	    @Override
		public boolean onCreateOptionsMenu(Menu menu) {
	    	Log.e(TAG,"Here in onCreateOptionsMenu!");
			new MenuInflater(getApplication()).inflate(R.menu.title_icon, menu);
			//super.onCreateOptionsMenu(menu);
			return(super.onCreateOptionsMenu(menu));
			//return true;
		}
	    
	   
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			String message = "";
			switch (item.getItemId()){
			case R.id.menu_happy: 
				message="Toast example- happy";
				break;
			case R.id.menu_neutral: 
					message="Toast example- neutral";
					break;		
			case R.id.menu_sad: 
				message="Toast example- sad";
				break;
			default:
				return(super.onOptionsItemSelected(item));
			}
			Toast.makeText(this, message, Toast.LENGTH_LONG).show();
				
			return(true);
		}
		
		@Override
	    public void onCreateContextMenu(ContextMenu menu, View view, 
	    ContextMenuInfo menuInfo) 
	    {
	         super.onCreateContextMenu(menu, view, menuInfo);
	         new MenuInflater(getApplication()).inflate(R.menu.title_icon, menu);
	    }

	    @Override
	    public boolean onContextItemSelected(MenuItem item)
	    {    
			String message = "";
			switch (item.getItemId()){
			case R.id.menu_happy: 
				message="Toast context example- happy";
				break;
			case R.id.menu_neutral: 
					message="Toast context example- neutral";
					break;		
			case R.id.menu_sad: 
				message="Toast context example- sad";
				break;
			default:
				return(super.onOptionsItemSelected(item));
			}
			Toast.makeText(this, message, Toast.LENGTH_LONG).show();
				
			return(true);  
	    }  

	    
	    
	}

