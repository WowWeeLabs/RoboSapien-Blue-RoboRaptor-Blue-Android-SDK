package com.wowwee.roboremote.robots;

import com.wowwee.bluetoothrobotcontrollib.roboraptor.RoboraptorCommandValues;
import com.wowwee.bluetoothrobotcontrollib.robosapien.RobosapienCommandValues;
import com.wowwee.roboremotebluesampleproject.R;

public abstract class RoboraptorCommand extends BluetoothRobotCommand {
    public static class HeadClockwise extends RoboraptorCommand {
        @Override
        public int getNameId() {
            return R.string.head_clockwise;
        }

        @Override
        public String getTag() {
            return "ActionTopPanel_Roboraptor_Up";
        }

        @Override
        protected String getCommandText() {
            return RoboraptorCommandValues.kRoboraptorCommandsHeadClockwise;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.clockwise_head_vc;
        }
    }

    public static class TailLeft extends RoboraptorCommand {
        @Override
        public int getNameId() {
            return R.string.left_tail;
        }

        @Override
        public String getTag() {
            return "ActionTopPanel_Roboraptor_Left";
        }

        @Override
        protected String getCommandText() {
            return RoboraptorCommandValues.kRobosapienCommandsTailLeft;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.tail_left_vc;
        }
    }

    public static class Bite extends RoboraptorCommand {
        @Override
        public int getNameId() {
            return R.string.bite;
        }

        @Override
        public String getTag() {
            return "ActionTopPanel_Roboraptor_Center";
        }

        @Override
        protected String getCommandText() {
            return RoboraptorCommandValues.kRobosapienCommandsBite;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.bite_vc;
        }
    }

    public static class TailRight extends RoboraptorCommand {
        @Override
        public int getNameId() {
            return R.string.right_tail;
        }

        @Override
        public String getTag() {
            return "ActionTopPanel_Roboraptor_Right";
        }

        @Override
        protected String getCommandText() {
            return RoboraptorCommandValues.kRobosapienCommandsTailRight;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.tail_right_vc;
        }
    }

    public static class HeadCounterClockwise extends RoboraptorCommand {
        @Override
        public int getNameId() {
            return R.string.head_counterclockwise;
        }

        @Override
        public String getTag() {
            return "ActionTopPanel_Roboraptor_Down";
        }

        @Override
        protected String getCommandText() {
            return RoboraptorCommandValues.kRoboraptorCommandsHeadCounterClockwise;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.counterclockwise_head_vc;
        }
    }

    public static class GuardMode extends RoboraptorCommand {
        @Override
        public int getNameId() {
            return R.string.guard_mode;
        }

        @Override
        public String getTag() {
            return "ActionBottomPanelLeftTop";
        }

        @Override
        protected String getCommandText() {
            return RoboraptorCommandValues.kRoboraptorCommandsGuardMode;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.guard_mode_vc;
        }
    }

    public static class Demo extends RoboraptorCommand {
        @Override
        public int getNameId() {
            return R.string.demo;
        }

        @Override
        public String getTag() {
            return "ActionBottomPanelLeftMiddle";
        }

        @Override
        protected String getCommandText() {
            return RoboraptorCommandValues.kRoboraptorCommandsDemo;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.demo;
        }
    }

    public static class HuntingMode extends RoboraptorCommand {
        @Override
        public int getNameId() {
            return R.string.hunting_mode;
        }

        @Override
        public String getTag() {
            return "ActionBottomPanelLeftBottom";
        }

        @Override
        protected String getCommandText() {
            return RoboraptorCommandValues.kRoboraptorCommandsHuntingMode;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.hunting_mode_vc;
        }
    }

    public static class CautiousMode extends RoboraptorCommand {
        @Override
        public int getNameId() {
            return R.string.cautious_mode;
        }

        @Override
        public String getTag() {
            return "ActionBottomPanelRightTop";
        }

        @Override
        protected String getCommandText() {
            return RoboraptorCommandValues.kRoboraptorCommandsCautiousMode;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.cautious_mode_vc;
        }
    }

    public static class Roam extends RoboraptorCommand {
        @Override
        public int getNameId() {
            return R.string.roam;
        }

        @Override
        public String getTag() {
            return "ActionBottomPanelRightMiddle";
        }

        @Override
        protected String getCommandText() {
            return RoboraptorCommandValues.kRoboraptorCommandsRoam;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.roam;
        }
    }

    public static class PlayfulMode extends RoboraptorCommand {
        @Override
        public int getNameId() {
            return R.string.playful_mode;
        }

        @Override
        public String getTag() {
            return "ActionBottomPanelRightBottom";
        }

        @Override
        protected String getCommandText() {
            return RoboraptorCommandValues.kRoboraptorCommandsPlayfulMode;
        }

        @Override
        public int getVoiceCommandId() {
            return R.string.playful_mode_vc;
        }
    }

    public static class Up extends RoboraptorCommand {
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

    public static class Down extends RoboraptorCommand {
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

    public static class Right extends RoboraptorCommand {
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

    public static class Left extends RoboraptorCommand {
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

    public static class Stop extends RoboraptorCommand {
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

    public static class LeanForward extends RoboraptorCommand {
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
            //TODO voice command not exist
            return 0;
        }
    }

    public static class LeanBackward extends RoboraptorCommand {
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
            //TODO voice command not exist
            return 0;
        }
    }

    public static class WaistLeft extends RoboraptorCommand {
        @Override
        public int getNameId() {
            return R.string.tilt_left;
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
            //TODO voice command not exist
            return 0;
        }
    }

    public static class WaistRight extends RoboraptorCommand {
        @Override
        public int getNameId() {
            return R.string.tilt_right;
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
            //TODO voice command not exist
            return 0;
        }
    }
}
