package ua.KushnerovOleksandr.StatusMailRuParser.ActionWithMail;

import ua.KushnerovOleksandr.StatusMailRuParser.constants.Constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class EmailList implements Constants {
    private String emails;

    public EmailList(String fileNameEmailsList) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileNameEmailsList));
        while ((emails = reader.readLine()) != null) {
            lines.add(emails);
        }
    }
}
