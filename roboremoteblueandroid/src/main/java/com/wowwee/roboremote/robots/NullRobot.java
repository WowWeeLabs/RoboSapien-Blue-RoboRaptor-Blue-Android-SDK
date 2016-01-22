package com.wowwee.roboremote.robots;

import android.support.v4.app.Fragment;
import com.wowwee.roboremotebluesampleproject.R;
import com.wowwee.roboremotebluesampleproject.fragments.robots.RobotFragment;

public class NullRobot implements IRobot {
    private NullRobot() {
    }

    static class NullRobotInstanceHolder {
        static NullRobot instance = new NullRobot();
    }

    public static NullRobot getInstance() {
        return NullRobotInstanceHolder.instance;
    }

    @Override
    public String getUniqId() {
        return "null";
    }

    @Override
    public String getDirectoryName() {
        return "null";
    }

    @Override
    public IRobotCommand getCommandByTag(String Tag) {
        return null;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void setName(String name) {
    }

    @Override
    public int getLogoDrawableId() {
        return R.drawable.ic_launcher;
    }

    @Override
    public int getTopLeftLogoDrawableId() {
        return R.drawable.ic_launcher;
    }

    @Override
    public int getBigLogoDrawableId() {
        return R.drawable.ic_launcher;
    }

    @Override
    public Fragment createFragment() {
        return new Fragment();
    }

    @Override
    public String getFirmwareVersion() {
        return "unknown";
    }

    @Override
    public void showInternalInfo() {
    }

    @Override
    public void disconnect(DisconnectListener listener) {
    }

    @Override
    public void onResume(RobotFragment robotFragment) {
        robotFragment.back();
    }

    @Override
    public void loadConfig() {
    }

    @Override
    public void saveConfig() {
    }

    @Override
    public void connect(ConnectListener listener) {
    }

    @Override
    public void addStateChangesListener(StateChangedListener listener) {
    }

    @Override
    public void removeStateChangesListener(StateChangedListener listener) {
    }
}
