package com.scitotec.log4shell;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Log4jRecognizer(Main.class.getClassLoader()).version());
    }

}
