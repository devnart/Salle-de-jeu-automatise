package com.gaming;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);	//Scanner declaration
        Client client = new Client();
        Revenue revenue = new Revenue();
        int choice;

        System.out.print("Choose an option \n");

        do {
            System.out.print("1. Add client \n");
            System.out.print("2. Clients \n");
            System.out.print("3. total revenue \n");
            System.out.print("0. Exit \n");

            choice =  scanner.nextInt();

            switch (choice) {
                case 1 : client.addClient(); break;
                case 2 : client.show(); break;
                case 3 : System.out.print("total revenue is : " + client.getTotalAmount() + "\n" ); break;

            }
        }while (choice != 0);

    }

    public static void menu(){

    }



}
