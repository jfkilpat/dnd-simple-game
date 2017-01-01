package com.playground.util;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class StringResources {
    private static String loadResource(String resourcePath) {
        try {
            return FileUtils.readFileToString(new ClassPathResource(resourcePath).getFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String monsterIndexJson = loadResource("MonsterIndex.json");
}
