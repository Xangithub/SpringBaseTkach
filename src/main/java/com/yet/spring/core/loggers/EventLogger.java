package com.yet.spring.core.loggers;
import java.io.IOException;;
import com.yet.spring.core.beans.Event;

public interface EventLogger {
    void logEvent(Event event);
}
