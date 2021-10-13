package com.file.fileMonitor.constant;

import com.file.fileMonitor.FileMonitorApplication;

import java.io.File;
import java.util.regex.Pattern;

public class FileMonitorConstant {

    public static final String file1 = "randomStringFile1";
    public static final String file2 = "randomStringFile2";

    //public static final String filePath = "/Users/parth.shah/Doc/";
    public static final String filePath = FileMonitorApplication.HONE_DIR_PATH;

    File file1Object = new File((FileMonitorApplication.HONE_DIR_PATH + "/randomStringFile1"));
    File file2Object = new File((FileMonitorApplication.HONE_DIR_PATH + "/randomStringFile2"));

    //public static final Pattern CDS_PATTERN = Pattern.compile("^CDS$");
    public static final Pattern CDS_PATTERN = Pattern.compile("\\bCDS\\b");

    //public static final Pattern CDS_PATTERN = Pattern.compile("\bCDS\b");

}
