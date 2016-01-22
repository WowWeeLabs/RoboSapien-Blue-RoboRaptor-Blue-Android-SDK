package com.wowwee.roboremote.robots;

import android.support.v4.app.Fragment;
import com.wowwee.roboremotebluesampleproject.fragments.robots.RobotFragment;

public interface IRobot {

    IRobotCommand getCommandByTag(String Tag);

    String getUniqId();

    String getDirectoryName();
    String getName();
    void setName(String name);

    int getLogoDrawableId();
    int getTopLeftLogoDrawableId();
    int getBigLogoDrawableId();
    Fragment createFragment();

    String getFirmwareVersion();
    void showInternalInfo();

    void connect(ConnectListener listener);
    void disconnect(DisconnectListener listener);

    void onResume(RobotFragment robotFragment);

    void loadConfig();

    void saveConfig();

    void addStateChangesListener(StateChangedListener listener);

    void removeStateChangesListener(StateChangedListener listener);

    interface DisconnectListener {
        void onDisconnect();
    }

    interface ConnectListener {
        void onConnect();

        void onError(String message);
    }

    interface StateChangedListener {
        void onConnect();

        void onDisconnect();

        void onSleep();

        void onStateChanged();
    }
}
