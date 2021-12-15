package com.github.scitotec.log4jrecognizer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Log4jRecognizer {
    private final ClassLoader classLoader;

    public Log4jRecognizer(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

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

    public boolean hasVersion1() {
        try {
            Class.forName("org.apache.log4j.Appender", true, classLoader);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public boolean hasVersion2() {
        return getVersionClass() != null;
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
