package quest;

import javax.swing.*;

/**
 * Created by Olga on 18.09.2014.
 */
public class Player {
    final static String[] TYPE = {" kind", " neutral", " evil"};
    final static String[] QUALITY = {" clever", " strong", " week", "fool"};
    final static String[] STORIES = {"What is the longest word in the English language?\n\"Smiles\". Because there is a mile between its first and last letters!,",
            "What's the definition of a pessimist? A pessimist is a well-informed optimist.",
            "A man was injected with a deadly poison, but, it did not kill him. Why?\nHe was already dead!"};
    static int counts = -1; //count  of the story
    int[] id = {0, 0};

    public Player(int type, int quality) {
        id[0] = type;
        id[1] = quality;
    }

    public String getQuality() {
        return this.QUALITY[id[1]];
    }

    public String getType() {
        return this.TYPE[id[0]];
    }

    public void action(Dragon x, int playeract) {
        switch (--playeract) {
            case 0:
                this.fight(x);
                break;
            case 1:
                this.feed(x);
                break;
            case 2:
                this.tellStory(x);
                break;
            case 3:
                this.askToFly(x);
                break;
            case 4:
                this.run(x);
                break;
        }
    }

    void fight(Dragon x) {
        switch (this.id[0]) {
            case 0: {
                System.out.println("\nYou suddenly fall and pretend to be dead. The dragon face come closer to you \n" +
                        "and you pierce the computer screwdriver into his neck... ");
                if (x.id[0] == 0) {
                    x.flyDur();
                } else {
                    x.breatheFire(this,0);
                }
            }
            break;
            case 1: {
                System.out.println("You quietly sneak up to him and shouting \"DIE\", jumping on his neck and tried to strangle ...");
                if (x.id[0] == 0) {
                    x.flyDur();
                } else {
                    x.breatheFire(this, 0);
                }
                break;
            }

            case 2: {
                System.out.println("You quietly sneak up to him and shouting \"DIE\", trying to jump on his neck," +
                        "\nbut you did not have the strength to jump and you fall to the floor");
                x.laugh( 0);
                break;
            }

            case 3: {
                System.out.println("You come to the dragon fearlessly and begin to beat him in his hard scales");
                x.laugh( 1);
                break;
            }
        }

    }

    void feed(Dragon x) {
        System.out.println("you decide to feed him a bundle Rolton from your pocket");
        if (x.id[1] == 1 && (x.id[0] == 2 || x.id[0] == 1)) {
            x.eat(this);
        } else {
            x.dur(this);
        }
    }

    void tellStory(Dragon x) {
        System.out.println("You begin to tell one of the British story:\"" + STORIES[++counts] + "\"");
        if (x.id[1] == 1 && (x.id[0] == 2 || x.id[0] == 1)) { // if the dragon's starved and neutral OR evil, he'll eat you
            x.eat(this);
        } else {
            x.giveSomething(this);
        }
    }

    void askToFly(Dragon x) {
        System.out.println("\"Oh, I always dream to fly on the dragon, it seems that he wouldn't object to,\"--thought you" +
                "\n and asked him to fly");
        if (x.id[0] == 0 || (x.id[0] == 1 && x.id[1] == 2)) { // if the dragon's kind and curious OR depressive, he'll fly with you
            x.fly(this);
        } else if (x.id[0] == 1) { //if the dragon neutral he'll laugh at you
            x.laugh( 2);
        } else {
            x.eat(this);
        }
    }

    void run(Dragon x) {
        System.out.println("You look in horror at it  and begins to run VERY, VERY fast");
        if (x.id[0] == 0) { //if the dragon's kind
            x.flyDur();
        } else {
            x.breatheFire(this, 1);
        }
    }
}
