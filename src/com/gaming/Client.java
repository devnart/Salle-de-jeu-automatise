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


        if(users.size() < 7){
            newClient();

        } else if (users.size() < 17){
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

        System.out.print("Game Name : \n");

        System.out.print("1." + Main.Games.PES.label + "\n");
        System.out.print("2." + Main.Games.FIFA.label + "\n");
        System.out.print("3." + Main.Games.COD.label + "\n");
        System.out.print("4." + Main.Games.GOW.label + "\n");
        System.out.print("5." + Main.Games.FORZA.label + "\n");
        System.out.print("6." + Main.Games.RDR.label + "\n");
        System.out.print("7." + Main.Games.MARIO.label + "\n");

        int game = scanner.nextInt();

        switch (game){

            case 1: gameName = Main.Games.PES.label; break;
            case 2: gameName = Main.Games.FIFA.label; break;
            case 3: gameName = Main.Games.COD.label; break;
            case 4: gameName = Main.Games.GOW.label; break;
            case 5: gameName = Main.Games.FORZA.label; break;
            case 6: gameName = Main.Games.RDR.label; break;
            case 7: gameName = Main.Games.MARIO.label; break;

        };

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

    public void show() {
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
