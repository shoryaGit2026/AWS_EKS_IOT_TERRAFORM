package com.leave.LeaveService.Interview2026.FileReading;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class ReadAllLineList {

    public static void main(String[] args) throws IOException {

        Path path = Path.of("C:/Santosh/Files/Employee.csv");

        List<String> lines = Files.readAllLines(path);
        System.out.println(lines);

        /*Read Large File*/

        Path pth = Path.of("C:/Santosh/Files/Employee.csv");
        Stream<String> record=Files.lines(pth);
        record.forEach(System.out::println);

        /*Read file using Buffer reader*/
        try(BufferedReader br = Files.newBufferedReader(Path.of("C:/Santosh/Files/Employee.csv")) )
        {
                String line="";
                while((line=br.readLine())!=null)
            {
                System.out.println(line);
            }
        }



    }
}
