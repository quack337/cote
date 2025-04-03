package baekjoon.test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;

@SuppressWarnings("rawtypes")
public class TestUtils {

    public static String getTextFile(Class classObj, String path) throws IOException, URISyntaxException {
        return new String(Files.readAllBytes(Paths.get(classObj.getResource(path).toURI())));
    }

    public static String getTextFile(String path) throws IOException, URISyntaxException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    public static String callMain(Class classObj, MainMethod mainMethod, String inputFileName) throws Exception {
        System.setIn(classObj.getResourceAsStream(inputFileName));

        OutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        mainMethod.main(null);

        return out.toString().trim();
    }

    public static String callMain(MainMethod mainMethod, String inputData) throws Exception {
        System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));

        OutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        mainMethod.main(null);

        return out.toString().trim();
    }

    public static void callMain(MainMethod mainMethod, String inputData, String outputData) throws IOException {
        System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));

        OutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        mainMethod.main(null);

        String result = out.toString().trim();
        Assert.assertEquals(result, outputData);
    }
}