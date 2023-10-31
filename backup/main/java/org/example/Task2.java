package org.example;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;

public class Task2 {

    //TODO: Доработайте класс Tree и метод print который мы разработали на семинаре.
    // Ваш метод должен распечатать полноценное дерево директорий и файлов относительно корневой директории.
    public static void main(String[] args) {
        print(new File("."), "", true);
    }

    static void print(File file, String indent, boolean isLast){
        System.out.print(indent);
        if (isLast){
            System.out.print("└─");
            indent += "  ";
        }
        else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null) {
            return;
        }

        int subFilesTotal = 0;
        int subDirTotal = 0;
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory())
                subDirTotal++;
            else subFilesTotal++;
        }

        int subDirCounter = 0;
        int subFileCounter = 0;
        for (int i = 0; i < files.length; i++){
            Arrays.sort(files, new FileComparator());
            if (files[i].isDirectory()){
                subDirCounter++;
                print(files[i], indent, (subDirCounter == subDirTotal && i == files.length-1));
            }
            else{
                subFileCounter++;
                print(files[i], indent, subFileCounter == subFilesTotal);
            }
        }

    }

}
