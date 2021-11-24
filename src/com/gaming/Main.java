package com.gaming;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public enum Games {
        PES("Pro Evolution Soccer",1,2),
        FIFA("FIFA",2,1),
        COD("Call of Duty",3,4),
        GOW("God of War",4,3),
        FORZA("Forza Horizon",5,6),
        RDR("Read Dead Redemption",6,5),
        MARIO("Super Mario",7,3);

        public final String label;
        public final int postN1;
        public final int postN2;
        public final boolean reserved;

        Games(String label, int postN1,int postN2) {
            this.label = label;
            this.postN1 = postN1;
            this.postN2 = postN2;
            this.reserved = false;

        }
    }
    public static void main(String[] args) {

        // get current time
        LocalTime time = LocalTime.now();
        // System.out.println("Current time is: " + time );
        // time plus 30 minutes
        // timePlus30 = time.plusMinutes(60);



        Scanner scanner = new Scanner(System.in);	//Scanner declaration
        Client client = new Client();
        Revenue revenue = new Revenue();
        int choice;

        System.out.print("Choose an option \n");

        do {
            System.out.print("1. Add client \n");
            System.out.print("2. Clients \n");
            System.out.print("3. Lobby \n");
            System.out.print("4. Revenue \n");
            System.out.print("0. Exit \n");

            choice =  scanner.nextInt();

            switch (choice) {
                case 1 : client.addClient(); break;
                case 2 : client.showClients(); break;
                case 3 : client.showLobby(); break;
                case 4 : System.out.print("total revenue is : " + client.getTotalAmount() + "\n" ); break;

            }
        }while (choice != 0);

    }

    public static void menu(){

    }



}
