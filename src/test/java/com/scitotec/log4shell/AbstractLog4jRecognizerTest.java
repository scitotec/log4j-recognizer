package com.scitotec.log4shell;

import org.junit.jupiter.api.BeforeEach;

abstract class AbstractLog4jRecognizerTest {

    protected Log4jRecognizer recognizer;

    @BeforeEach
    void setUp() {
        recognizer = new Log4jRecognizer(AbstractLog4jRecognizerTest.class.getClassLoader());
    }

}