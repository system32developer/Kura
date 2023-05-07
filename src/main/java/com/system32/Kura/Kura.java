package com.system32.Kura;

import com.system32.Kura.bot.Builder;
import com.system32.Kura.database.DatabaseManager;
import com.system32.Kura.utils.Color;
import com.system32.Kura.utils.Console;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import net.dv8tion.jda.api.JDA;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;

import static com.system32.Kura.utils.Other.ExportResource;

public class Kura {
    private static Config config;
    private static JDA jda;
    private static Connection connection;
    public static void main(String[] args) throws Exception, InvocationTargetException {
        Console.clear();
        String folder = new File(".").getCanonicalPath();
        File conf = new File(folder, "/"+ "app.conf");

        if (!conf.exists()) {
            Console.sendLog("CONFIG", "Config file not found, creating it");
            config = ConfigFactory.parseFile(new File(ExportResource("/app.conf")));
        }else{
            Console.sendLog("CONFIG", "Config file found, loading it");
            config = ConfigFactory.parseFile(conf);
        }


        if(config==null)
        {
            Console.sendErrorLog("CONFIG", "Config file not loaded, stopping all process");
            return;
        }
        Console.sendLog("BOT", "My actual version is: " + Color.RED + config.getString("global.version"));
        if(config.hasPath("bot.token") && config.getString("bot.token").equals("default")){
            Console.sendErrorLog("CONFIG", "Config file loaded, but you didn't change the token, please set it first!");
            return;
        }
        if(config.hasPath("database.name") && config.getString("database.name").equals("default")){
            Console.sendErrorLog("CONFIG", "Config file loaded, but you didn't change the database stuff, please set it first!");
            return;
        }
        Console.sendLog("CONFIG", "Config file loaded, starting bot");

        connection = new DatabaseManager(config.getString("database.ip"), config.getInt("database.port"), config.getString("database.name"), config.getString("database.username"), config.getString("database.password")).getConnection();

        jda = Builder.build();

    }
    public static Config getConfig(){
        return config;
    }
    public static JDA getJDA(){
        return jda;
    }
    public static Connection getConnection(){
        return connection;
    }
}
