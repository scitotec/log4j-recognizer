package com.github.scitotec.log4jrecognizer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Nested
@DisplayName("log4j 1.2.x")
@Tag("log4j-1.2")
class Log4jRecognizer_Log4j1_2Test extends AbstractLog4jRecognizerTest {

    @Test
    void hasVersion1() {
        assertTrue(recognizer.hasVersion1());
    }

    @Test
    void versionIsNotRecognized() {
        assertNull(recognizer.version());
    }
}
