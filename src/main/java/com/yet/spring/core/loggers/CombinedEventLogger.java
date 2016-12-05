package com.yet.spring.core.loggers;

import com.yet.spring.core.beans.Event;

import java.util.Collection;


public class CombinedEventLogger implements EventLogger{
private Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<com.yet.spring.core.loggers.EventLogger> loggers) {
        this.loggers = loggers;
    }

    public void logEvent(Event event) {
        for (EventLogger logger : loggers) {
            logger.logEvent(event); //идём по коллекции логгеров и вызываем у каждого метод logEvent для event
        }
    }
}
