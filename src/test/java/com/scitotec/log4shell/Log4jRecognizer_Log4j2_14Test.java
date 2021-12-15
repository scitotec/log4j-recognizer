package com.scitotec.log4shell;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Nested
@DisplayName("log4j 2.14.x")
@Tag("log4j-2.14")
class Log4jRecognizer_Log4j2_14Test extends AbstractLog4jRecognizerTest {

    @Test
    void hasVersion2() {
        assertTrue(recognizer.hasVersion2());
    }

    @Test
    void versionIsRecognized() {
        final String actual = recognizer.version();
        assertEquals("Apache Log4j Core 2.14.1", actual);
    }
}
