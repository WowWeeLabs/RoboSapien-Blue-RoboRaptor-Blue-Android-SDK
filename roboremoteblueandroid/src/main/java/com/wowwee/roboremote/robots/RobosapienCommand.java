package com.wowwee.roboremote.robots;

import com.wowwee.bluetoothrobotcontrollib.robosapien.RobosapienCommandValues;
import com.wowwee.roboremotebluesampleproject.R;

public abstract class RobosapienCommand extends BluetoothRobotCommand {
    public static class RightShoulderForward extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.arm_up;
        }

        @Override
        public String getTag() {
            return "ActionTopPanelLeftTop_P1";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsRightShoulderForward;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.arm_up_left_vc;
        }
    }

    public static class RightShoulderBackward extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.arm_down;
        }

        @Override
        public String getTag() {
            return "ActionTopPanelLeftBottom_P1";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsRightShoulderBackward;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.arm_down_left_vc;
        }
    }

    public static class RightHandForward extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.arm_out;
        }

        @Override
        public String getTag() {
            return "ActionTopPanelLeftStart_P1";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsRightHandForward;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.arm_out_left_vc;
        }
    }

    public static class RightHandBackward extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.arm_in;
        }

        @Override
        public String getTag() {
            return "ActionTopPanelLeftEnd_P1";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsRightHandBackward;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.arm_in_left_vc;
        }
    }

    public static class LeftShoulderForward extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.arm_up;
        }

        @Override
        public String getTag() {
            return "ActionTopPanelRightTop_P1";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsLeftShoulderForward;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.arm_up_right_vc;
        }
    }

    public static class LeftShoulderBackward extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.arm_down;
        }

        @Override
        public String getTag() {
            return "ActionTopPanelRightBottom_P1";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsLeftShoulderBackward;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.arm_down_right_vc;
        }
    }

    public static class LeftHandForward extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.arm_out;
        }

        @Override
        public String getTag() {
            return "ActionTopPanelRightStart_P1";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsLeftHandForward;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.arm_out_right_vc;
        }
    }

    public static class LeftHandBackward extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.arm_in;
        }

        @Override
        public String getTag() {
            return "ActionTopPanelRightEnd_P1";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsLeftHandBackward;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.arm_in_right_vc;
        }
    }

    public static class RightArmPickUp extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.pick_up;
        }

        @Override
        public String getTag() {
            return "ActionTopPanelLeftTop_P2";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsRightArmPickUp;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.pick_up_left_vc;
        }
    }

    public static class RightArmThrow extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.throw_;
        }

        @Override
        public String getTag() {
            return "ActionTopPanelLeftBottom_P2";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsRightArmThrow;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.throw_left_vc;
        }
    }

    public static class RightArmThump extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.thump;
        }

        @Override
        public String getTag() {
            return "ActionTopPanelLeftStart_P2";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsRightArmThump;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.thump_left_vc;
        }
    }

    public static class RightArmSweep extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.sweep;
        }

        @Override
        public String getTag() {
            return "ActionTopPanelLeftEnd_P2";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsRightArmSweep;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.sweep_left_vc;
        }
    }

    public static class LeftArmPickUp extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.pick_up;
        }

        @Override
        public String getTag() {
            return "ActionTopPanelRightTop_P2";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsLeftArmPickUp;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.pick_up_right_vc;
        }
    }

    public static class LeftArmThrow extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.throw_;
        }

        @Override
        public String getTag() {
            return "ActionTopPanelRightBottom_P2";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsLeftArmThrow;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.throw_right_vc;
        }
    }

    public static class LeftArmThump extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.thump;
        }

        @Override
        public String getTag() {
            return "ActionTopPanelRightStart_P2";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsLeftArmThump;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.thump_right_vc;
        }
    }

    public static class LeftArmSweep extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.sweep;
        }

        @Override
        public String getTag() {
            return "ActionTopPanelRightEnd_P2";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsLeftArmSweep;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.sweep_right_vc;
        }
    }

    public static class RightArmStrike1 extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.strike_1;
        }

        @Override
        public String getTag() {
            return "ActionTopPanelLeftTop_P3";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsRightArmStrike1;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.strike_one_left_vc;
        }
    }

    public static class RightArmStrike2 extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.strike_2;
        }

        @Override
        public String getTag() {
            return "ActionTopPanelLeftBottom_P3";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsRightArmStrike2;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.strike_two_left_vc;
        }
    }

    public static class RightArmHigh5 extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.high_5;
        }

        @Override
        public String getTag() {
            return "ActionTopPanelLeftStart_P3";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsRightArmHigh5;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.high_five_vc;
        }
    }

    public static class RightArmStrike3 extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.strike_3;
        }

        @Override
        public String getTag() {
            return "ActionTopPanelLeftEnd_P3";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsRightArmStrike3;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.strike_three_left_vc;
        }
    }

    public static class LeftArmStrike1 extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.strike_1;
        }

        @Override
        public String getTag() {
            return "ActionTopPanelRightTop_P3";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsLeftArmStrike1;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.strike_one_right_vc;
        }
    }

    public static class LeftArmStrike2 extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.strike_2;
        }

        @Override
        public String getTag() {
            return "ActionTopPanelRightBottom_P3";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsLeftArmStrike2;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.strike_two_right_vc;
        }
    }

    public static class TalkBack extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.talk_back;
        }

        @Override
        public String getTag() {
            return "ActionTopPanelRightStart_P3";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsTalkBack;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.talk_back_vc;
        }
    }

    public static class LeftArmStrike3 extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.strike_3;
        }

        @Override
        public String getTag() {
            return "ActionTopPanelRightEnd_P3";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsLeftArmStrike3;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.strike_three_right_vc;
        }
    }

    public static class Demo1 extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.demo1;
        }

        @Override
        public String getTag() {
            return "Demo 1";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsDemo1;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.demo_one_vc;
        }
    }

    public static class Demo2 extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.demo2;
        }

        @Override
        public String getTag() {
            return "Demo 2";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsDemo2;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.demo_two_vc;
        }
    }

    public static class Sleep extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.sleep;
        }

        @Override
        public String getTag() {
            return "Sleep";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsSleep;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.sleep_vc;
        }
    }

    public static class Listen extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.listen;
        }

        @Override
        public String getTag() {
            return "Listen";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsListen;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.listen_vc;
        }
    }

    public static class SFXWhistle extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.sfx_whistle;
        }

        @Override
        public String getTag() {
            return "ActionBottomPanelLeftTop";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsSFXWhistle;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.whistle_vc;
        }
    }

    public static class SFXOops extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.sfx_oops;
        }

        @Override
        public String getTag() {
            return "ActionBottomPanelRightBottom";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsSFXOops;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.oops_vc;
        }
    }

    public static class SFXRoar extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.sfx_roar;
        }

        @Override
        public String getTag() {
            return "ActionBottomPanelRightTop";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsSFXRoar;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.roar_vc;
        }
    }

    public static class SFXBurp extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.sfx_burp;
        }

        @Override
        public String getTag() {
            return "ActionBottomPanelLeftBottom";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsSFXBurp;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.burp_vc;
        }
    }

    public static class Up extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.move_forward;
        }

        @Override
        public String getTag() {
            return "ActionMovementForward";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsUp;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.move_forward_vc;
        }
    }

    public static class Down extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.move_back;
        }

        @Override
        public String getTag() {
            return "ActionMovementBack";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsDown;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.move_back_vc;
        }
    }

    public static class Right extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.move_left;
        }

        @Override
        public String getTag() {
            return "ActionMovementLeft";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsRight;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.turn_left_vc;
        }
    }

    public static class Left extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.move_right;
        }

        @Override
        public String getTag() {
            return "ActionMovementRight";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsLeft;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.turn_right_vc;
        }
    }

    public static class Stop extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.stop;
        }

        @Override
        public String getTag() {
            return "Stop";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsStop;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.stop_vc;
        }
    }

    public static class LeanForward extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.lean_forward;
        }

        @Override
        public String getTag() {
            return "ActionLeanForward";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsLeanForward;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.lean_forward_vc;
        }
    }

    public static class LeanBackward extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.lean_back;
        }

        @Override
        public String getTag() {
            return "ActionLeanBack";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsLeanBackward;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.lean_backward_vc;
        }
    }

    public static class WaistLeft extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.tilt_right;
        }

        @Override
        public String getTag() {
            return "ActionTiltRight";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsWaistLeft;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.tilt_right_vc;
        }
    }

    public static class WaistRight extends RobosapienCommand {
        @Override
        public int getNameId() {
            return R.string.tilt_left;
        }

        @Override
        public String getTag() {
            return "ActionTiltLeft";
        }

        @Override
        protected String getCommandText() {
            return RobosapienCommandValues.kRobosapienCommandsWaistRight;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.tilt_left_vc;
        }
    }
}
