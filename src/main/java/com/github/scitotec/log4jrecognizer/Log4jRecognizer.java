package com.github.scitotec.log4jrecognizer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Log4jRecognizer {
    private final ClassLoader classLoader;

    public Log4jRecognizer(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    /**
     * Tries to resolve the version of log4j if it exists. Not every log4j
     * version has version information. Therefore, this information is not
     * sufficient to tell if log4j is available or not.
     *
     * @return the version string of log4j or {@code null}
     *
     * @see #hasVersion1()
     * @see #hasVersion2()
     */
    public String version() {
        final Class<?> versionClass = getVersionClass();
        if (versionClass == null) return null;
        final Method getProductString;
        try {
            getProductString = versionClass.getMethod("getProductString");
        } catch (NoSuchMethodException e) {
            return invocationError(e.getMessage());
        }
        try {
            return (String) getProductString.invoke(null);
        } catch (IllegalAccessException e) {
            return invocationError(e.getMessage());
        } catch (InvocationTargetException e) {
            return invocationError(e.getMessage());
        }
    }

    /**
     * Determines if log4j 1.x is available.
     *
     * @return {@code true} if log4j 1.x classes are found
     */
    public boolean hasVersion1() {
        return classExists("org.apache.log4j.Appender");
    }

    /**
     * Determines if log4j 2.x is available.
     *
     * @return {@code true} if log4j 2.x classes are found
     */
    public boolean hasVersion2() {
        return getVersionClass() != null || classExists("org.apache.logging.log4j.core.Appender");
    }

    private boolean classExists(String classFqdn) {
        try {
            Class.forName(classFqdn, true, classLoader);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    private Class<?> getVersionClass() {
        final Class<?> versionClass;
        try {
            versionClass = Class.forName("org.apache.logging.log4j.core.Version", true, classLoader);
        } catch (ClassNotFoundException e) {
            return null;
        }
        return versionClass;
    }

    private String invocationError(String message) {
        return "log4 2.x found - error resolving version: " + message;
    }
}
