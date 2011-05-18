package com.bielen.colin.android.midterm.part4;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Part4Activity extends Activity implements OnClickListener {
	public static final String TAG = "MidermPart4Activity";
	protected static final int DIALOG_DEFAULT = 0;
	protected static final String DIALOG_DEFAULT_TITLE = "Colin's Dialog";
	protected String dialogMessage = "";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button blueButton = (Button) findViewById(R.id.button1);
		blueButton.setOnClickListener((OnClickListener) this);
		handleBroadcastMessage();
	}

	/**
	 * Override default stuff with the broadcast message
	 */
	protected void handleBroadcastMessage() {
		Intent myIntent = this.getIntent();
		String broadcastMessage = myIntent
				.getStringExtra(Part4BroadcastReceiver.MESSAGE_KEY);
		if (broadcastMessage != null) {
			Log.d(TAG, "Found Broadcast Message. Overriding defaults...");

			// Override the default Text value:
			TextView tv = (TextView) findViewById(R.id.textView2);
			tv.setText(broadcastMessage);

			// Make a Toast:
			Toast.makeText(this.getApplicationContext(), broadcastMessage,
					Toast.LENGTH_LONG).show();

		} else {
			Log.d(TAG, "No Broadcast Message detected. Using default values.");
		}
	}

	/**
	 * Show a dialog when the user clicks the (only) button.
	 */
	public void onClick(View v) {
		// Remove first per apparent bug:
		// http://code.google.com/p/android/issues/detail?id=857
		removeDialog(DIALOG_DEFAULT);
		showDialog(DIALOG_DEFAULT);

	}

	/**
	 * Encapsulate the logic to get the message since we're using it in multiple
	 * places and it's kind of cumbersome
	 * 
	 * @return
	 */
	protected String getMessage() {
		EditText et = (EditText) this.findViewById(R.id.editText1);
		String msg = et.getText().toString().trim();
		if ("".equals(msg)) {
			// load the default string
			TextView instructionView = (TextView) this
					.findViewById(R.id.textView2);
			msg = instructionView.getText().toString().trim();
		}
		return msg;

	}

	@Override
	protected Dialog onCreateDialog(int id) {
		Dialog dialog;

		switch (id) {
		case DIALOG_DEFAULT:
			String message = getMessage();

			Log.d(TAG, "Message should be: " + message);
			Builder builder = new AlertDialog.Builder(Part4Activity.this);

			builder.setMessage("Broadcast string was: '" + message + "'")
					.setTitle(DIALOG_DEFAULT_TITLE)
					.setCancelable(false)
					.setPositiveButton("Okay",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									Log.d(TAG, "Here in the onClick...");
								}
							});
			dialog = builder.create();
			break;
		default:
			dialog = null;

		}
		return dialog;
	} //end onCreateDialog

} //end class