package com.wowwee.roboremote.robots;

import java.util.List;

public interface IRobotFinder {
    void findByRobotId(String id, RobotFoundListener listener);

    void findAllRobots(RobotsFoundListener listener);

    interface RobotFoundListener {
        /***
         * @param robot can be null if not found
         */
        void onFound(IRobot robot);
    }

    interface RobotsFoundListener {
        /***
         * @param robots can`t be null
         */
        void onFound(List<IRobot> robots);
    }

    void startScan();

    void stopScan();

    void rescan();

    void addUpdateRobotsListener(UpdateRobotsListener listener);

    void removeUpdateRobotsListener(UpdateRobotsListener listener);

    interface UpdateRobotsListener {
        void onUpdate();
    }
}
