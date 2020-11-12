package com.storygame;

import org.jetbrains.annotations.NotNull;

public class ProcessRequest {
    // Instantiations of other classes
    QuestionLoops ql = new QuestionLoops();

    // Game "score" factors, impressions on other people and actions taken

    // If you lent your shoe to Rocco, increases tgImpression, but reduces traveling ability
    static boolean lentShoe;
    // Increase tgImpression, allows adventure (and engine) to start
    static boolean fixedCord;
    // Stores what photo of an animal you took so you scare lion later
    public char animalPhoto;
    // Increase this score so Rocco will return the favor later.
    public static int tgImpression;
    // method by which player avoids lion
    int lionAvoidance;
    //Whether the player is alive
    public boolean alive = true;

    // Used to break out of loops
    public boolean shouldBreak;

    // Used to identify if the player is in a "safe" state (break out of loop)
    public boolean safe = false;

    // Used by lendShoeQuestion to process request
    public void setLentShoe(@NotNull String response) {
        if (response.equals("Y")) {
            lentShoe = true;
            tgImpression++;
            System.out.println("Rocco: 'Thanks, that was very kind'\n"
            + "*Rocco will remember that*");
        }
        else if (response.equals("N")) {
            lentShoe = false;
            System.out.println("Rocco: 'Alright fine, I'll use mine instead'\n"
            + "*Rocco will remember that*");
        }
        else System.out.println("Please enter Y or N");
    }

    // Used to increase impression and set fixedCord to true
    public void setFixedCord(){
        fixedCord = true;
        tgImpression++;
        System.out.println("Cord fixed");
    }

    // Used to set animal photo
    public void setAnimalPhoto(char photoChar) {
        animalPhoto = photoChar;
    }

    // Used to make decision for how to avoid lions
    public void processAvoidLions(String choice) {
        switch (choice) {
            case "1" -> {
                lionAvoidance = 1;
                System.out.println("*You leap out of the car to try and run for dear life*\n" +
                        "*Rocco grabs you by the collar and yanks you back into the car*\n" +
                        "Calm down, here's what we're going to do.\n");
                shouldBreak = true;
            }
            case "2" -> {
                lionAvoidance = 2;
                System.out.println("*You stayed in the car and hoped for the best*\n" +
                        "Rocco: 'Nice job for not freaking out,\n *Rocco will remember that*\n Watch this:'\n");
                tgImpression++;
                shouldBreak = true;
            }
            case "3" -> {
                lionAvoidance = 3;
                System.out.println("*You try to pounce on a lion somehow hoping to overpower it*\n" +
                        "*Rocco grabs your by the collar and yanks you back into the car*\n" +
                        "Rocco: 'Are you insane? You can't take a pride of lions. Here's what we need to do'\n");
                shouldBreak = true;
            }
            default -> {
                System.out.println("Please enter 1, 2, or 3. ");
                shouldBreak = false;
            }
        }
    }

    // Climax of story where you either die or escape the lions.
    public void processEscapeAfterEjection(String response) {
        if (response.equals("1")) {
            System.out.println("*You throw your shoe at the lion*\n" +
                    "*Rocco will remember that*\n" +
                    "*The lion is not phased and begins to approach you*\n" +
                    "*You and Rocco turn and run the opposite direction*\n");
            tgImpression++;
            if (lentShoe) {
                System.out.println("*Since you lent your other shoe to Rocco, you now have no shoes*\n" +
                        "*You step on a rock, and fall over in pain*\n");
                if (tgImpression >= 3) {
                    System.out.println("*Since you were nice to Rocco in the past, he helps you up, and you escape*\n");
                }
                else {
                    System.out.println("*Since you were not nice enough to Rocco, he leaves you behind*\n");
                    alive = false;
                }
            }
            else {
                System.out.println("*Since you didn't lend Rocco your shoe, he trips over because he used his own.\n");
                if (ql.rescueRocco().equals("1")) {
                    System.out.println("*You help Rocco up and you escape together*\n");
                    tgImpression++;
                }
                else {
                    System.out.println("*You leave Rocco behind and run away by yourself*\n" +
                            "*Rocco will remember that*\n" +
                            "*Rocco pulls himself and barely manages to escape.*\n");
                }
            }
        }
        else if (response.equals("2")) {
            System.out.println("*You and Rocco turn and run the opposite direction of the lion*\n" +
                    "*Rocco will remember that*\n");
            if (!lentShoe) {
                System.out.println("*Since you did not lend Rocco your shoe, he trips over since he used his own.*\n");
                if (ql.rescueRocco().equals("1")) {
                    System.out.println("*You help Rocco up and you escape together*\n");
                    tgImpression++;
                }
                else {
                    System.out.println("*You leave Rocco behind and run away by yourself*\n" +
                            "*Rocco will remember that*\n");
                }
            }
            else {
                System.out.println("*You trip over because you lent your shoe to Rocco*\n");
                if (tgImpression >= 3) {
                    System.out.println("*Since you were nice to Rocco in the past, he helps you up, and you escape*\n");
                }
                else {
                    System.out.println("*Since you were not nice enough to Rocco, he leaves you behind*\n");
                    alive = false;
                }
            }
        }
    }

    public void processAlternateEnding(String response) {
        if (response.equals(">^^<^") || response.equals(">^<^") || response.equals(">^<")) {
            System.out.println("You made it past the lions");
            safe = true;
        }
        else {
            System.out.println("Incorrect, try again.");
            safe = false;
        }
    }
}