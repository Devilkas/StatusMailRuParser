package ua.KushnerovOleksandr.StatusMailRuParser;

import ua.KushnerovOleksandr.StatusMailRuParser.ActionWithMail.MailRuLogger;

/**
 * @author Kushnerov Oleksanrd
 */
public class StartProgram {
    public static void main(String[] args) {
        MailRuLogger logger = new MailRuLogger();
        logger.mailRuLogger();
    }
}
