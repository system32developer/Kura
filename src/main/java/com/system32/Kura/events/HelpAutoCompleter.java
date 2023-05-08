package com.system32.Kura.events;

import com.system32.Kura.bot.CommandManager;
import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command;

import java.util.List;

import java.util.stream.Stream;

public class HelpAutoCompleter extends ListenerAdapter {
    private final String[] words = CommandManager.getCommandsNames().toArray(new String[0]);
    @Override
    public void onCommandAutoCompleteInteraction(CommandAutoCompleteInteractionEvent event){
        if(event.getName().equals("help") && event.getFocusedOption().getName().equals("command")){
            List<Command.Choice> options = Stream.of(words)
                    .filter(word -> word.startsWith(event.getFocusedOption().getValue()))
                    .map(word -> new Command.Choice(word, word)).toList();
            event.replyChoices(options).queue();
        }
    }
}
