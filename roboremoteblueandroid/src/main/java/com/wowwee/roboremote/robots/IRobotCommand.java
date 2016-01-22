package com.wowwee.roboremote.robots;

public interface IRobotCommand {
    int getNameId();

    void execute();

    String getTag();
}
