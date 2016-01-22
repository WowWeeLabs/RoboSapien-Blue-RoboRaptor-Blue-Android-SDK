package com.wowwee.roboremote.robots;

public interface IRobotStateFactory {
    IRobotCommand create(String value);

    String getTag();
}
