package com.gaming;

import java.time.LocalTime;
import java.util.*;

public class Post {

    // return max end time
    public LocalTime getMaxEndTime(List users) {
        LocalTime minEndTime = LocalTime.of(0, 0);
        for (Object user : users) {
            HashMap us = (HashMap) user;
            if (LocalTime.parse(us.get("end").toString()).isAfter(minEndTime)) {
                minEndTime = LocalTime.parse(us.get("end").toString());
                System.out.println("In Time is " + minEndTime);
            }
        }
        return minEndTime;
    }


    public LocalTime isAvailable(Object startTime, List users, Main.Games game) {

        LocalTime start = LocalTime.parse(startTime.toString()) ;

        for (Object user : users) {
            HashMap us = (HashMap) user;
            if (us.get("gameName").equals(game)) {
                LocalTime end = LocalTime.parse(us.get("end").toString()) ;

                if (start.isAfter(end)) {
                    return start;
                } else {
                    start = end;
                    if (start.equals(LocalTime.parse("18:00"))) {
                        System.out.println("No more games today");
                        System.exit(0);
                    }
                }
            }
        }return start;
        }


}
