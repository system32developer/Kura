package com.system32.Kura.bot;

import com.system32.Kura.Kura;
import com.system32.Kura.commands.Help;
import com.system32.Kura.commands.Ping;
import com.system32.Kura.utils.Color;
import com.system32.Kura.utils.Console;
import com.system32.Kura.utils.objects.Command;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

import java.util.Arrays;
import java.util.LinkedList;

public class CommandManager {
    private static final LinkedList<Command> commands = new LinkedList<>();

    public static void setupCommands(){
        addCommands(
                new Help(),
                new Ping()
        );
    }

    private static void addCommands(Command ...command){
        commands.addAll(Arrays.asList(command));
    }
    public static void postCommands(String id, Guild guild){
        LinkedList<SlashCommandData> data = new LinkedList<>();

        commands.forEach(c->{
            data.add(c.getData());
        });

        guild.updateCommands().addCommands(data).queue();
        Console.sendLog("Bot-Commands", "INFO", Color.YELLOW_BOLD + Kura.getCommands().size() + Color.RESET + " Commands posted to " + Color.GREEN_BOLD + guild.getName());
    }
    public static LinkedList<Command> getCommands(){
        return commands;
    }

    public static LinkedList<String> getCommandsNames(){
        LinkedList<String> names = new LinkedList<>();
        commands.forEach(c->{
            names.add(c.getName());
        });
        return names;
    }

    public static Command getCommand(String name){
        for(Command c : commands){
            if(c.getName().equals(name)) return c;
        }
        return null;
    }
    public static Boolean hasCommand(String name){
        for(Command c : commands){
            if(c.getName().equals(name)) return true;
        }
        return false;
    }
}
