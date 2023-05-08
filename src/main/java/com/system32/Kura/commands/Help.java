package com.system32.Kura.commands;

import com.system32.Kura.Kura;
import com.system32.Kura.bot.CommandManager;
import com.system32.Kura.utils.objects.Command;
import com.system32.Kura.utils.objects.CommandCategory;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.util.List;

public class Help extends Command {

    public Help() {
        name = "help";
        description = "Help Command!";
        category = CommandCategory.UTILS;
        usage = "/help <command>";
        data = Commands.slash(name, description).addOption(OptionType.STRING, "command", "The command you want to know about", true, true);
    }

    @Override
    protected void execute(SlashCommandInteractionEvent event, List<OptionMapping> options) {
        String command = options.get(0).getAsString();

        if(!CommandManager.hasCommand(command)){
            event.reply("Command not found!").setEphemeral(true).queue();
            return;
        }

        Command c = CommandManager.getCommand(command);
        EmbedBuilder eb = new EmbedBuilder();
        eb.setAuthor("Help for " + c.getName(), null, event.getJDA().getSelfUser().getAvatarUrl());
        eb.setDescription(c.getDescription());
        eb.addField("Category", c.getCategory().toString(), true);
        eb.addField("Usage", c.getUsage(), true);
        eb.setFooter("<> - Required | [] - Optional");
        eb.setColor(Kura.getColor());
        event.replyEmbeds(eb.build()).queue();
    }

}
