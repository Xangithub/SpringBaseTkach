package com.yet.spring.core.beans;

import com.yet.spring.core.loggers.EventLogger;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
private  String filename;
private  File file;
    public FileEventLogger(java.lang.String filename) {
        this.filename = filename;
    }

    @java.lang.Override
    public void logEvent(Event event)  {
        try {

            FileUtils.writeStringToFile(file, event.getMsg() + "\n", true);
        }
        catch (IOException e )
        {
            System.out.println("Добавлени строки в файл провалено " + e);
        }

    }

    void init()  {
        this.file = new File(filename);

        if (file.exists() & !file.canWrite()) {

            throw new  IllegalArgumentException("Can't write to file " + filename);
        } else if(!file.exists()){
            try {
                file.createNewFile();
            } catch (java.lang.Exception exception) {
                throw new IllegalArgumentException("Can't create file", exception);
            }
        }

    }
}
