package com.system32.Kura.utils.objects;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

import java.util.List;


public abstract class Command {

    protected String name = "null";
    protected String description = "no description available";
    protected String usage = "no usage provided";
    protected CommandCategory category = null;
    protected SlashCommandData data = null;

    public Command() {
    }

    protected abstract void execute(SlashCommandInteractionEvent event, List<OptionMapping> options);;

    public final void run(SlashCommandInteractionEvent event, List<OptionMapping> options) {
        execute(event, options);
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public CommandCategory getCategory() {
        return category;
    }

    public String getUsage(){
        return usage;
    }

    public SlashCommandData getData() {
        return data;
    }
}
