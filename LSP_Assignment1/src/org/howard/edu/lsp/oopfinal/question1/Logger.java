package org.howard.edu.lsp.oopfinal;

public class Logger {
    private static Logger instance;
    private String log;

    // Private constructor to restrict instantiation from outside the class
    private Logger() {
        this.log = "";
    }

    // Public method to get the instance of the class
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void logMessage(String message) {
        this.log += message + "\n";
    }

    public String displayLog() {
        return("Log:\n" + log);
    }
}
