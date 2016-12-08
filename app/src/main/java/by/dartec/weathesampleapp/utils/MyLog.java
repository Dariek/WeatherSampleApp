package by.dartec.weathesampleapp.utils;

import android.util.Log;

/**
 * Created by root on 25.07.16.
 */
public class MyLog {
    private static final String myLog = "myLog";
    private static final String errLog = "errLog";

    public static void myLog(String message) {
        Log.d(myLog, message);
    }

    public static void errLog(String error) {
        Log.d(errLog, error);
    }
}
