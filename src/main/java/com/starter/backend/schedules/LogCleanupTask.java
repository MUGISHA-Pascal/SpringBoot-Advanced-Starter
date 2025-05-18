package com.starter.backend.schedules;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Component
public class LogCleanupTask {
    private static final String LOG_DIR = "./";
    private static final String LOG_FILE_PREFIX  ="project.";
    private static final int RETENTION_DAYS = 30;
    @Scheduled(cron = "0 0 1 * * ?")
    public void cleanOldLogs(){
        File folder = new File(LOG_DIR);
        if(!folder.exists() || !folder.isDirectory()){
            return;
        }
        File[] files = folder.listFiles((dir,name)->name.startsWith(LOG_FILE_PREFIX)&&name.endsWith(".log"));
        if(files==null){
            return;
        }
        Instant cutoff = Instant.now().minus(RETENTION_DAYS, ChronoUnit.DAYS);
        for(File file : files){
            if(Instant.ofEpochMilli(file.lastModified()).isBefore(cutoff)){
              boolean deleted = file.delete();
              if(deleted){
                  System.out.println("Deleted file: " +file.getName());
              }
            }
        }
    }

}
