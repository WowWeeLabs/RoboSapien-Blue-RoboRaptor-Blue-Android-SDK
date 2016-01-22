package com.wowwee.roboremote.robots;

public abstract class BluetoothRobotCommand implements IRobotCommand {
    protected com.wowwee.bluetoothrobotcontrollib.RobotCommand command;
    private BluetoothRobot robot;

    BluetoothRobotCommand() {
        setCommand(com.wowwee.bluetoothrobotcontrollib.RobotCommand.create(getCommandText()));
    }

    protected abstract String getCommandText();

    public abstract int getVoiceCommandId();

    void setRobot(BluetoothRobot robot) {
        this.robot = robot;
    }

    void setCommand(com.wowwee.bluetoothrobotcontrollib.RobotCommand command) {
        this.command = command;
    }

    public void execute() {
        robot.sendRobotCommand(command);
    }
}
