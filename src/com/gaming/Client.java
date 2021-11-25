package com.gaming;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Client {

    private String name;
    private int post;
    private LocalTime start;
    private LocalTime end;
    private int duration;
    private Main.Games gameName;
    private int amount;


    List <HashMap> users= new ArrayList();
    List <HashMap> lobby = new LinkedList<>();

    int number = 1;
    boolean toLobby = false;

    // time instance
    LocalTime time = LocalTime.now();

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

            case 1: gameName = Main.Games.PES;  break;
            case 2: gameName = Main.Games.FIFA; break;
            case 3: gameName = Main.Games.COD; break;
            case 4: gameName = Main.Games.GOW; break;
            case 5: gameName = Main.Games.FORZA; break;
            case 6: gameName = Main.Games.RDR; break;
            case 7: gameName = Main.Games.MARIO; break;
        };

        int a=0;
        int b=0;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).get("post").equals(gameName.postN1)) {
                a=1;
            } else{
                a=0;
            }
            if (users.get(i).get("post").equals(gameName.postN2)) {
               b = 1;
            } else {
                 b = 0;
            }
        }
        if(a==0 && b==0){
            post=gameName.postN1;

        }else if(a!=0 && b==0){
            post=gameName.postN2;
        }
        else {
            toLobby=true;
        }

        scanner.nextLine();
        start = time;
        if (toLobby) {
            start = spot.isAvailable(start,users,gameName);
        }
        System.out.print("duration : \n");

        System.out.print("30 Minutes \n");
        System.out.print("1 Hour \n");
        System.out.print("2 Hours \n");
        System.out.print("5 Hours \n");
        System.out.print("9 Hours \n");

        System.out.print("Choose a duration : ");

        duration = scanner.nextInt();


        scanner.nextLine();

        end = start.plusMinutes(duration);

        switch (duration) {
            case 30 : amount = 5; end= start.plusMinutes(30); break;
            case 1 : amount = 10; end=start.plusMinutes(60); break;
            case 2 : amount = 18; end=start.plusMinutes(120); break;
            case 5 : amount = 40; end=start.plusMinutes(300); break;
            case 9 : amount = 65; end=start.plusMinutes(540); break;
        }
        spot.getMaxEndTime(users);
        if (end.isAfter(LocalTime.parse("18:00:00")) || end.isBefore(LocalTime.parse("09:00:00"))) {
            System.out.println("You can't play after 18:00 you can come back tomorrow or play till 18:00");
            end = LocalTime.parse("18:00:00");
        }
        client.put("name",name);
        client.put("post",post);
        client.put("start",start);
        client.put("end",end);
        client.put("duration",duration);
        client.put("gameName",gameName);
        client.put("ref",ref);
        client.put("amount",amount);

        System.out.println("post : " + post);
        System.out.println("start : " + start);
        System.out.println("end : " + end);

        users.add(client);

        if (toLobby) {
            System.out.println("You are in the lobby");
            lobby.add(client);
        }

    }

    public void showClients() {
        System.out.print("clients : \n" + users + "\n");
    }

    public void showLobby() {
        System.out.print("lobby : \n" + lobby + "\n");
    }

    public int getTotalAmount() {
        int total = 0;
        for (HashMap client : users) {
            total += (int) client.get("amount");
        }
        return total;
    }


}
