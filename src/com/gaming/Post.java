package com.gaming;

import java.util.HashMap;
import java.util.List;

public class Post {

    public Boolean isAvailable(Object startTime,List users) {
        Boolean isAvailable = true;
        for (Object user : users) {
            HashMap userTime = (HashMap) user;
            if (userTime.get("start").equals(startTime)) {
                isAvailable = false;
                break;
            }
        }
        return isAvailable;
    }

    public Boolean isSpotAvailable(List users, Main.Games game) {
        System.out.println("Checking if spot is available");
        System.out.println("Users: " + users);
        System.out.println("Game: " + game);

        Boolean isAvailable = true;
        for (Object user : users) {
            HashMap userSpot = (HashMap) user;

        }
        return isAvailable;
    }
}
