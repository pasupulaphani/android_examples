package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";


	// Lifecycle counters
	int mCreate, mStart, mResume, mRestart;

	// activity textviews
	TextView mTvCreate, mTvStart, mTvResume, mTvRestart;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		mTvCreate = (TextView) findViewById(R.id.create);
		mTvStart = (TextView) findViewById(R.id.start);
		mTvResume = (TextView) findViewById(R.id.resume);
		mTvRestart = (TextView) findViewById(R.id.restart);


		Button closeButton = (Button) findViewById(R.id.bClose); 
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				finish();


			
			}
		});

		// Check for previously saved state
		if (savedInstanceState != null) {

			mRestart = savedInstanceState.getInt(RESTART_KEY);
			mResume = savedInstanceState.getInt(RESUME_KEY);
			mStart = savedInstanceState.getInt(START_KEY);
			mCreate = savedInstanceState.getInt(CREATE_KEY);
		
		}


		 Log.i("ActivityTwo", "Entered the onCreate method");

		mCreate++;
		displayCounts();


	}

	// Lifecycle callback methods overrides

	@Override
	public void onStart() {
		super.onStart();


		 Log.i("ActivityTwo", "Entered the onStart method");

		mStart++;
		displayCounts();


	}

	@Override
	public void onResume() {
		super.onResume();

		 Log.i("ActivityTwo", "Entered the onResume method");
		mResume++;
		displayCounts();




	}

	@Override
	public void onPause() {
		super.onPause();

		 Log.i("ActivityTwo", "Entered the onPause method");


	}

	@Override
	public void onStop() {
		super.onStop();

		 Log.i("ActivityTwo", "Entered the onStop method");


	}

	@Override
	public void onRestart() {
		super.onRestart();


		 Log.i("ActivityTwo", "Entered the onRestart method");


		mRestart++;
		displayCounts();



	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		 Log.i("ActivityTwo", "Entered the onDestroy method");


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
