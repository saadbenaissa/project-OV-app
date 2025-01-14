package com.example.projectovapp;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageManager {
    private static Locale currentLocale = Locale.of("nl");

    public static void setLocale(Locale locale) {
        currentLocale = locale;
    }

    public  static ResourceBundle getBundle() {
        return ResourceBundle.getBundle("com.example.projectovapp.languages.messages", currentLocale);
    }
}