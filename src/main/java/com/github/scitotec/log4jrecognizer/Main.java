package com.github.scitotec.log4jrecognizer;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Log4jRecognizer(Main.class.getClassLoader()).version());
    }

}
