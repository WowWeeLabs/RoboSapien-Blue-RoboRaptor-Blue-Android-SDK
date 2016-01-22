package com.wowwee.roboremote.robots;

import android.content.Context;
import android.content.SharedPreferences;
import com.wowwee.roboremotebluesampleproject.App;
import com.wowwee.roboremotebluesampleproject.fragments.robots.RobotFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseRobot implements IRobot {
    protected static final String kMyPerference = "AppPrefs";
    private static final String kRobotNamePrefix = "RobotName";

    private Map<String, IRobotCommand> commandByTag = new HashMap<String, IRobotCommand>();
    private Map<String, IRobotStateFactory> stateFactoryByTag = new HashMap<String, IRobotStateFactory>();
    private String robotName;

    protected void addCommand(IRobotCommand command) {
        commandByTag.put(command.getTag(), command);
    }

    protected void addStateFactory(IRobotStateFactory factory) {
        stateFactoryByTag.put(factory.getTag(), factory);
    }

    public IRobotCommand getCommandByTag(String tag) {
        IRobotCommand result = null;
        if (tag.startsWith("Set_")) {
            try {
                int strtPosVal = tag.indexOf("_", 4);
                String value = tag.substring(strtPosVal + 1);
                tag = tag.substring(4, strtPosVal);
                if (stateFactoryByTag.containsKey(tag)) {
                    result = stateFactoryByTag.get(tag).create(value);
                }
            } catch (Exception e) {
            }
        } else {
            if (commandByTag.containsKey(tag)) {
                result = commandByTag.get(tag);
            }
        }
        return result;
    }

    @Override
    public String getName() {
        if (robotName != null) {
            return robotName;
        } else {
            return App.getContext().getString(getDefaultNameId());
        }
    }

    protected abstract int getDefaultNameId();

    @Override
    public void setName(String name) {
        robotName = name;
    }

    public void loadConfig() {
        SharedPreferences pref = App.getContext().getSharedPreferences(kMyPerference, Context.MODE_PRIVATE);
        robotName = pref.getString(kRobotNamePrefix + getDirectoryName(), null);
    }

    public void saveConfig() {
        SharedPreferences.Editor editor = App.getContext().getSharedPreferences(kMyPerference, Context.MODE_PRIVATE).edit();

        if (robotName != null) {
            editor.putString(kRobotNamePrefix + getDirectoryName(), robotName);
        }

        editor.commit();
    }

    private List<StateChangedListener> stateChangedListeners = new ArrayList<StateChangedListener>();

    @Override
    public void addStateChangesListener(StateChangedListener listener) {
        stateChangedListeners.add(listener);
    }

    @Override
    public void removeStateChangesListener(StateChangedListener listener) {
        stateChangedListeners.remove(listener);
    }

    protected void disconnectEvent() {
        for (StateChangedListener listener : stateChangedListeners) {
            listener.onDisconnect();
        }
    }

    protected void connectEvent() {
        for (StateChangedListener listener : stateChangedListeners) {
            listener.onConnect();
        }
    }

    protected void sleepEvent() {
        for (StateChangedListener listener : stateChangedListeners) {
            listener.onSleep();
        }
    }

    protected void stateChangedEvent() {
        for (StateChangedListener listener : stateChangedListeners) {
            listener.onStateChanged();
        }
    }


    @Override
    public void onResume(RobotFragment robotFragment) {

    }
}
