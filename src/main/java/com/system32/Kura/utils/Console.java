package com.system32.Kura.utils;

import com.system32.Kura.Kura;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Console {
    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void sendLog(String from, String type,  String log) {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone(Kura.getConfig().getString("global.timezone")));
        String strDate = df.format(date);
        int fromSeparator = 62;
        int typeSeparator = 7;
        switch (type) {
            case "INFO" -> System.out.println(Color.RESET + strDate + " " + Color.CYAN_BOLD + from + separator(fromSeparator, from) + Color.BLUE + type + separator(typeSeparator, type) + Color.RESET + log);
            case "ERROR" -> System.out.println(Color.RESET + strDate + " " + Color.CYAN_BOLD + from + separator(fromSeparator, from) + Color.RED_BRIGHT + type + separator(typeSeparator, type) + Color.RESET + log);
            case "DEBUG" -> System.out.println(Color.RESET + strDate + " " + Color.CYAN_BOLD + from + separator(fromSeparator, from) + Color.YELLOW_BRIGHT + type + separator(typeSeparator, type) + Color.RESET + log);
            default -> System.out.println(Color.RESET + strDate + " " + Color.CYAN_BOLD + from + separator(fromSeparator, from) + Color.GREEN_BRIGHT + type + separator(typeSeparator, type) + Color.RESET + log);
        }
    }

    public static void sendLogNoConfig(String from, String type,  String log) {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("GMT-5:00"));
        String strDate = df.format(date);
        int fromSeparator = 62;
        int typeSeparator = 7;
        switch (type) {
            case "INFO" -> System.out.println(Color.RESET + strDate + " " + Color.CYAN_BOLD + from + separator(fromSeparator, from) + Color.BLUE + type + separator(typeSeparator, type) + Color.RESET + log);
            case "ERROR" -> System.out.println(Color.RESET + strDate + " " + Color.CYAN_BOLD + from + separator(fromSeparator, from) + Color.RED_BRIGHT + type + separator(typeSeparator, type) + Color.RESET + log);
            case "DEBUG" -> System.out.println(Color.RESET + strDate + " " + Color.CYAN_BOLD + from + separator(fromSeparator, from) + Color.YELLOW_BRIGHT + type + separator(typeSeparator, type) + Color.RESET + log);
            default -> System.out.println(Color.RESET + strDate + " " + Color.CYAN_BOLD + from + separator(fromSeparator, from) + Color.GREEN_BRIGHT + type + separator(typeSeparator, type) + Color.RESET + log);
        }
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
