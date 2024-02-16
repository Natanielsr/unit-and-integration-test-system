package com.uaits.utils;
import com.google.gson.Gson;

public class Console {

    public static void Log(Object obj, ConsoleColor color){
        System.out.print(color.getColorCode());
        Log(obj);
    }
  
    public static void Log(Object obj){
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        System.out.println(json);
        System.out.print(ConsoleColor.DEFAULT.getColorCode());
    }
}
