package course.labs.activitylab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityOne";

	// Lifecycle counters
	int mCreate, mStart, mResume, mRestart;

	// activity textviews
	TextView mTvCreate, mTvStart, mTvResume, mTvRestart;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);

		mTvCreate = (TextView) findViewById(R.id.create);
		mTvStart = (TextView) findViewById(R.id.start);
		mTvResume = (TextView) findViewById(R.id.resume);
		mTvRestart = (TextView) findViewById(R.id.restart);

		Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo); 
		launchActivityTwoButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				Intent intent = new Intent();
				intent.setClass(ActivityOne.this, ActivityTwo.class);
				startActivity(intent); 

			
			}
		});
		
		// Check for previously saved state
		if (savedInstanceState != null) {

			mRestart = savedInstanceState.getInt(RESTART_KEY);
			mResume = savedInstanceState.getInt(RESUME_KEY);
			mStart = savedInstanceState.getInt(START_KEY);
			mCreate = savedInstanceState.getInt(CREATE_KEY);
		
		}

		// TODO: Emit LogCat message
		 Log.i("ActivityOne", "Entered the onCreate method");

		mCreate++;
		displayCounts();



	}

	// Lifecycle callback overrides

	@Override
	public void onStart() {
		super.onStart();

		 Log.i("ActivityOne", "Entered the onStart method");

		mStart++;
		displayCounts();

	}

	@Override
	public void onResume() {
		super.onResume();

		 Log.i("ActivityOne", "Entered the onResume method");
		mResume++;
		displayCounts();


	}

	@Override
	public void onPause() {
		super.onPause();

		 Log.i("ActivityOne", "Entered the onPause method");

	}

	@Override
	public void onStop() {
		super.onStop();

		 Log.i("ActivityOne", "Entered the onStop method");

	}

	@Override
	public void onRestart() {
		super.onRestart();

		 Log.i("ActivityOne", "Entered the onRestart method");


		mRestart++;
		displayCounts();



	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		 Log.i("ActivityOne", "Entered the onDestroy method");


	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {

		savedInstanceState.putInt(RESTART_KEY, mRestart);
		savedInstanceState.putInt(RESUME_KEY, mResume);
		savedInstanceState.putInt(START_KEY, mStart);
		savedInstanceState.putInt(CREATE_KEY, mCreate);

		super.onSaveInstanceState(savedInstanceState);
	}
	
	// Updates the displayed counters
	public void displayCounts() {

		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
	
	}
}
