package com.system32.Kura.commands;

import com.system32.Kura.utils.objects.Command;
import com.system32.Kura.utils.objects.CommandCategory;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.util.List;

public class Ping extends Command {
    public Ping() {
        name = "ping";
        description = "Ping Command!";
        category = CommandCategory.UTILS;
        usage = "/ping";
        data = Commands.slash(name, description);
    }

    @Override
    protected void execute(SlashCommandInteractionEvent event, List<OptionMapping> options) {
        event.reply("Pong!").queue();
    }

}
