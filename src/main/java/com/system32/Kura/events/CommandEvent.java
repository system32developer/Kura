package com.system32.Kura.events;

import com.system32.Kura.Kura;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandEvent extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!event.getChannelType().isGuild()) return;
        if (event.getUser().isBot()) return;
        if(!event.getChannel().getType().equals(ChannelType.TEXT)) return;
        Kura.getCommands().forEach(c ->{
            if (c.getName().equals(event.getName())) {
                c.run(event, event.getOptions());
            }
        });
    }
}
