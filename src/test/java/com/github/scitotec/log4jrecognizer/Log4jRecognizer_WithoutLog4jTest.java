package com.github.scitotec.log4jrecognizer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Nested
@DisplayName("without log4j")
@Tag("no-log4j")
class Log4jRecognizer_WithoutLog4jTest extends AbstractLog4jRecognizerTest {

    @Test
    void hasNoVersions() {
        assertFalse(recognizer.hasVersion1());
        assertFalse(recognizer.hasVersion2());
    }

    @Test
    void versionIsNotRecognized() {
        assertNull(recognizer.version());
    }
}
