package com.file.fileMonitor.utility;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class StringUtility {

    private static final String CDS = "CDS";

    public static List<String> generateRandomString(int noOfString) throws UnsupportedEncodingException {
        List<String> stringList = new ArrayList<>(noOfString);
        for (int i = 0; i < noOfString; i++) {
            if (i % 2 == 0) {
                stringList.add(CDS);
            } else {
                stringList.add(generateWord());
            }
        }
        Collections.shuffle(stringList);
        return stringList;
    }

    private static  String generateWord() throws UnsupportedEncodingException {
        int leftLimit = 65; // letter 'A'
        int rightLimit = 90; // letter 'Z'
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
