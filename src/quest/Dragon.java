package quest;

import sun.plugin.services.PlatformService;

import javax.annotation.processing.SupportedSourceVersion;

/**
 * Created by Olga on 18.09.2014.
 */
public class Dragon {
    final static String[] TYPE={" the kind white Dragon "," the neutral grey Dragon "," the evil red Dragon "};
    final static String[] MOOD={" greedy ", " starved ", " curious ", " depressive "};
    int[] id ={0,0};

    public Dragon(int type, int mood){
        id[0]=type;
        id[1]=mood;
    }

    public String getMood(){
        return this.MOOD[id[1]];
    }

    public String getType(){
        return this.TYPE[id[0]];
    }

    public void eat(Player x){
        System.out.println("\"ARE YOU KIDDING ME? I'M FUNGRY NOW AND I WILL EAT YOU\"");
        System.out.println("He makes you angry and EVIL person");
        x.id[0]=2;
        System.out.println("You decide to...");
    }

    public void fly( Player x){
        System.out.println("\"Oh, of course, I am happy to fly with you.\" \n+" +
                            "You take on the dragon, and you fly over the boundless expanse of the fairy world, and then you both \n" +
                            "go back into the cave.");
        x.id[1]=0; x.id[0]=0;
        System.out.println("You became KIND and CLEVER\nYou decide to...");
    }
    public void laugh(int playeract){
        switch (playeract){
            case 0: {
                     System.out.println("The Dragon started to make strange sound, finally, you understood that it's laughing at you" +
                        "\n\"YOU'RE SUCH WEEK CREATURE\"\n");
                     System.out.println("You decide to...");
                     break;
            }
            case 1:{
                System.out.println("While you're beating him, The Dragon started to make strange sound, finally, you understood that it's laughing at you" +
                        "\n\"YOU'RE SUCH FOOL CREATURE\"\n");
                System.out.println("You decide to...");
                    break;
            }
            case 2:{
                System.out.println("\"SERIOUSLY? THE BRAVE REQUEST,\" -- it begins laughing at you ");
                System.out.println("You decide to...");
                    break;
            }
        }
    }

    public void flyDur(){
        System.out.println("The Dragon flies to the other side of the cave and begins to emit a plaintive sound: \"DUR-DUR-DUR\" (as cat pur), " +
                "\nyou realize that the dragon is crying" +
                "\nYou decide to...");
    }

    public void dur(Player x){
        this.id[1]=2;
        System.out.println("dragon happily eats pack Rolton, saying: \"DUR-DUR-DUR\" (as cat pur), he is very grateful to you and turns into a dragon"+this.MOOD[id[1]]);
        System.out.println("You decide to...");
    }

    public void giveSomething(Player x){
        System.out.print("\"Your story was very funny, thanks, my present for you will be ");
        if (x.id[1]==1||x.id[1]==2){
            System.out.println("STRENGTH\"");
            x.id[1]=1;
        }
        else  {
            System.out.println("MIND\"");
            x.id[1]=0;
        }

    }

    public void breatheFire(Player x, int playeract){
        switch (playeract){
            case 0: {
                System.out.println("\"HOW DARE YOU?!\"-- the dragon's shouting and start to breath on you with THE FIRE ");
                System.out.print("You dodge the fire deftly and shouting:\"FIRE WALk WITH ME\"" +
                                     "\n P.S. Twin Peaks quote");
                break;
            }
            case 1: {
                System.out.println("\"YOU WON'T GO AWAY FROM ME,\"-- the dragon's shouting and start breathe on you with THE FIRE");
                if (x.id[1]==1)
                    System.out.println("You dodge the fire deftly and decide..." );
                else System.out.println("You stumble a little and fire almost burn your leg and you decide...");
            }
        }
    }
}
