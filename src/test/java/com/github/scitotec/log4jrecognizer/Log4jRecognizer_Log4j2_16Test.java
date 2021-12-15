package com.github.scitotec.log4jrecognizer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Nested
@DisplayName("log4j 2.16.x")
@Tag("log4j-2.16")
class Log4jRecognizer_Log4j2_16Test extends AbstractLog4jRecognizerTest {

    @Test
    void hasVersion2() {
        assertTrue(recognizer.hasVersion2());
    }

    @Test
    void versionIsRecognized() {
        final String actual = recognizer.version();
        assertEquals("Apache Log4j Core 2.16.0", actual);
    }
}
