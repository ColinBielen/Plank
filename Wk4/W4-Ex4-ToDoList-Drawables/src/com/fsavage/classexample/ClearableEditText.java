package com.fsavage.classexample;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class ClearableEditText extends LinearLayout {
	  private static final String TAG = "ToDoList";    /** Called when the activity is first created. */

	  EditText editText;
	  Button clearButton; 

	  public ClearableEditText(Context context, AttributeSet attr) {
	    super(context);
	  
	    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
	    inflater.inflate(R.layout.clearable_edit_text, this);  

	    // Inflate the view from the layout resource.

	    // Get references to the child controls.
	    editText = (EditText)findViewById(R.id.editTextCompound);
	    clearButton = (Button)findViewById(R.id.clearButton);

	    // Hook up the functionality
	    hookupButton();
	  }
	  
	  private void hookupButton() {
		  clearButton.setOnClickListener(new Button.OnClickListener() {
		    public void onClick(View v) {
		     Log.d(TAG, "hookupButton:  onClick -- clear the edit text");
		      editText.setText("");
		    }
		  });
		}
	}
