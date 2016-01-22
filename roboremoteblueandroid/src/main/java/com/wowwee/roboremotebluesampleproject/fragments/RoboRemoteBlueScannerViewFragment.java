package com.wowwee.roboremotebluesampleproject.fragments;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.wowwee.roboremote.robots.BluetoothRobotFinder;
import com.wowwee.roboremote.robots.IRobot;
import com.wowwee.roboremote.robots.IRobotFinder;
import com.wowwee.roboremotebluesampleproject.ConnectionManager;
import com.wowwee.roboremotebluesampleproject.R;
import com.wowwee.roboremotebluesampleproject.adapters.RobotScannerAdapter;
import com.wowwee.roboremotebluesampleproject.adapters.RobotScannerAdapter.RobotScannerItemHolder;

import java.util.List;

@SuppressLint("NewApi")
public class RoboRemoteBlueScannerViewFragment extends Fragment implements IRobotFinder.UpdateRobotsListener {

    public RoboRemoteBlueScannerViewFragment mCurrentFragment;
    private ProgressDialog connectDialog;
    private ListView viewList;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.mCurrentFragment = this;

        View view = inflater.inflate(R.layout.fragment_scannerview, container, false);
        Button aButton = (Button) view.findViewById(R.id.buttonRefresh);
        aButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                BluetoothRobotFinder.getInstance().rescan();
            }
        });

        aButton = (Button) view.findViewById(R.id.buttonSettings);
        aButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Fragment settingFragment = new AppSettingFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, settingFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        viewList = (ListView) view.findViewById(R.id.listViewRobotScanner);

        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        updateRobotList();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        BluetoothRobotFinder.getInstance().addUpdateRobotsListener(this);
        BluetoothRobotFinder.getInstance().startScan();
    }

    @Override
    public void onPause() {
        BluetoothRobotFinder.getInstance().stopScan();
        BluetoothRobotFinder.getInstance().removeUpdateRobotsListener(this);
        super.onPause();
    }

    public void updateRobotList() {
        BluetoothRobotFinder.getInstance().findAllRobots(new IRobotFinder.RobotsFoundListener() {
            @Override
            public void onFound(final List<IRobot> listSnapPets) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (viewList == null) {
                            return;
                        }
                        RobotScannerAdapter adapter = new RobotScannerAdapter(getActivity(), R.layout.table_item_scanner, listSnapPets.toArray(new IRobot[listSnapPets.size()]));
                        viewList.setAdapter(adapter);
                        viewList.setOnItemClickListener(new OnItemClickListener() {
                            @SuppressLint("ShowToast")
                            @Override
                            public void onItemClick(AdapterView<?> arg0, final View arg1, int arg2, long arg3) {
                                Thread aThread = new Thread() {
                                    @Override
                                    public void run() {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        getActivity().runOnUiThread(new Runnable() {
                                            public void run() {
                                                RobotScannerItemHolder holder = (RobotScannerItemHolder) arg1.getTag();
                                                final IRobot robot = holder.getRobot();
                                                String txtConnecting = getString(R.string.toast_trytoconnect_android).replace("Robosapien", robot.getName());
                                                connectDialog = ProgressDialog.show(getActivity(), "", txtConnecting, true);
                                                connectDialog.setCancelable(true);
                                                connectDialog.setCanceledOnTouchOutside(true);
                                                connectDialog.setOnCancelListener(new OnCancelListener() {
                                                    @Override
                                                    public void onCancel(DialogInterface dialog) {
                                                        cancelConnect();
                                                    }
                                                });

                                                try {
                                                    Thread.sleep(500);
                                                } catch (InterruptedException e) {
                                                    e.printStackTrace();
                                                }

                                                robot.connect(new IRobot.ConnectListener() {
                                                    @Override
                                                    public void onConnect() {
                                                        ConnectionManager.mRobot = robot;

                                                        Thread threadStart = new Thread() {
                                                            @Override
                                                            public void run() {
                                                                try {
                                                                    Thread.sleep(1000);
                                                                } catch (InterruptedException e) {
                                                                    e.printStackTrace();
                                                                }
                                                                getActivity().runOnUiThread(new Runnable() {
                                                                    public void run() {
                                                                        Fragment settingFragment = ConnectionManager.mRobot.createFragment();
                                                                        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                                                                        fragmentTransaction.replace(R.id.fragment_container, settingFragment);
                                                                        fragmentTransaction.addToBackStack(null);
                                                                        fragmentTransaction.commit();

                                                                        if (connectDialog != null) {
                                                                            connectDialog.dismiss();
                                                                            connectDialog = null;
                                                                        }

                                                                    }
                                                                });
                                                            }
                                                        };
                                                        threadStart.start();
                                                    }

                                                    @Override
                                                    public void onError(String message) {
                                                        getActivity().runOnUiThread(new Runnable() {
                                                            public void run() {
                                                                Toast.makeText(getActivity(), "Connection failed, please try again", Toast.LENGTH_LONG).show();
                                                                if (connectDialog != null) {
                                                                    connectDialog.dismiss();
                                                                    connectDialog = null;
                                                                }
                                                            }
                                                        });
                                                    }
                                                });
                                            }
                                        });
                                    }
                                };
                                aThread.start();
                            }
                        });
                    }
                });
            }
        });
    }

    private void cancelConnect() {
        BluetoothRobotFinder.getInstance().findAllRobots(new IRobotFinder.RobotsFoundListener() {
            @Override
            public void onFound(List<IRobot> listSnapPets) {
                for (IRobot robot : listSnapPets) {
                    robot.disconnect(null);
                }
            }
        });
    }

    @Override
    public void onUpdate() {
        updateRobotList();
    }
}
