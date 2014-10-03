package quest;
import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;
/**
 * Created by Olga on 18.09.2014.
 */
public class Game {
    final static Random random = new Random();
    final static String INTRO =
            "\nPress the key:" +
            "\n1 -- FIGHT" +
            "\n2 -- FEED A DRAGON" +
            "\n3 -- TELL A STORY" +
            "\n4 -- ASK TO FLY WITH HIM" +
            "\n5 -- RUN";


    public static void main(String[] args) {
        Player you = new Player(random.nextInt(3), random.nextInt(4));
        Dragon enemy = new Dragon(random.nextInt(3), random.nextInt(4));

        System.out.println("Imagine, you're" + you.getType() + " and" + you.getQuality() + ".\n" +
                "Suddenly the strange hole appears on your screen,\n" +
                "it's flickering and shining by magic blue color.\n" +
                "You think:\"Is that what new version of the dead screen?!\"\n" +
                "But the hole become bigger and bigger, and suddenly you find yourself in a very dark cave," +
                "\n only  huge eyes of someone are glowing in the dark, coming closer you see that it is " +
                enemy.getMood() + "and" + enemy.getType() +
                ".\nYou realize that you came in the magic world like Midlle-earth from Tolkien's books.\n What will you do? ");

        for (int i=0; i<4; i++){
            System.out.println(INTRO);
            int choice=inputK();
            you.action(enemy,choice);
        }

        System.out.println("Right at this moment you wake up on your computer desk and understood that\n" +
                "that the world was the fabulous recursive dream");
    }

    //for parse INTEGER
    public static int inputK(){
        int val;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNextInt() ) {
                val = scanner.nextInt();
                break;
            } else {
                System.err.println("You should press the NUMBER");
                scanner.next();
            }
        }
        if (val>=1&&val<=5){
            return val;
        }
        else {
            System.err.println("The number should be between 1 and 5");
            return inputK();
        }
    }

}
