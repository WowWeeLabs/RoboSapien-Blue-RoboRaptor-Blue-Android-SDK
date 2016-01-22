package com.wowwee.roboremote.robots;

import android.util.Log;
import com.wowwee.bluetoothrobotcontrollib.BluetoothRobotPrivate;
import com.wowwee.bluetoothrobotcontrollib.RobotCommand;
import com.wowwee.bluetoothrobotcontrollib.roboraptor.Roboraptor;
import com.wowwee.bluetoothrobotcontrollib.roboraptor.RoboraptorInterface;
import com.wowwee.bluetoothrobotcontrollib.robosapien.Robosapien;
import com.wowwee.bluetoothrobotcontrollib.robosapien.RobosapienInterface;
import com.wowwee.roboremotebluesampleproject.App;

public abstract class BluetoothRobot extends BaseRobot {
    protected com.wowwee.bluetoothrobotcontrollib.BluetoothRobot robot;

    BluetoothRobot() {
        loadConfig();
    }

    protected void addCommand(BluetoothRobotCommand command) {
        super.addCommand(command);
        command.setRobot(this);
    }

    void setRobot(final com.wowwee.bluetoothrobotcontrollib.robosapien.Robosapien robot) {
        this.robot = robot;
        robot.setCallbackInterface(new RobosapienInterface() {
            @Override
            public void robosapienDeviceConnected(Robosapien robosapien) {
            }

            @Override
            public void robosapienDeviceReady(Robosapien robosapien) {
                robot.getProductActivationStatus();
                connectEvent();
            }

            @Override
            public void robosapienDeviceReconnecting(Robosapien robosapien) {
            }

            @Override
            public void robosapienDeviceDisconnected(Robosapien robosapien, boolean b) {
                disconnectEvent();
            }

            @Override
            public void robosapienDeviceFailedToConnect(Robosapien robosapien, String s) {
                connectErrorEvent(s);
            }

            @Override
            public void robosapienDeviceDidReceivedData(final Robosapien robot, String cmd) {
                Log.d("Robosapien", "didReceiveRobotCommand: " + cmd);
                if (cmd.equals("FA01")) {
                    sleepEvent();
                }
            }

            @Override
            public void robosapienDeviceDidReceiveBRModuleParameters() {

            }

            @Override
            public void robosapienDeviceDidReceiveActivation(byte activation) {
                Log.d("Robosapien", "robosapienDeviceDidReceiveActivation");

                if (activation == BluetoothRobotPrivate.kActivation_FactoryDefault) {
                    Log.i("robosapienDeviceDidReceiveActivation", "kActivation_FactoryDefault");
                    Thread thread = new Thread() {
                        @Override
                        public void run() {
                            try {
                                sleep(1000);
                                robot.setProductActivationUploaded();
                            } catch (InterruptedException e) {
                            }
                        }
                    };
                    thread.start();
                } else if (activation == BluetoothRobotPrivate.kActivation_Activate) {
                    Log.i("robosapienDeviceDidReceiveActivation", "kActivation_Activate");
                    Thread thread = new Thread() {
                        @Override
                        public void run() {
                            try {
                                sleep(1000);
                                robot.setProductActivationUploaded();
                            } catch (InterruptedException e) {
                            }
                        }
                    };
                    thread.start();
                }
            }
        });
    }

    void setRobot(final com.wowwee.bluetoothrobotcontrollib.roboraptor.Roboraptor robot) {
        this.robot = robot;
        robot.setCallbackInterface(new RoboraptorInterface() {
            @Override
            public void roboraptorDeviceConnected(Roboraptor roboraptor) {
            }

            @Override
            public void roboraptorDeviceReady(Roboraptor roboraptor) {
                connectEvent();
            }

            @Override
            public void roboraptorDeviceReconnecting(Roboraptor roboraptor) {
            }

            @Override
            public void roboraptorDeviceDisconnected(Roboraptor roboraptor, boolean b) {
                disconnectEvent();
            }

            @Override
            public void roboraptorDeviceFailedToConnect(Roboraptor roboraptor, String s) {
                connectErrorEvent(s);
            }

            @Override
            public void roboraptorDeviceDidReceivedData(final Roboraptor robot, String cmd) {
                Log.d("Roboraptor", "didReceiveRobotCommand: " + cmd);
                if (cmd.equals("FA01")) {
                    sleepEvent();
                }
            }

            @Override
            public void roboraptorDeviceDidReceiveBRModuleParameters() {

            }

            @Override
            public void roboraptorDeviceDidReceiveActivation(byte activation) {
                Log.d("Roboraptor", "roboraptorDeviceDidReceiveActivation");

                if (activation == BluetoothRobotPrivate.kActivation_FactoryDefault) {
                    Log.i("roboraptorDeviceDidReceiveActivation", "kActivation_FactoryDefault");
                    Thread thread = new Thread() {
                        @Override
                        public void run() {
                            try {
                                sleep(1000);
                                robot.setProductActivationUploaded();
                            } catch (InterruptedException e) {
                            }
                        }
                    };
                    thread.start();
                } else if (activation == BluetoothRobotPrivate.kActivation_Activate) {
                    Log.i("roboraptorDeviceDidReceiveActivation", "kActivation_Activate");
                    Thread thread = new Thread() {
                        @Override
                        public void run() {
                            try {
                                sleep(1000);
                                robot.setProductActivationUploaded();
                            } catch (InterruptedException e) {
                            }
                        }
                    };
                    thread.start();
                }
            }
        });
    }

    @Override
    public void showInternalInfo() {
        robot.getBluetoothModuleSoftwareVersion();
    }

    private DisconnectListener disconnectListener;
    @Override
    public void disconnect(DisconnectListener listener) {
        disconnectListener = listener;
        robot.disconnect();
    }

    protected void disconnectEvent() {
        super.disconnectEvent();
        if (disconnectListener != null) {
            disconnectListener.onDisconnect();
            disconnectListener = null;
        }
    }

    private ConnectListener connectListener;

    @Override
    public void connect(ConnectListener listener) {
        connectListener = listener;
        robot.connect(App.getContext());
    }

    protected void connectEvent() {
        super.connectEvent();
        if (connectListener != null) {
            connectListener.onConnect();
            connectListener = null;
        }
    }

    protected void connectErrorEvent(String message) {
        if (connectListener != null) {
            connectListener.onError(message);
            connectListener = null;
        }
    }

    public void loadConfig() {
        super.loadConfig();
    }

    public void saveConfig() {
        super.saveConfig();
    }

    void sendRobotCommand(RobotCommand command) {
        robot.sendRobotCommand(command);
    }

    public static class Factory {
        private Factory() {
        }

        static class FactoryInstanceHolder {
            static Factory instance = new Factory();
        }

        public static Factory getInstance() {
            return FactoryInstanceHolder.instance;
        }

        public IRobot create(Roboraptor robot) {
            BluetoothRobot result = new com.wowwee.roboremote.robots.Roboraptor();
            result.setRobot(robot);
            return result;
        }

        public IRobot create(Robosapien robot) {
            BluetoothRobot result = new com.wowwee.roboremote.robots.Robosapien();
            result.setRobot(robot);
            return result;
        }

        public IRobot create(com.wowwee.bluetoothrobotcontrollib.BluetoothRobot robot) {
            if (robot instanceof Roboraptor) {
                return create((Roboraptor) robot);
            } else {
                return create((Robosapien) robot);
            }
        }
    }

    @Override
    public void setName(String name) {
        super.setName(name);

        ((BluetoothRobotPrivate) robot).setBluetoothDeviceName(name);
    }
}
