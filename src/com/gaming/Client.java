package com.gaming;

import java.util.*;

public class Client {

    private String name;
    private int post;
    private String start;
    private int duration;
    private String gameName;
    private int amount;


    List <HashMap> users= new ArrayList();
    int number = 1;

    public void addClient(){


        if(users.size() < 1){
            newClient();

        } else if (users.size() < 3){
            System.out.print("No more post available new client will wait in the lobby \n");
            newClient();
            System.out.print("You are number " +  number + " in the queue \n");
            number++;
        } else {
            System.out.print("No more post available\n");
        }
    }

    public void newClient(){
        HashMap client = new HashMap();
        Post spot = new Post();


        Random rand = new Random();
        int upperbound = 10000;
        int ref = rand.nextInt(upperbound);
        Scanner scanner = new Scanner(System.in);	//Scanner declaration

        System.out.print("Name : \n");
        name = scanner.nextLine();

        System.out.print("post : \n");
        post = scanner.nextInt();

        // Consume newline left-over
        scanner.nextLine();

        do {
            System.out.print("start : \n");
            start = scanner.nextLine();

            if (!spot.isAvailable(start,users)) {
                System.out.println("Spot is reserved choose another time");
            }
        }while (!spot.isAvailable(start,users));


        System.out.print("duration : \n");
        duration = scanner.nextInt();

        scanner.nextLine();

        System.out.print("gameName : \n");
        gameName = scanner.nextLine();


        switch (duration) {
            case 30 : amount = 5; break;
            case 1 : amount = 10; break;
            case 2 : amount = 18; break;
            case 5 : amount = 40; break;
            case 9 : amount = 65; break;
        }

        client.put("name",name);
        client.put("post",post);
        client.put("start",start);
        client.put("duration",duration);
        client.put("gameName",gameName);
        client.put("ref",ref);
        client.put("amount",amount);

        users.add(client);


    }

    public void show(){
        System.out.print("clients : \n" + users + "\n");
    }

    public int getTotalAmount() {
        int total = 0;
        for (HashMap client : users) {
            total += (int) client.get("amount");
        }
        return total;
    }


}
