package com.leave.LeaveService.Interview2026.FileReading;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class ReadCsvFile {

    public static void main(String[] args) throws IOException {

        Path file = Path.of("C:/Santosh/Files/Employee.csv");


        System.out.println(file.getFileName());
        System.out.println(Files.size(file));
        try(Stream<String> lines = Files.lines(file) )
        {

            lines.forEach(System.out::println);
        }
    }


}
