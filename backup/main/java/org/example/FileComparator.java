package org.example;

import java.io.File;
import java.util.Comparator;

public class FileComparator implements Comparator<File> {

    @Override
    public int compare(File o1, File o2) {
        if (o1.isDirectory() && o2.isFile()) return -1;
        if (o1.isFile() && o2.isDirectory()) return 1;
        return 0;
    }

}
