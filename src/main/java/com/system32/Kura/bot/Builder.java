package com.system32.Kura.bot;

import com.system32.Kura.Kura;
import com.typesafe.config.Config;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class Builder {
    public static JDA build(){
        Config config = Kura.getConfig();
        JDABuilder builder = JDABuilder
                .createDefault(config.getString("bot.token"))
                .enableIntents(
                        GatewayIntent.GUILD_MEMBERS,
                        GatewayIntent.DIRECT_MESSAGE_REACTIONS,
                        GatewayIntent.DIRECT_MESSAGES,
                        GatewayIntent.MESSAGE_CONTENT,
                        GatewayIntent.GUILD_MESSAGES,
                        GatewayIntent.GUILD_PRESENCES,
                        GatewayIntent.GUILD_VOICE_STATES,
                        GatewayIntent.GUILD_VOICE_STATES
                );
        builder
                .setCompression(Compression.NONE)
                .setActivity(Activity.playing(config.getString("bot.activity")))
                .setMemberCachePolicy(MemberCachePolicy.ALL)
                .addEventListeners(

                )

                ;
        return builder.build();
    }
}
