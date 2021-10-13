package com.file.fileMonitor.service.impl;

import com.file.fileMonitor.constant.FileMonitorConstant;
import com.file.fileMonitor.utility.FileOperationUtility;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.stream.Stream;

@Service
public class FileMonitorServiceImpl{

    /**
     * This function will read two files and generate count with CDC key word
     * This will read file after every 5 seconds
     */
    @Scheduled(fixedDelay = 10000, initialDelay = 6000)
    public void fileMonitor() throws IOException {

        File file1Object = new File((FileMonitorConstant.filePath + "/randomStringFile1"));
        File file2Object = new File((FileMonitorConstant.filePath + "/randomStringFile2"));

        FileOperationUtility fileWriterUtilityFirst = new FileOperationUtility(file1Object);
        Stream<String> lineStream1 = fileWriterUtilityFirst.readLineFromFile();

        long countFile1 = lineStream1.map(this::matchRegex).reduce(0, Integer::sum);

        FileOperationUtility fileWriterUtilitySecond = new FileOperationUtility(file2Object);
        Stream<String> lineStream2 = fileWriterUtilitySecond.readLineFromFile();

        long countFile2 = lineStream2.map(this::matchRegex).reduce(0, Integer::sum);

        FileOperationUtility finalResult = new
              FileOperationUtility(new File(FileMonitorConstant.filePath + "/search_results.log"));

        finalResult.writeToFile(FileMonitorConstant.file1 + "-" + countFile1);
        finalResult.writeToFile(FileMonitorConstant.file2 + "-" + countFile2);
    }

    private int matchRegex(String word) {
        int count = 0;
        Matcher matcher = FileMonitorConstant.CDS_PATTERN.matcher(word);
        while (matcher.find()) {
            count++;
        }
        return count;
    }

}
