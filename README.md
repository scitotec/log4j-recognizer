# log4j-recognizer

A utility to look for log4j in the currently running JVM
([CVE-2021-44228 (Log4Shell)](https://www.cve.org/CVERecord?id=CVE-2021-44228)).

This is useful for systems that allow plugins to introduce their own jars.
Therefore, you can find if someone brought
log4j in a dangerous version.

## Usage

Just instantiate `Log4jRecognizer` with your desired class loader and use its
methods, e.g.:

```java
import com.github.scitotec.log4jrecognizer.Log4jRecognizer;

public class Main {
    public static void main(String[] args) {
        var rec = new Log4jRecognizer(Main.class.getClassLoader());
        System.out.println(rec.hasVersion1());
        System.out.println(rec.hasVersion2());
        System.out.println(rec.version());
    }
}
```

## Installation

Declare log4j-recognizer as a dependency. This varies depending on your build
tool.

### Maven

```xml
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>

    <dependencies>
        <dependency>
            <groupId>com.github.scitotec</groupId>
            <artifactId>log4j-recognizer</artifactId>
            <version>1.0.2</version>
        </dependency>
    </dependencies>
```

### Gradle

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
dependencies {
    implementation 'com.github.scitotec:log4j-recognizer:1.0.2'
}
```
