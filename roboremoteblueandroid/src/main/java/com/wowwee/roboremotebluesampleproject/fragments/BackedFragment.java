package com.wowwee.roboremotebluesampleproject.fragments;

import android.content.pm.ActivityInfo;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.wowwee.roboremotebluesampleproject.R;

public class BackedFragment extends Fragment {
    protected void processBackButton(View view) {
        ViewGroup tableLayout = (ViewGroup) view.findViewById(R.id.layout_settingpanel_black);
        int count = tableLayout.getChildCount();
        for (int i = 0; i < count; i++) {
            View aView = tableLayout.getChildAt(i);
            if (aView instanceof Button) {
                Button aButton = (Button) aView;
                if (aButton.getTag().equals("SettingPageButtonBack")) {
                    aButton.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            getFragmentManager().popBackStack();
                        }
                    });
                }
            }
        }
    }
    
    @Override
    public void onResume()
    {
    	super.onResume();
    	getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
    
}
