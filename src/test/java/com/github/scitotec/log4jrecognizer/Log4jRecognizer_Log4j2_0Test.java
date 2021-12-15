package com.github.scitotec.log4jrecognizer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Nested
@DisplayName("log4j 2.0.x")
@Tag("log4j-2.0")
class Log4jRecognizer_Log4j2_0Test extends AbstractLog4jRecognizerTest {

    @Test
    void hasVersion2() {
        assertTrue(recognizer.hasVersion2());
    }

    @Test
    void versionIsNotRecognized() {
        final String actual = recognizer.version();
        assertNull(actual);
    }
}
