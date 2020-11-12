package com.storygame;

import java.util.Scanner;

public class QuestionLoops {

    // Instances of classes
    private static final Scanner scan = new Scanner(System.in);
    private static final ProcessRequest pr = new ProcessRequest();


    // Asks question then uses lendShoe method to process request
    public void lendShoeQuestion() {
        while (true) {
            System.out.print("Rocco: 'This may be a strange ask, but could I borrow your shoe?'\n" +
            "Y/N: ");
            String response = scan.next().toUpperCase();
            if (response.equals("Y") || response.equals("N")) {
                pr.setLentShoe(response);
                break;
            }
        }
    }

    // Mini-game to fix cord.
    public void fixCord() {
        while (true) {
            System.out.println("            ___x______\n" +
                    "            ^^^^^^^^^^\n" +
                    "Segment #s: 0123456789");
            System.out.print("Identify faulty segment (enter #): ");
            String response = scan.next();
            if (response.equals("4")) {
                break;
            }
            else {
                System.out.println("Incorrect, try again");
            }
        }
    }



    // User has to pick out a segment to replace the faulty one with
    public void identifyReplacementSegment() {
        while (true) {
            System.out.println("Choose correct replacement segment between:\n+, ), }, x, _");
            System.out.println("1  2  3  4  5");
            System.out.print("Enter number of replacement segment: ");
            String response = scan.next();
            if (response.equals("5")) {
                break;
            }
            else {
                System.out.println("Incorrect, try again.");
            }
        }
    }

    // User has to unscramble a word to learn to replace cord
    public void readUserManual() {
        while (true) {
            System.out.print("Read the user manual to determine how to replace the segment\n" +
                    "Looks like it is scrambled, unscramble the word to continue\n" +
                    "Manual: 'Just remove the old segment and *sinrte* the new one'\n" +
                    "Enter unscrambled word: ");
            String response = scan.next().toUpperCase();
            if (response.equals("INSERT")) {
                pr.setFixedCord();
                break;
            }
        }
    }

    // Used to create a photo of an animal
    public void takeAnimalPhoto() {
        label:
        while (true) {
            String response = scan.next().toUpperCase();
            switch (response) {
                case "L", "LION" -> {
                    pr.setAnimalPhoto('L');
                    System.out.println("You took a photo of a lion and placed it in your pocket.");
                    break label;
                }
                case "G", "GAZELLE" -> {
                    pr.setAnimalPhoto('G');
                    System.out.println("You took a photo of a gazelle and placed it in your pocket.");
                    break label;
                }
                case "V", "VULTURE" -> {
                    pr.setAnimalPhoto('V');
                    System.out.println("You took a photo of a vulture and placed it in your pocket.");
                    break label;
                }
            }
            System.out.println("Enter L, G, or V");
        }
    }

    // Used to create choice for how to avoid lions
    public void avoidLions() {
        while (!pr.shouldBreak) {
            System.out.print("*Lions surround car*\n" +
                    "Rocco: 'Oh dear'\n" +
                    "Choose an option:\n" +
                    "1. Abandon car and run\n" +
                    "2. Stay in car\n" +
                    "3. Fight lions\n" +
                    "Enter number (1, 2, 3): ");
            String choice = scan.next();
            pr.processAvoidLions(choice);
        }
    }

    // If you took a photo of the lion, you can breeze through this conflict, else user will need to sacrifice something.
    public void escapeAfterEjection() {
        while (true) {
            if (pr.animalPhoto == 'L') {
                System.out.println("*You pull out your photo of the lion, and scare the real lion away*\n" +
                        "Rocco: 'That worked? You are one smart person'\n" +
                        "*Rocco will remember that*");
                alternateEnding();
                break;
            }
            System.out.print("Rocco: 'If you had taken a photo of the lion we could've scared him away!'\n" +
                    "Get lion to leave:\n" +
                    "1. Throw your shoe\n" +
                    "2. Run away\n" +
                    "Enter response:");
            String response = scan.next();
            if (response.equals("1") || response.equals("2")) {
                pr.processEscapeAfterEjection(response);
                break;
            }
            else {
                System.out.println("Please enter 1 or 2");
            }
        }
    }

    // Alternate ending if player took photo of lion (cause then game will be too short)
    public void alternateEnding() {
        while (!pr.safe) {
            System.out.print("Rocco: 'Alright then, now we just have to make it past the lions to the car'\n" +
                    "Rocco: 'Here, we can distract them with this water bottle, would you mind setting it up for me?'\n" +
                    "\n" +
                    "_/|\\_ < car (sorry I'm a terrible artist)\n" +
                    "__________________________________________\n" +
                    "/-|-|-° < (lion here)_____________________\n" +
                    "(you and Rocco)___________________________\n" +
                    "\n" +
                    "Enter moves using the characters (^<>)-\n" +
                    "Example: to go up, right, and then left you would type in: '^><' and then hit Enter\n" +
                    "NOTE: An arrow (in the right for example) means you move ALL the way to the right of the 'panel'," +
                    "not just one space.\n " +
                    "Enter response:");
            String response = scan.next();
            pr.processAlternateEnding(response);
        }
    }

    // If you didn't lend or throw your shoe, you will be presented with whether to save or abandon Rocco
    public String rescueRocco() {
        while (true) {
            System.out.print("1. Help Rocco up and escape together\n" +
                    "2. Abandon Rocco\n" +
                    "Enter Response:");
            String response = scan.next();
            if (response.equals("1") || response.equals("2")) {
                return response;
            }
        }
    }
}