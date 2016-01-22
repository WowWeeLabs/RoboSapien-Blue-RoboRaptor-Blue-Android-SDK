package com.wowwee.roboremotebluesampleproject;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.wowwee.roboremote.robots.BluetoothRobotFinder;
import com.wowwee.roboremote.robots.IRobot;
import com.wowwee.roboremote.robots.IRobotFinder;
import com.wowwee.roboremotebluesampleproject.fragments.RoboRemoteBlueScannerViewFragment;

import java.util.List;

@SuppressLint("NewApi") public class RoboRemoteBlueActivity extends FragmentActivity  {

	private Runnable quitAppRunnable;
	private Handler quitAppHandler;
	private boolean needBackToMain;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        
        RoboRemoteBlueScannerViewFragment firstFragment = new RoboRemoteBlueScannerViewFragment();

        // In case this activity was started with special instructions from an
        // Intent, pass the Intent's extras to the fragment as arguments
        firstFragment.setArguments(getIntent().getExtras());
        
        // Add the fragment to the 'fragment_container' FrameLayout
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, firstFragment).commit();
        
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
    
    protected void onSaveInstanceState (Bundle outState) {
		AppConfig.getInstance().setEnteredBackground(true);
	}
    
    public void onStart() {
    	super.onStart();
    	if (quitAppHandler != null && quitAppRunnable != null) {
			quitAppHandler.removeCallbacks(quitAppRunnable);
		}

		if (needBackToMain) {
			if (getFragmentManager().getBackStackEntryCount() > 0) {
        		int rootFragment = getFragmentManager().getBackStackEntryAt(0).getId();
				if (!AppConfig.getInstance().isEnteredBackground())
					getFragmentManager().popBackStack(rootFragment, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        	}
			
			needBackToMain = false;
		}
    }
    
    public void onStop() {
    	Log.i("Activity", "onStopStart");
    	if (quitAppHandler != null) {
			if (quitAppRunnable != null) {
				quitAppHandler.removeCallbacks(quitAppRunnable);
			}
			quitAppHandler = null;
		}
    	if (quitAppRunnable != null) {
			quitAppRunnable = null;
		}

		quitAppRunnable = new Runnable() {

			@Override
			public void run() {
				BluetoothRobotFinder.getInstance().findAllRobots(new IRobotFinder.RobotsFoundListener() {
					@Override
					public void onFound(List<IRobot> listSnapPets) {
						for (IRobot robot : listSnapPets) {
							robot.disconnect(null);
						}
					}
				});
				needBackToMain = true;

				// change the view to select MiP view
			}
		};
		quitAppHandler = new Handler();
		quitAppHandler.postDelayed(quitAppRunnable, 6000);

        Log.i("Activity", "onStopEnd");
        super.onStop();       
    }

    @Override
    public void onResume() {
        super.onResume();
		AppConfig.getInstance().setEnteredBackground(false);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}

	//// Disable volume up/down buttons.
	//// Not used at the moment to leave the possibility to change the volume in case auto-setting to max will not work
    //@Override
    //public boolean onKeyDown(int keyCode, KeyEvent event) {
    //    if (ConnectionManager.mRobot instanceof XDongleRobot
    //            && (keyCode == KeyEvent.KEYCODE_VOLUME_UP || keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)) {
    //        return true;
    //    }
    //    return super.onKeyDown(keyCode, event);
    //}
}
