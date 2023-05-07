package com.system32.Kura;

import com.system32.Kura.utils.Color;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Test {
    public static void main(String[] args) {
        printLog("main", "INFO", "Login Successful");
        printLog("JDA MainWS-WriteThread", "INFO", "Connected to websocket");
        printLog("JDA MainWS-ReadThread", "INFO", "Finished Loading!");
    }
    private static void printLog(String from, String type,  String log) {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("GMT-5:00"));
        String strDate = df.format(date);
    }
    private static String separator(Integer length, String from){
        int separatorLength = length;
        StringBuilder separator = new StringBuilder();
        separatorLength = separatorLength - from.length();
        for(int i=0;i<separatorLength;i++){
            separator.insert(0, " ");
        }
        return separator.toString();
    }


}

