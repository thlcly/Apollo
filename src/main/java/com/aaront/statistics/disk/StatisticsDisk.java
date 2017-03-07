package com.aaront.statistics.disk;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author tonyhui
 * @since 17/3/6
 */
public class StatisticsDisk {
    public static void main(String[] args) throws IOException {

        StatisticsDisk sd = new StatisticsDisk();
        String path = sd.stdin("input folder for statistics: ");
        if (path.startsWith("~")) {
            String userDir = sd.getSystemProp("user.home");
            path = path.replace("~", userDir);
        }
        File file = new File(path);
        if (!file.exists()) throw new IllegalArgumentException("file not exist");
        if (file.isFile()) {
            System.out.print("[" + file.getTotalSpace() + " " + file.getCanonicalPath() + "]");
            return;
        }
        sd.outputDiskSpace(file);
    }

    private String stdin(String tips) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(tips);
        return scanner.next();
    }

    private void outputDiskSpace(File file) throws IOException {
        if (file == null) throw new NullPointerException();
        if (!file.isDirectory()) return;

        List<String> results = execute(file.getCanonicalPath());
        System.out.println(results);
        File[] subFiles = file.listFiles();
        if (subFiles == null) return;
        for (File subFile : subFiles) {
            outputDiskSpace(subFile);
        }
    }

    private List<String> execute(String path) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("du -sh " + path);
        InputStreamReader ir = new InputStreamReader(process.getInputStream());
        BufferedReader input = new BufferedReader(ir);
        String line;
        List<String> results = new ArrayList<>();
        while ((line = input.readLine()) != null) {
            results.add(line);
        }
        return results;
    }

    private String getSystemProp(String key) {
        Properties props = System.getProperties();
        return props.getProperty(key);
    }

}
