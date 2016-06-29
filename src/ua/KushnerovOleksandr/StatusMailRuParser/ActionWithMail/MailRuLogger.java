package ua.KushnerovOleksandr.StatusMailRuParser.ActionWithMail;

import ua.KushnerovOleksandr.StatusMailRuParser.constants.Constants;

import java.io.IOException;

public class MailRuLogger implements Constants {

    public void mailRuLogger() {
        try {
            System.out.println("");
            System.out.println("------------------------Start programm-----------------------");
            System.out.println("------------------------" + time.format(date) + "-----------------------");
            writeToFile.writeToFile("");
            writeToFile.writeToFile("------------------------Start programm-----------------------");
            writeToFile.writeToFile("------------------------" + time.format(date) + "-----------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
        EmailList emailList1 = null;
        try {
            emailList1 = new EmailList("bin/emails.ini");
        } catch (IOException e) {
            e.printStackTrace();
        }
        EmailLog emails[] = new EmailLog[emailList1.lines.size()];

        for (int i = 0; i < emailList1.lines.size(); i++) {
            emails[i] = new EmailLog(emailList1.lines.get(i));
        }
        //сначала сохраняем статусы ящиков
        for (int i = 0; i < emails.length; i++) {
            emails[i].saveStatus();
        }
        //вечный цикл с сохранением изменений статусов массива ящиков
        while (true) {
            for (int i = 0; i < emails.length; i++) {
                if (emails[i].isChanged()) {
                    emails[i].saveStatus();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
