package com.system32.Kura.events;

import com.system32.Kura.Kura;
import com.system32.Kura.bot.CommandManager;
import com.system32.Kura.utils.Color;
import com.system32.Kura.utils.Console;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BotReadyEvent extends ListenerAdapter {
    @Override
    public void onReady(ReadyEvent event){
        String id = Kura.getConfig().getString("global.guild");
        Guild guild =  Kura.getJDA().getGuildById(id);
        if(guild==null || id.equals("default")){
            Console.sendLog("Bot-Commands", "ERROR", "Guild ID not found in app.conf, can't post commands.");
            return;
        }
        Console.sendLog("Bot-Commands", "INFO", Color.YELLOW_BOLD + Kura.getCommands().size() + Color.RESET + " Commands Loaded!");
        Console.sendLog("Bot-Commands", "INFO", "Trying to post Commands to " + Color.GREEN_BOLD + guild.getName());
        CommandManager.postCommands(id, guild);
    }
}
