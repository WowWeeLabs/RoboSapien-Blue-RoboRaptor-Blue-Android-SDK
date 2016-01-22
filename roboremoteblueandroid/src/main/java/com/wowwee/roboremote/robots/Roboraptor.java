package com.wowwee.roboremote.robots;

import android.support.v4.app.Fragment;
import com.wowwee.roboremotebluesampleproject.R;
import com.wowwee.roboremotebluesampleproject.fragments.robots.RoboraptorFragment;

public class Roboraptor extends BluetoothRobot {
    Roboraptor() {
        super();
        addCommand(new RoboraptorCommand.HeadClockwise());
        addCommand(new RoboraptorCommand.TailLeft());
        addCommand(new RoboraptorCommand.Bite());
        addCommand(new RoboraptorCommand.TailRight());
        addCommand(new RoboraptorCommand.HeadCounterClockwise());
        addCommand(new RoboraptorCommand.GuardMode());
        addCommand(new RoboraptorCommand.Demo());
        addCommand(new RoboraptorCommand.HuntingMode());
        addCommand(new RoboraptorCommand.CautiousMode());
        addCommand(new RoboraptorCommand.Roam());
        addCommand(new RoboraptorCommand.PlayfulMode());
        addCommand(new RoboraptorCommand.Up());
        addCommand(new RoboraptorCommand.Down());
        addCommand(new RoboraptorCommand.Right());
        addCommand(new RoboraptorCommand.Left());
        addCommand(new RoboraptorCommand.Stop());
        addCommand(new RoboraptorCommand.LeanForward());
        addCommand(new RoboraptorCommand.LeanBackward());
        addCommand(new RoboraptorCommand.WaistLeft());
        addCommand(new RoboraptorCommand.WaistRight());
    }

    @Override
    public String getUniqId() {
        return "roboraptor";
    }

    @Override
    public String getDirectoryName() {
        return "roboraptor";
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
        return R.string.roboraptor_name;
    }

    @Override
    public Fragment createFragment() {
        return new RoboraptorFragment();
    }

    @Override
    public String getFirmwareVersion() {
        return ((com.wowwee.bluetoothrobotcontrollib.roboraptor.Roboraptor) robot).getFirmwareVersion();
    }
}
