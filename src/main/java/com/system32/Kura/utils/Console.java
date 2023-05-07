package com.system32.Kura.utils;

public class Console {
    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void sendLog(String type, String message){
        System.out.println(Color.CYAN + "[" + type + "] " + Color.GREEN_BRIGHT + message);
    }

    public static void sendErrorLog(String type, String message){
        System.out.println(Color.CYAN + "[" + type + "] " + Color.RED + message);
    }
    public static void sendCustomLog(String typeColor, String type, String messageColor, String message){
        System.out.println(typeColor + "[" + type + "] " + messageColor + message);
    }
}
