package ch1.item5.resource.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public abstract class StringUtils {
    private StringUtils() {
    }

    //try-with-resources를 사용한다.
    public static String firstLineOfFile(String path, String fileName) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(path));
            FileOutputStream out = new FileOutputStream(fileName)){

            String s = reader.readLine();
            out.write(s.getBytes(), 0, s.length());

            return s;
        }
    }
}
