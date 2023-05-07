package com.system32.Kura.utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static com.system32.Kura.utils.Other.ExportResource;

public class ResourcesManager {

    public static Config setupConfig() throws Exception, InvocationTargetException, IOException {
        String folder = new File(".").getCanonicalPath();
        File conf = new File(folder, "/"+ "app.conf");
        if (!conf.exists()) {
            Console.sendLogNoConfig("Config", "INFO", "Config file not found, creating it");
            return ConfigFactory.parseFile(new File(ExportResource("/app.conf")));
        }else{
            Console.sendLogNoConfig("Config", "INFO", "Config file found, loading it");
            return ConfigFactory.parseFile(conf);
        }
    }
    public static Config setupLanguage() throws Exception, InvocationTargetException, IOException {
        String folder = new File(".").getCanonicalPath();
        File conf = new File(folder, "/"+ "lang.conf");
        if (!conf.exists()) {
            Console.sendLogNoConfig("Language", "INFO", "Lang file not found, creating it");
            return ConfigFactory.parseFile(new File(ExportResource("/lang.conf")));
        }else{
            Console.sendLogNoConfig("Language", "INFO", "Lang file found, loading it");
            return ConfigFactory.parseFile(conf);
        }
    }
}
