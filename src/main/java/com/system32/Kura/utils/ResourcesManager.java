package com.system32.Kura.utils;

import org.simpleyaml.configuration.file.YamlFile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static com.system32.Kura.utils.Other.ExportResource;

public class ResourcesManager {

    public static YamlFile setupConfig() throws Exception, InvocationTargetException, IOException {
        String folder = new File(".").getCanonicalPath();
        File conf = new File(folder, "/"+ "config.yml");
        if (!conf.exists()) {
            Console.sendLogNoConfig("Config", "INFO", "Config file not found, creating it");
            return new YamlFile(new File(ExportResource("/config.yml")));
        }else{
            Console.sendLogNoConfig("Config", "INFO", "Config file found, loading it");
            return new YamlFile(conf);
        }
    }
    public static YamlFile setupLanguage() throws Exception, InvocationTargetException, IOException {
        String folder = new File(".").getCanonicalPath();
        File conf = new File(folder, "/"+ "lang.yml");
        if (!conf.exists()) {
            Console.sendLogNoConfig("Language", "INFO", "Lang file not found, creating it");
            return new YamlFile(new File(ExportResource("/lang.yml")));
        }else{
            Console.sendLogNoConfig("Language", "INFO", "Lang file found, loading it");
            return new YamlFile(conf);
        }
    }
}
