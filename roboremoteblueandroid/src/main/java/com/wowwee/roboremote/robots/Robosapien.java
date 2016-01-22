package com.wowwee.roboremote.robots;

import android.support.v4.app.Fragment;
import com.wowwee.roboremotebluesampleproject.R;
import com.wowwee.roboremotebluesampleproject.fragments.robots.RobosapienFragment;

public class Robosapien extends BluetoothRobot {
    Robosapien() {
        super();
        addCommand(new RobosapienCommand.RightShoulderForward());
        addCommand(new RobosapienCommand.RightShoulderBackward());
        addCommand(new RobosapienCommand.RightHandForward());
        addCommand(new RobosapienCommand.RightHandBackward());
        addCommand(new RobosapienCommand.LeftShoulderForward());
        addCommand(new RobosapienCommand.LeftShoulderBackward());
        addCommand(new RobosapienCommand.LeftHandForward());
        addCommand(new RobosapienCommand.LeftHandBackward());
        addCommand(new RobosapienCommand.RightArmPickUp());
        addCommand(new RobosapienCommand.RightArmThrow());
        addCommand(new RobosapienCommand.RightArmThump());
        addCommand(new RobosapienCommand.RightArmSweep());
        addCommand(new RobosapienCommand.LeftArmPickUp());
        addCommand(new RobosapienCommand.LeftArmThrow());
        addCommand(new RobosapienCommand.LeftArmThump());
        addCommand(new RobosapienCommand.LeftArmSweep());
        addCommand(new RobosapienCommand.RightArmStrike1());
        addCommand(new RobosapienCommand.RightArmStrike2());
        addCommand(new RobosapienCommand.RightArmHigh5());
        addCommand(new RobosapienCommand.RightArmStrike3());
        addCommand(new RobosapienCommand.LeftArmStrike1());
        addCommand(new RobosapienCommand.LeftArmStrike2());
        addCommand(new RobosapienCommand.TalkBack());
        addCommand(new RobosapienCommand.LeftArmStrike3());
        addCommand(new RobosapienCommand.Demo1());
        addCommand(new RobosapienCommand.Demo2());
        addCommand(new RobosapienCommand.Sleep());
        addCommand(new RobosapienCommand.Listen());
        addCommand(new RobosapienCommand.SFXWhistle());
        addCommand(new RobosapienCommand.SFXOops());
        addCommand(new RobosapienCommand.SFXRoar());
        addCommand(new RobosapienCommand.SFXBurp());
        addCommand(new RobosapienCommand.Up());
        addCommand(new RobosapienCommand.Down());
        addCommand(new RobosapienCommand.Right());
        addCommand(new RobosapienCommand.Left());
        addCommand(new RobosapienCommand.Stop());
        addCommand(new RobosapienCommand.LeanForward());
        addCommand(new RobosapienCommand.LeanBackward());
        addCommand(new RobosapienCommand.WaistLeft());
        addCommand(new RobosapienCommand.WaistRight());
    }

    @Override
    public String getUniqId() {
        return "robosapien";
    }

    @Override
    public String getDirectoryName() {
        return "robosapien";
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
    protected int getDefaultNameId() {
        return R.string.robosapien_name;
    }


    @Override
    public Fragment createFragment() {
        return new RobosapienFragment();
    }

    @Override
    public String getFirmwareVersion() {
        return ((com.wowwee.bluetoothrobotcontrollib.robosapien.Robosapien) robot).getFirmwareVersion();
    }
}
