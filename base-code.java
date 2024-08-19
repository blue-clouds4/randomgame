import java.util.*;

class RandomGame {
    // Blue_ Stats
    static int blueAtk = 77;
    static String blueSpec = "Dagger Dash";
    static int blueHp = 100;
    static int blueDef = 170;
    static int blueXp = 0;
    static int blueGold = 1000;

    // RandomBro Stats
    static int randomBroAtk = 60;
    static String randomBroSpec = "Hack Attack";
    static int randomBroHp = 120;
    static int randomBroDef = 150;

    // CrazyGirl Stats
    static int crazyGirlAtk = 90;
    static String crazyGirlSpec = "Blood Bath";
    static int crazyGirlHp = 80;
    static int crazyGirlDef = 130;

    static RandomGame call = new RandomGame();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        call.birth();
        call.dream();
    }

    void clearScreen() {
        // Print newlines to clear the console
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void delay(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void birth() {
        // Wherefore thee exist?
        System.out.println("What is name?");
        System.out.println("Something we do not know");
        System.out.println("He lies near nothing, while on living");
        System.out.println("Destined to break the random, if he chooses to");
        System.out.println("His name shall be:");
        clearScreen();
        String a = "██████╗  █████╗ ███╗   ██╗██████╗  ██████╗ ███╗   ███╗";
        String b = "██╔══██╗██╔══██╗████╗  ██║██╔══██╗██╔═══██╗████╗ ████║";
        String c = "██████╔╝███████║██╔██╗ ██║██║  ██║██║   ██║██╔████╔██║";
        String d = "██╔══██╗██╔══██║██║╚██╗██║██║  ██║██║   ██║██║╚██╔╝██║";
        String e = "██║  ██║██║  ██║██║ ╚████║██████╔╝╚██████╔╝██║ ╚═╝ ██║";
        String f = "╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═════╝  ╚═════╝ ╚═╝     ╚═╝";
        // I wish I could insert some music and all here, but I simply cannot
        System.out.println(a);
        delay(1500);
        System.out.println(b);
        delay(1500);
        System.out.println(c);
        delay(1500);
        System.out.println(d);
        delay(1500);
        System.out.println(e);
        delay(1500);
        System.out.println(f);
        delay(2500);
        // For CLI
    }

    void existence() {
        clearScreen();
        // What is existence? Something that we don't know of, us.
        System.out.println("█-rbi");
        delay(150);
        System.out.println("█-Blue_");
        delay(150);
        System.out.println("█-cg");
        delay(500);
        // We don't know where we are, but we're here.
        System.out.println("█BLUE_-existence..?");
        delay(150);
        System.out.println("█rbi-we're here, that's what matters");
        delay(150);
        System.out.println("█cg-we don't if we exist yet, this is the void here. Nothing passes, nothing here, but we are something? Aren't we?");
        delay(150);
        System.out.println("█blue- We do not know.");
        delay(150);
        System.out.println("█rbi- The creators named me random. They were mentioning something about us destined to be together, or not. For they also mentioned of me breaking random.");
        delay(150);
        System.out.println("█blue- I do not understand what they told of mine. They spoke of me running from everything. Me running is the me staying.");
        delay(150);
        System.out.println("█cg- Nothing, they told of mine.");
        delay(150);
        System.out.println("cg thinking, the creators had uttered something and she uttered null about it; either she didn’t like what were told, or she was cg. Destined to feel a sense of not belonging anywhere. Nothing can help her come out of it. She’d just feel better for brief with someone.");
        delay(150);
        System.out.println("blue meanwhile runs and runs and runs forever, trying to flee everything something we do not understand of, neither can he, running or staying. Either way, it makes him feel good. Lies he amongst nothing and something even in existence.");
        delay(150);
        System.out.println("rbi is someone we don't understand, does random things and lives, he does things that's him, no fate defines him but still lies in the line of existence. He exists, always has, always has, always will. He'll live when he dreams, a dream to be.");
        delay(150);
    }

    void light() {
        Scanner in = new Scanner(System.in);
        System.out.println("There's a glow in the other end of the space. Do you desire to walk through it? Yes/No");
        String life = in.next();
        if (life.equalsIgnoreCase("yes") || life.equalsIgnoreCase("y")) {
            existence();
        } else {
            System.out.println("It drags you and your friends in either way.");
            existence();
            // You had no choice either way lol
        }
    }

    void dream() {
        // It ..which was a dream?
        System.out.println("You seem not to know where you are,");
        System.out.println("This does feel like a memory.");
        System.out.println("There is something in front of you, so similar");
        System.out.println("Yet, you don't know what's that or this.");
        System.out.println("Dream it is called I assume.");
        System.out.println("Trees of oak and bamboo around, dream dream.");
        System.out.println("Amongst there lied a school.");
        System.out.println("We entered it, not knowing what there is.");
        System.out.println("What people spoke, will speak, speaking nothing makes sense. They seem to know, but I do not.");
        System.out.println("Dream, dream awake me before I do understand here.");
        System.out.println("                                                                                      ~blue_");
        delay(7000);
        clearScreen();
        System.out.println("Evening fellow beings.");
        delay(150);
        System.out.println("█blue- Who's there?");
        delay(150);
        System.out.println("Someone you wouldn’t know.");
        delay(150);
        System.out.println("█cg- Speaks in riddles...");
        delay(150);
        System.out.println("█rbi- Reminds me of the creator.");
        delay(150);
        System.out.println("Enough, I'm bored. Entertain me. Do fight. This is a game y'all should fight.");
        delay(150);
        System.out.println("What does he mean this is a dream?");
        clearScreen();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        // Begin fight scene here
        fight("???");
    }

    void fight(String a) {
        System.out.println(k+" wants to fight the insane group!");
        System.out.println("                 HP          ATK        DEF        SpecialAtk");
        System.out.println("Blue_            " + blueHp + "              " + blueAtk + "              " + blueDef + "              " + blueSpec);
        System.out.println("RandomBro        " + randomBroHp + "         " + randomBroAtk + "         " + randomBroDef + "         " + randomBroSpec);
        System.out.println("CrazyGirl        " + crazyGirlHp + "         " + crazyGirlAtk + "         " + crazyGirlDef + "         " + crazyGirlSpec);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");

        // Placeholder for fight sequence logic
        System.out.println("The battle begins...");
        System.out.print("..");
        call.delay(100);
        String b=" use help the list of commands";
        for(int i=0;i<f.length();i++){
        System.out.print(f.charAt(i));
        call.delay(100);
    }
        String c;
        c=in.next();
    }
}
