package com.fsavage.classexample;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class ImageTextButton extends LinearLayout  {

	public ImageTextButton(Context context, AttributeSet attr) {
		super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
        inflater.inflate(R.layout.imagetextbutton, this); 

	}
}
