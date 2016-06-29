package ua.KushnerovOleksandr.StatusMailRuParser.ActionWithMail;

import ua.KushnerovOleksandr.StatusMailRuParser.write.WriteToFile;

import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;


public class EmailLog {
    private boolean lastStatus; //последний сохраненный статус
    private String mail; //ящик


    public EmailLog(String mail) {
        this.mail = mail;
        this.lastStatus = isOnline();
    }

    //сохраняем статус в конец файла
    public void saveStatus() {
        WriteToFile writeToFile = new WriteToFile();
        try {
            //открываем файл лога
            //готовим строку для записи в конец файла
            String s = "";
            s +="Email: "+ mail + " | Status: ";
            if (this.isOnline()) {
                s += "ONLINE in ";
            } else {
                s += "OFFLINE in ";
            }
            LocalDateTime dt = LocalDateTime.now();
            s += dt.getHour() + ":" + dt.getMinute() + ":" + dt.getMinute() + " " + dt.getDayOfMonth() + "." + dt.getMonth().getValue() + "." + dt.getYear();
            //записываем строку
            System.out.println("");
            System.out.println(s + System.lineSeparator());
            System.out.println("--------------------------------------------------------------");
            writeToFile.writeToFile("");
            writeToFile.writeToFile(s + System.lineSeparator());
            writeToFile.writeToFile("--------------------------------------------------------------");

        } catch (Exception ex) {
            System.out.println("File Not Found!!!");
        }
    }

    public boolean isChanged() {
        boolean ret = false;
        //проверяем изменение статуса
        if (isOnline() != this.lastStatus) {
            ret = true;
            this.lastStatus = isOnline(); //изменяем статус на новый
        } else
            ret = false;
        return ret;
    }

    private boolean isOnline() {
        //проверяем онлайн ящика
        boolean ret = false;
        try {
            //получаем текст результата запроса
            InputStream is = new URL("http://status.mail.ru/batch.js?" + this.mail).openConnection().getInputStream();
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            String statusText = new String(bytes);
            is.close();

            //получаем текущий статус из текста запроса
            if (statusText.contains("1"))
                ret = true;
        } catch (Exception e) {
            System.out.println("MalformedURLException");
        }
        return ret;
    }
}
