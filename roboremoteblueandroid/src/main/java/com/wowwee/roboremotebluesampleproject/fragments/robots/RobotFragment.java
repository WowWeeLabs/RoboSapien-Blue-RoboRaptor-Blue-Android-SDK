package com.wowwee.roboremotebluesampleproject.fragments.robots;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.wowwee.roboremote.robots.IRobot;
import com.wowwee.roboremote.robots.IRobotCommand;
import com.wowwee.roboremotebluesampleproject.AppConfig;
import com.wowwee.roboremotebluesampleproject.ConnectionManager;
import com.wowwee.roboremotebluesampleproject.R;

public abstract class RobotFragment extends Fragment {

    private View m_viewBlack;

    protected void updateChildButtons(ViewGroup group) {
        int count = group.getChildCount();
        for (int i = 0; i < count; i++) {
            View aView = group.getChildAt(i);
            if (aView instanceof Button) {
                updateGeneralButton((Button) aView);
            } else if (aView instanceof ViewGroup) {
                updateChildButtons((ViewGroup) aView);
            }
        }
    }

    protected void prepareFragmentView(View view) {
    	Log.d("RobotFragment", "prepareFragmentView(View view) ");

        this.m_viewBlack = view.findViewById(R.id.layout_RemotePanel_blacklayer);
        this.m_viewBlack.setVisibility(View.INVISIBLE);
        this.m_viewBlack.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        this.m_viewBlack.setVisibility(View.INVISIBLE);

        ImageView imageViewLogo = (ImageView) view.findViewById(R.id.imageViewLogo);
        if (imageViewLogo != null) {
            imageViewLogo.setImageResource(ConnectionManager.mRobot.getTopLeftLogoDrawableId());
        }

    }

    protected void sendRobotCommand(String aTag) {
        sendRobotCommand(aTag, true);
    }

    protected void sendRobotCommand(String aTag, boolean showCommand) {
        IRobotCommand command = ConnectionManager.mRobot.getCommandByTag(aTag);
        if (command != null) {
            command.execute();
            if (showCommand) {
                setCommandText(command.getNameId());
            }
        }
    }

    private IRobot.StateChangedListener robotStateListener = new IRobot.StateChangedListener() {
        @Override
        public void onConnect() {
            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    onRobotConnect();
                }
            });
        }

        @Override
        public void onDisconnect() {
            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    onRobotDisconnect();
                }
            });
        }

        @Override
        public void onSleep() {
            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    onRobotSleep();
                }
            });
        }

        @Override
        public void onStateChanged() {
            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    onRobotChangeState();
                }
            });
        }
    };

    protected void onRobotConnect() {
    }

    protected void onRobotDisconnect() {
    }

    protected void onRobotSleep() {
    }

    protected void onRobotChangeState() {
    }

    @Override
    public void onResume() {
        super.onResume();
        ConnectionManager.mRobot.onResume(this);
        ConnectionManager.mRobot.addStateChangesListener(robotStateListener);
    }

    @Override
    public void onPause() {
        super.onPause();
        ConnectionManager.mRobot.removeStateChangesListener(robotStateListener);
    }

    public void back() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            int rootFragment = getFragmentManager().getBackStackEntryAt(0).getId();
            if (!AppConfig.getInstance().isEnteredBackground())
                getFragmentManager().popBackStack(rootFragment, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    protected abstract void updateGeneralButton(Button button);

    protected abstract void setCommandText(int textId);
}
