package com.wowwee.roboremotebluesampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.WindowManager;

public class SplashActivity extends FragmentActivity implements Runnable {
	
	private final int kSHOW_SPLASH_PAGE_TIME = 1000;

	private boolean m_startedHandler = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// disable idle timer
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
				
		Intent intent = getIntent();
		boolean shouldFinishApp = intent.getBooleanExtra("finishapp", false);
		if(shouldFinishApp) {
			finish();
			return;
		}
		
		//launch the first layout
		setContentView(R.layout.activity_splash);

		//setup the timer for splash page
		if(!this.m_startedHandler) {
			this.m_startedHandler = true;
			(new Handler()).postDelayed(this, kSHOW_SPLASH_PAGE_TIME);
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		
		// disable idle timer
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	}
	
	@Override
	public void run() {
		startActivity(new Intent(this, RoboRemoteBlueActivity.class));
	}
}
