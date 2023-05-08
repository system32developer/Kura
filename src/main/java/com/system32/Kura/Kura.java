package com.system32.Kura;

import com.system32.Kura.bot.Builder;
import com.system32.Kura.bot.CommandManager;
import com.system32.Kura.database.DatabaseManager;
import com.system32.Kura.utils.Color;
import com.system32.Kura.utils.Console;
import com.system32.Kura.utils.ResourcesManager;
import com.system32.Kura.utils.objects.Command;
import net.dv8tion.jda.api.JDA;
import org.simpleyaml.configuration.file.YamlFile;

import java.sql.Connection;
import java.util.LinkedList;


public class Kura {
    private static YamlFile config;
    private static YamlFile language;
    private static JDA jda;
    private static Connection connection;
    private static LinkedList<Command> commands;
    public static void main(String[] args) throws Exception {
        Console.clear();
        config = ResourcesManager.setupConfig();
        language = ResourcesManager.setupLanguage();
        if(config==null)
        {
            Console.sendLogNoConfig("Config", "ERROR", "Config file not loaded, stopping all process");
            return;
        }
        if(language==null)
        {
            Console.sendLogNoConfig("Language", "ERROR", "Language file not loaded, stopping all process");
            return;
        }

        Console.sendLog("Bot", "INFO", "My actual version is: " + Color.RED + config.getString("global.version"));
        if(config.contains("bot.token") && config.getString("bot.token").equals("default")){
            Console.sendLog("Config", "ERROR","Config file loaded, but you didn't change the token, please set it first!");
            return;
        }
        if(config.contains("database.name") && config.getString("database.name").equals("default")){
            Console.sendLog("Config", "ERROR", "Config file loaded, but you didn't change the database stuff, please set it first!");
            return;
        }
        Console.sendLog("Config", "INFO","Config file loaded, starting bot");

        connection = new DatabaseManager(config.getString("database.ip"), config.getInt("database.port"), config.getString("database.name"), config.getString("database.username"), config.getString("database.password")).getConnection();
        CommandManager.setupCommands();
        commands = CommandManager.getCommands();

        jda = Builder.build();

    }
    public static YamlFile getConfig(){
        return config;
    }
    public static YamlFile getLanguage(){
        return language;
    }
    public static JDA getJDA(){
        return jda;
    }
    public static Connection getConnection(){
        return connection;
    }
    public static LinkedList<Command> getCommands(){
        return commands;
    }
    public static java.awt.Color getColor(){
        return new java.awt.Color(48, 49, 54);
    }
}
