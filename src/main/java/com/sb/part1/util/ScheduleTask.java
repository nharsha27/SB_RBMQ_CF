package com.sb.part1.util;

import javafx.beans.binding.Bindings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class ScheduleTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  //  @Value("${job.schedules}")
  //  private String value;

    //  @Scheduled(fixedRate = @Value("${job.schedules}"))
    @Scheduled(cron = "${job.schedules}")
    public void reportCurrentTime() {

        log.info("The time is now {}", dateFormat.format(new Date()));
    }
}
