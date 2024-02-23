package com.uaits.utils;
import com.google.gson.Gson;

public class Console {

    public static void Log(Object obj){
        Log(obj, false);
    }

    public static void LogLn(){
        Log("", false);
    }

    public static void LogInLine(Object obj){
        Log(obj, true);
    }

    public static void LogColor(Object obj, ConsoleColor color){
        System.out.print(color.getColorCode());
        Log(obj, false);
    }

    public static void Log(Object obj, boolean inLine){
        Gson gson = new Gson();
        String json = gson.toJson(obj);

        if(inLine)
            System.out.print(json);
        else {
            System.out.println(json);
        }

        System.out.print(ConsoleColor.DEFAULT.getColorCode());
    }
}
