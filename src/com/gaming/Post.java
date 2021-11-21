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
}
