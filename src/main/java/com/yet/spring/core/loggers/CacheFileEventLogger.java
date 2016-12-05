package com.yet.spring.core.loggers;

import com.yet.spring.core.beans.Event;
import com.yet.spring.core.beans.FileEventLogger;

import  java.util.*;
import java.io.IOException;
//import java.io.File;


public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache;
    private String filename;
//    private File file;
    public CacheFileEventLogger(java.lang.String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
        this.cache = new ArrayList<Event>(cacheSize);
        this.filename= filename;
//        file = new File(filename);
    }

    @java.lang.Override
    public void logEvent(Event event) {
//        System.out.println("Кеш до добавления " + cache.size());
        if(cache.size() == cacheSize) {
            flushToFile();
            cache.clear();
        }
            cache.add(event);

//        System.out.println("Кеш ПОСЛЕ добавления " + cache.size());

    }


    private void flushToFile() {
        cache.stream().forEach(super::logEvent);

//
//        for (Event event :  cache ) {
//
//            try {
//
//                FileUtils.writeStringToFile(file, event.getMsg(), true);
//            }
//            catch (IOException e )
//            {
//                System.out.println("Добавлени строки в файл провалено " + e);
//            }
//
//        }
    }

//    void init()  {
//              if (file.exists() & !file.canWrite()) {
//            System.out.println("Cannot write file");
//                  try {
//                      throw new IOException("Cannot write file");
//                  } catch (IOException ioException) {
//                      ioException.printStackTrace();
//                  }
//              }
//    }

        void destroy(){
        if( !cache. isEmpty()) flushToFile();
    }

}
