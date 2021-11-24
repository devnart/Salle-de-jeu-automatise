package com.gaming;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

public class Post {

    public LocalTime isAvailable(Object startTime, List users, Main.Games game) {
        LocalTime start = LocalTime.parse(startTime.toString()) ;


        for (Object user : users) {
            HashMap us = (HashMap) user;
            if (us.get("gameName").equals(game)) {
                System.out.println("Time inside : " + startTime);
                System.out.println("user time inside : " + us.get("end"));

                LocalTime end = LocalTime.parse(us.get("end").toString()) ;

                if (start.isAfter(end)) {
                    System.out.println("Time is after");
                    return start;
                } else {
                    System.out.println("Time is before");
                    start = end;
                    return start;
                }
            }
        }return start;
        }


}
