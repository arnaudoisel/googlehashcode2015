package fr.pda.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Arnaud on 09/03/15.
 */
public class FileReader {

    final static Charset ENCODING = StandardCharsets.UTF_8;

    void readLargerTextFile(String aFileName) throws IOException {
        Path path = Paths.get(aFileName);
        try (Scanner scanner =  new Scanner(path, ENCODING.name())){
            while (scanner.hasNextLine()){
                //process each line in some way
                log(scanner.nextLine());
            }
        }
    }

    private static void log(Object aMsg){
        System.out.println(String.valueOf(aMsg));
    }

}
