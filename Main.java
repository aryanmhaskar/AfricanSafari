package com.storygame;

import java.util.Scanner;

public class Main {

    // Instantiations of objects
    private static final Scanner scan = new Scanner(System.in);
    private static final QuestionLoops ql = new QuestionLoops();
    private static final ProcessRequest pr = new ProcessRequest();
    public static String userName;

    public static void main(String[] args) {
        // Main Dialogue which will use QuestionLoops, QuestionLoops will use ProcessRequest

        // Ask for userName
        System.out.print("*1989- you are on an African safari after saving up for a vacation.*\n" +
            "Rocco: 'Hey there! I'm Rocco, your safari guide for the day, what's your name?'\n" +
            "Name: ");
        userName = scan.nextLine();
        System.out.println("Rocco: 'Nice to meet you, " + userName + ". Let's begin our journey.'");

        // Asks for shoe
        System.out.println("*struggles to open car*\n" +
            "Rocco: 'Uh, this is awkward... looks like I am locked out.'");
        ql.lendShoeQuestion();
        System.out.println("*Using the sole of a shoe, the car is forced open*\n" +
            "Rocco: 'Alright, hop on in!'");

        // Start engine mini-game
        System.out.println("Rocco: 'Let me start the engine.'\n" +
        "*Engine doesn't start*\n" +
        "Rocco: 'Yikes, looks like there's something wrong, I'll take a look, you fix this cord.'");
        ql.fixCord();
        ql.identifyReplacementSegment();
        ql.readUserManual();
        System.out.println("Rocco: 'Oh I see you fixed the cord, good job.'");

        // First animal encounter
        System.out.print("Rocco: 'We can finally begin, hopefully that'll be the last of our troubles.'\n" +
                "*Safari drive continues on for 1 hour*\n" +
                "Rocco: 'Yo look over there, there's a (L)ion, (G)azelle, and a (V)ulture, take some pictures.\n" +
                "*You check your camera to realize there is only one film strip left*\n" +
                "Choose one animal to take a picture of (L, G, or V): ");
        ql.takeAnimalPhoto();

        // Lions begin to approach the car
        System.out.println("Rocco: 'Yo these lions are getting awfully close...'");
        ql.avoidLions();

        // Eject from car "by accident" and try to play dead
        System.out.println("Rocco: 'Here's what we do in these situations, we just press this button to close the car'\n" +
                "*Rocco accidentally presses eject button*\n" +
                "Rocco: 'Yuh Oh'\n" +
                "*You and Rocco fly out of the vehicle right into the center of the lions*\n" +
                "*All the lions get spooked and run except for one*");
        ql.escapeAfterEjection();
        ql.alternateEnding();
        if (pr.alive) {
            System.out.println("Rocco: 'Wow, I can't believe we made it out of that'\n" +
                    "Rocco: 'Let's go home, I think we had enough adventure for today'\n" +
                    "END OF GAME SCORES\n" +
                    "How much Rocco liked you (out of 5):" + ProcessRequest.tgImpression);
            switch (pr.animalPhoto) {
                case 'L' -> System.out.println("You took a picture of a lion, allowing you to escape lions.");
                case 'G' -> System.out.println("You took a picture of a gazelle, which you kept as a memento");
                case 'V' -> System.out.println("You took a picture of a vulture, which you kept as a memento");
            }
        }
        else {
            System.out.println("You were eaten by the lion and DIED\n" +
                    "END OF GAME SCORES\n" +
                    "How much Rocco liked you (out of 5):" + ProcessRequest.tgImpression);
            switch (pr.animalPhoto) {
                case 'L' -> System.out.println("You took a picture of a lion, allowing you to escape..well not really.");
                case 'G' -> System.out.println("You took a picture of a gazelle, which was buried with your bones");
                case 'V' -> System.out.println("You took a picture of a vulture, which was buried with your bones");
            }
        }
    }
}