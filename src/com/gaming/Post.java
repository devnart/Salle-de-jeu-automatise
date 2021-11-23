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

    public int isSpotAvailable(List users, Main.Games game) {
        // if no user is available
        int post = game.postN1;
        System.out.println("Game before loop : " + game);
        for (Object user : users) {
            HashMap userGame = (HashMap) user;
            System.out.println("Game inside : " + game);
            if (userGame.get("post").equals(game.postN1) && !userGame.get("post").equals(game.postN2)) {
                System.out.println("postN2 - 0");
                post = game.postN2;
                break;
            } else if (userGame.get("post").equals(game.postN2) && !userGame.get("post").equals(game.postN1)) {
                System.out.println("postN1 - 1");
                post = game.postN1;
                break;
            } else if (!userGame.get("post").equals(game.postN1) && !userGame.get("post").equals(game.postN2)) {
                System.out.println("postN1 - 2");
                post = game.postN1;
            }
            else {
                System.out.println("No post");
                post = 0;
            }
        }
        return post;
    }


}
