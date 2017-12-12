package com;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by jsst_ on 12/8/2017.
 */
public class lambdaTest {
    public static void main(String[] args) {
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };

        // using Lambda
        FileFilter lambdaFileFile = (File pathname) -> pathname.getName().endsWith(".java");

        File[] files = new File("E:\\Projects\\SbtLearning\\spring_sample_java\\src\\main\\java").listFiles(lambdaFileFile);
        for (File file:files
             ) {
            System.out.println(file.getName());
        }

    }
}
