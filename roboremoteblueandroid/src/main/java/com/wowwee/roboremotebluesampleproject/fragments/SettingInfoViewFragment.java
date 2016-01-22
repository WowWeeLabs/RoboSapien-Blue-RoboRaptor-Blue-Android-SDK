package com.wowwee.roboremotebluesampleproject.fragments;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wowwee.roboremotebluesampleproject.ConnectionManager;
import com.wowwee.roboremotebluesampleproject.R;

public class SettingInfoViewFragment extends BackedFragment {
	public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		      /**
		       * Inflate the layout for this fragment
		       */
		final View view = inflater.inflate(R.layout.fragment_setting_info_view, container, false);

		processBackButton(view);

		final Activity currentActivity = this.getActivity();
		PackageInfo pInfo = null;
		try {
			 pInfo = currentActivity.getPackageManager().getPackageInfo(currentActivity.getPackageName(), 0);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}

		TextView aTextView = (TextView) view.findViewById(R.id.textView_InfoView_AppVersion_Value);
		aTextView.setText(pInfo.versionName);

		view.findViewById(R.id.layoutSettingScrollView_InfoView_Robot).setVisibility(View.VISIBLE);
		view.findViewById(R.id.layoutSettingScrollView_FirmwareVersion).setVisibility(View.VISIBLE);
		aTextView = (TextView) view.findViewById(R.id.textView_InfoView_FirmwareVersion_value);
		aTextView.setText(ConnectionManager.mRobot.getFirmwareVersion());

		aTextView = (TextView) view.findViewById(R.id.textView_InfoView_Robot_value);
		aTextView.setText(ConnectionManager.mRobot.getName());
		
		return view;
	}
}