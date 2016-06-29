package ua.KushnerovOleksandr.StatusMailRuParser.constants;

import ua.KushnerovOleksandr.StatusMailRuParser.write.WriteToFile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface Constants {
    WriteToFile writeToFile = new WriteToFile();
    Date date = new Date();
    SimpleDateFormat time = new SimpleDateFormat();
    List<String> lines = new ArrayList<String>();
}
