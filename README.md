# messiva

![GitHub release (with filter)](https://img.shields.io/github/v/release/suk-ws/messiva?style=for-the-badge&labelColor=%23f5f5f5&color=orange)
![Maven metadata URL](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fmvn.sukazyo.cc%2Freleases%2Fcc%2Fsukazyo%2Fmessiva%2Fmaven-metadata.xml&style=for-the-badge&label=Workshop%20MVN%20Packager&labelColor=%23f5f5f5)
![Static Badge](https://img.shields.io/badge/tests-not_available_yet-moccasin?style=for-the-badge&labelColor=gainsboro)

The Java logger library let you can take a full control.

from Sukazyo Workshop.

## Goal (and the situation currently)

The goal of messiva is make a library that you can not only
do logging but do CLI output even input with it.

This project is in a very early stage. (Maybe I don't have to
many efforts to develop it currently, so it will be in a very
early stage for a long time -- if there's no any one's help,
I may only make the part I need to use.)

## How to use

Download it from the [releases](https://github.com/suk-ws/messiva/releases)

or import it from [Sukazyo Workshop MVN Packager](https://mvn.sukazyo.cc/#/releases/cc/sukazyo/messiva):

```groovy
repositories {
	maven { name "-ws", url "https://mvn.sukazyo.cc/releases" }
}
dependencies {
	implementation "cc.sukazyo:messiva:0.2.0"
}
```

Set up your own logger:
```java
import cc.sukazyo.messiva.logger.Logger;
import cc.sukazyo.messiva.appender.impl.ConsoleAppender;
import cc.sukazyo.messiva.formatter.SimpleFormatter;

// currently only implementation within messiva
class MyLogger {
	public Logger myLogger = new Logger(new ConsoleAppender(new SimpleFormatter()));
}
```

Or you can freely extends and implements the interfaces or Logger
class to customizing make your own logger.

## Library Used

- **[SpotBugs](https://github.com/spotbugs/spotbugs)** by Github,
  provided the null-safety Java programming experience.
