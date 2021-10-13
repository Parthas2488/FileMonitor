package com.file.fileMonitor.utility;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

public class FileOperationUtility {

    private final File file;

    public FileOperationUtility(File file) {
        this.file = file;
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
            }
            System.out.println(file.getAbsolutePath());
        }
    }

    public void writeToFile(String word) throws IOException {
        Files.write(Paths.get(file.getAbsolutePath()), (word+"\n").getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
    }

    public void writeToFile(List<String> words) throws IOException {

        for (int i = 0; i < words.size(); i++) {
            Files.write(Paths.get(file.getAbsolutePath()), (words.get(i) + ",").
                    getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);

            if (i != 0 && i % 3 == 0) {
                Files.write(Paths.get(file.getAbsolutePath()), ("\n").
                        getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            }
        }
    }

    public Stream<String> readLineFromFile() throws IOException {
        if (!file.exists()) {
            return Stream.of("");
        }
        return Files.lines(Paths.get(file.getAbsolutePath()), StandardCharsets.UTF_8);
    }
}
