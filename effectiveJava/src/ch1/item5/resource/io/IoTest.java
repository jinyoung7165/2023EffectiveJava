package ch1.item5.resource.io;

import java.io.IOException;

public abstract class IoTest {
    private static final String PATH = "effectiveJava/src/ch1/item5/resource/io/";
    private IoTest() {}
    public static void main(String[] args) throws IOException {
        String s = StringUtils.firstLineOfFile(PATH+"hi.txt", PATH+"out.txt");
        System.out.println(s);
    }
}
