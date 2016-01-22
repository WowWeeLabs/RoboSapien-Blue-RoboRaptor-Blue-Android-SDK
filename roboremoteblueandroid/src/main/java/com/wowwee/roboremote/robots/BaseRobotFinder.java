package com.wowwee.roboremote.robots;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRobotFinder implements IRobotFinder {
    @Override
    public void findByRobotId(final String id, final RobotFoundListener listener) {
        findAllRobots(new RobotsFoundListener() {
            @Override
            public void onFound(List<IRobot> robots) {
                for (IRobot robot : robots) {
                    if (id.equals(robot.getUniqId())) {
                        listener.onFound(robot);
                        break;
                    }
                }
            }
        });
    }

    private List<UpdateRobotsListener> updateRobotsListeners = new ArrayList<UpdateRobotsListener>();

    @Override
    public void addUpdateRobotsListener(UpdateRobotsListener listener) {
        updateRobotsListeners.add(listener);
    }

    @Override
    public void removeUpdateRobotsListener(UpdateRobotsListener listener) {
        updateRobotsListeners.remove(listener);
    }

    protected void updateRobotsEvent() {
        for (UpdateRobotsListener listener : updateRobotsListeners) {
            listener.onUpdate();
        }
    }
}
