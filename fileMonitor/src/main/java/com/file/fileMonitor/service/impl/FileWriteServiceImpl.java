package com.file.fileMonitor.service.impl;

import com.file.fileMonitor.constant.FileMonitorConstant;
import com.file.fileMonitor.utility.FileOperationUtility;
import com.file.fileMonitor.utility.StringUtility;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.Random;

@Service
public class FileWriteServiceImpl {

    /**
     * This function will generate random string and write into two files dynamically
     * This will write continously in file and taking pause of 10 seconf after every write
     */

    //@Scheduled(fixedDelay = 5000)
    public void writeFile() throws UnsupportedEncodingException {

        Random random = new Random();
        List<String> randomString = StringUtility.generateRandomString(random.nextInt(10));

        File file1Object = new File((FileMonitorConstant.filePath + "/randomStringFile1"));
        File file2Object = new File((FileMonitorConstant.filePath + "/randomStringFile2"));

        FileOperationUtility fileWriterUtilityFirst = new FileOperationUtility(file1Object);
        FileOperationUtility fileWriterUtilitySecond = new FileOperationUtility(file2Object);

        randomString.forEach(fileString -> {
            try {
                fileWriterUtilityFirst.writeToFile(fileString);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        List<String> randomStringSecond = StringUtility.generateRandomString(random.nextInt(10));

        randomStringSecond.forEach(fileString -> {
            try {
                fileWriterUtilitySecond.writeToFile(fileString);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Scheduled(fixedDelay = 5000)
    public void writeFileExtended() throws IOException {

        Random random = new Random();

        List<String> randomString = StringUtility.generateRandomString(random.nextInt(10));

        File file1Object = new File((FileMonitorConstant.filePath + "/randomStringFile1"));
        File file2Object = new File((FileMonitorConstant.filePath + "/randomStringFile2"));

        FileOperationUtility fileWriterUtilityFirst = new FileOperationUtility(file1Object);
        FileOperationUtility fileWriterUtilitySecond = new FileOperationUtility(file2Object);

        fileWriterUtilityFirst.writeToFile(randomString);

        List<String> randomStringSecond = StringUtility.generateRandomString(random.nextInt(10));
        fileWriterUtilitySecond.writeToFile(randomStringSecond);
    }
}
