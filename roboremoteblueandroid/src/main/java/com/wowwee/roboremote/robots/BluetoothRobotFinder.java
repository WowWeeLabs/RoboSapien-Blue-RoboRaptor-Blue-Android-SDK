package com.wowwee.roboremote.robots;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.wowwee.bluetoothrobotcontrollib.BluetoothRobot;
import com.wowwee.bluetoothrobotcontrollib.roboremoteblue.RoboRemoteBlueFinder;
import com.wowwee.roboremotebluesampleproject.App;

import java.util.ArrayList;
import java.util.List;

public class BluetoothRobotFinder extends BaseRobotFinder {
    private boolean isEnableBluetooth = false;
    private BluetoothAdapter mBluetoothAdapter;

    private BluetoothRobotFinder() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            // only for gingerbread and newer versions
            isEnableBluetooth = true;
        }

        if (isEnableBluetooth) {
            final BluetoothManager bluetoothManager = (BluetoothManager) App.getContext().getSystemService(Context.BLUETOOTH_SERVICE);
            mBluetoothAdapter = bluetoothManager.getAdapter();

            // Set BluetoothAdapter to SnapPetsFinder
            RoboRemoteBlueFinder.getInstance().setBluetoothAdapter(mBluetoothAdapter);

            // Set Context to SnapPetsFinder
            RoboRemoteBlueFinder.getInstance().setApplicationContext(App.getContext());
            RoboRemoteBlueFinder.getInstance().setScanOptionsFlagMask(RoboRemoteBlueFinder.RPFScanOptionMask_FilterByProductId);
            RoboRemoteBlueFinder.getInstance().scanForRoboremoteBlue();

            App.getContext().registerReceiver(mRoboRemoteBlueFinderBroadcastReceiver, RoboRemoteBlueFinder.getRoboRemoteBlueFinderIntentFilter());
        }
    }

    static class BluetoothRobotFinderInstanceHolder {
        static BluetoothRobotFinder instance = new BluetoothRobotFinder();
    }

    public static BluetoothRobotFinder getInstance() {
        return BluetoothRobotFinderInstanceHolder.instance;
    }

    private final BroadcastReceiver mRoboRemoteBlueFinderBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();
            if (RoboRemoteBlueFinder.RoboRemoteBlueFinder_RobotsFound.equals(action)) {
                updateRobotsEvent();
            }
        }
    };

    @Override
    public void findAllRobots(RobotsFoundListener listener) {
        List<IRobot> robots = new ArrayList<IRobot>();
        if (isEnableBluetooth) {
            List<BluetoothRobot> listSnapPets = RoboRemoteBlueFinder.getInstance().getDevicesFound();
            for (BluetoothRobot bRobot : listSnapPets) {
                robots.add(com.wowwee.roboremote.robots.BluetoothRobot.Factory.getInstance().create(bRobot));
            }
            listener.onFound(robots);
        }
    }

    @Override
    public void startScan() {
        if (isEnableBluetooth) {
            for (Object obj : RoboRemoteBlueFinder.getInstance().getDevicesConnected()) {
                BluetoothRobot robot = (BluetoothRobot) obj;
                robot.disconnect();
            }
            App.getContext().registerReceiver(mRoboRemoteBlueFinderBroadcastReceiver, RoboRemoteBlueFinder.getRoboRemoteBlueFinderIntentFilter());
            RoboRemoteBlueFinder.getInstance().stopScanForRoboRemoteBlueRobots();
            RoboRemoteBlueFinder.getInstance().clearFoundRoboRemoteBlueRobotList();
            RoboRemoteBlueFinder.getInstance().scanForRoboremoteBlue();
        }
    }

    @Override
    public void stopScan() {
        if (isEnableBluetooth) {
            RoboRemoteBlueFinder.getInstance().stopScanForRoboRemoteBlueRobots();
            RoboRemoteBlueFinder.getInstance().clearFoundRoboRemoteBlueRobotList();
            App.getContext().unregisterReceiver(mRoboRemoteBlueFinderBroadcastReceiver);
        }
    }

    @Override
    public void rescan() {
        if (isEnableBluetooth) {
            RoboRemoteBlueFinder.getInstance().stopScanForRoboRemoteBlueRobots();
            RoboRemoteBlueFinder.getInstance().clearFoundRoboRemoteBlueRobotList();
            RoboRemoteBlueFinder.getInstance().scanForRoboremoteBlue();
        }
    }
}
