package com.yet.spring.core.loggers;

import com.yet.spring.core.beans.Event;
import com.yet.spring.core.loggers.EventLogger;

public class ConsoleEventLogger implements EventLogger {


    @java.lang.Override
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
