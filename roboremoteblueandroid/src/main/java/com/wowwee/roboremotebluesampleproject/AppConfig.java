package com.wowwee.roboremotebluesampleproject;

public class AppConfig {

    static class AppConfigInstanceHolder {
        static AppConfig instance = new AppConfig();
    }

    public static AppConfig getInstance() {
        return AppConfigInstanceHolder.instance;
    }

    private boolean isEnteredBackground;

    private AppConfig() {}

    public boolean isEnteredBackground() {
        return this.isEnteredBackground;
    }

    public void setEnteredBackground(boolean isValue) {
        this.isEnteredBackground = isValue;
    }

}
