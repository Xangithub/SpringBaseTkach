package com.yet.spring.core;

import com.yet.spring.core.beans.Client;
import com.yet.spring.core.beans.Event;
import com.yet.spring.core.beans.EventType;
import com.yet.spring.core.loggers.CombinedEventLogger;
import com.yet.spring.core.loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {
    private Client client;
    private EventLogger defaultEventLogger;
    private Map<EventType, EventLogger> loggerMap;


    public App(Client client, EventLogger defaultEventLogger, Map<EventType, EventLogger> loggerMap) {
        this.client = client;
        this.defaultEventLogger = defaultEventLogger;
        this.loggerMap = loggerMap;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = context.getBean(App.class);

        EventLogger combinedEventLogger = context.getBean(CombinedEventLogger.class);

        Event event = context.getBean(Event.class);
        app.logEvent(EventType.ERROR, event, "Eto ustanovka 1");
        event = context.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "Eto ustanovka 2");
        event = context.getBean(Event.class);
        app.logEvent(EventType.ERROR, event, "Eto ustanovka 3");
        event = context.getBean(Event.class);
        app.logEvent(EventType.ERROR, event, "Eto ustanovka 4");
        event = context.getBean(Event.class);
        app.logEvent(null, event, "Eto ustanovka 5");
        context.close();
    }


    private void logEvent(EventType type, Event event, String msg) {

        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
        event.setEventType(type); // как связан  type и logger ? logger это объект комбайна значит по типу должен быть возвращен объект обработки...

        EventLogger logger = loggerMap.get(type);

        if (null == type) logger = defaultEventLogger;

        logger.logEvent(event);


    }

}
