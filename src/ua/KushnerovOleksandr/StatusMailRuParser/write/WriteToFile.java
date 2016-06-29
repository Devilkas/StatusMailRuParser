package ua.KushnerovOleksandr.StatusMailRuParser.write;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class WriteToFile {
    private static final String FILE_NAME = "logs";
    private static final boolean TO_END_FILE = true;
    private static final String CHARSET = "UTF-8";

    public void writeToFile(String line) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME + ".log", TO_END_FILE);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, CHARSET);
             PrintWriter writer = new PrintWriter(outputStreamWriter)) {
            writer.println(line);
        }
    }
}


