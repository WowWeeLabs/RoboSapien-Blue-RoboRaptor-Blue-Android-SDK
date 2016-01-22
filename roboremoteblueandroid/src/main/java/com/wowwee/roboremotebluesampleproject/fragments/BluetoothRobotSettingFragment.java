package com.wowwee.roboremotebluesampleproject.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.wowwee.roboremotebluesampleproject.ConnectionManager;
import com.wowwee.roboremotebluesampleproject.R;

//import com.wowwee.snappets.fragments.BaseViewFragment;

public class BluetoothRobotSettingFragment extends BackedFragment {

    View m_viewBlack;

    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         * Inflate the layout for this fragment
         */
        final View view = inflater.inflate(R.layout.fragment_settingview, container, false);

        this.m_viewBlack = view.findViewById(R.id.layout_settingpanel_blacklayer);
        this.m_viewBlack.setVisibility(View.INVISIBLE);

        processBackButton(view);

        LinearLayout layoutInfo = (LinearLayout) view.findViewById(R.id.layoutSettingScrollView_Info);
        layoutInfo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SettingInfoViewFragment settingFragment = new SettingInfoViewFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, settingFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        this.UpdateName(view);

        Button aButton = (Button) view.findViewById(R.id.buttonDisconnect);
        aButton.setText(getResources().getString(R.string.disconnect) + " " + ConnectionManager.mRobot.getName());
        aButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ConnectionManager.mRobot.disconnect(null);
            }
        });
        return view;
    }

    void UpdateName(View aView) {
        ConnectionManager.mRobot.showInternalInfo();
    }
}