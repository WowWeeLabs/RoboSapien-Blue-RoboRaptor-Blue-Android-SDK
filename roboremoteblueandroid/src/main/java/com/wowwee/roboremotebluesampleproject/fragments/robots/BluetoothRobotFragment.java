package com.wowwee.roboremotebluesampleproject.fragments.robots;

import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.wowwee.roboremotebluesampleproject.AppConfig;
import com.wowwee.roboremotebluesampleproject.ConnectionManager;
import com.wowwee.roboremotebluesampleproject.R;
import com.wowwee.roboremotebluesampleproject.fragments.BluetoothRobotSettingFragment;

public abstract class BluetoothRobotFragment extends RobotFragment {

    private Button m_buttonSetting;

    protected void prepareFragmentView(View view) {
        Log.d("BluetoothRobotFragment", "prepareFragmentView(View view) ");
        super.prepareFragmentView(view);

        m_buttonSetting = (Button) view.findViewById(R.id.button_settings);
        if (m_buttonSetting != null) {
            m_buttonSetting.setVisibility(View.VISIBLE);
            m_buttonSetting.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment settingFragment = new BluetoothRobotSettingFragment();
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, settingFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            });
        }
    }

    @Override
    protected void onRobotConnect() {
        super.onRobotConnect();
        Toast.makeText(getActivity(), ConnectionManager.mRobot.getName() + " disconnected", Toast.LENGTH_LONG).show();
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            int rootFragment = getFragmentManager().getBackStackEntryAt(0).getId();
            if (!AppConfig.getInstance().isEnteredBackground())
                getFragmentManager().popBackStack(rootFragment, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    @Override
    protected void onRobotSleep() {
        super.onRobotSleep();
        final Dialog dialog = new Dialog(getActivity(), R.style.Theme_Dialog);
        dialog.setContentView(R.layout.dialog_prompt);
        TextView textview = (TextView) dialog.findViewById(R.id.textView_DialogView_Title);
        textview.setText(R.string.tutorial_title);
        textview = (TextView) dialog.findViewById(R.id.textView_DialogView_Value);
        textview.setText(R.string.tutorial_sleep);
        Button button = (Button) dialog.findViewById(R.id.button_dialog_no);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
}
