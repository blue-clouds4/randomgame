import java.util.*;
//the beginning,the birth,the end
class randomgam
    {
        randomgam call=new randomgam();
        public static void main(String[] args){
         Scanner in=new Scanner(System.in);
         call.birth();
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
    
        void birth(){
        //wherefore thee exist?
        System.out.println("what is name?");
        System.out.println("something we do not know");
        System.out.println(" he lies near nothing,while on living");
        System.out.println("destined to break the random,if he chooses to");
        System.out.println("his name shall be:");
        call.clearScreen();
        String  a="██████╗  █████╗ ███╗   ██╗██████╗  ██████╗ ███╗   ███╗";
        String  b="██╔══██╗██╔══██╗████╗  ██║██╔══██╗██╔═══██╗████╗ ████║";
        String  c="██████╔╝███████║██╔██╗ ██║██║  ██║██║   ██║██╔████╔██║";
        String  d="██╔══██╗██╔══██║██║╚██╗██║██║  ██║██║   ██║██║╚██╔╝██║";
        String  e="██║  ██║██║  ██║██║ ╚████║██████╔╝╚██████╔╝██║ ╚═╝ ██║";
        String  f="╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═════╝  ╚═════╝ ╚═╝     ╚═╝";
        //i wish i could insert some music and all here,but i simply cannot
        System.out.println(a);
        call.delay(1500);
        System.out.println(b);
        call.delay(1500); 
        System.out.println(c);
        call.delay(1500); 
        System.out.println(d);
        call.delay(1500); 
        System.out.println(e);
        call.delay(1500); 
        System.out.println(f);
        call.delay(2500); 
        //for cli
        }

        void existence(){
        //what is existence,something that we dnt know of, us
        System.out.println("█-rbi");
        call.delay(150);    
        System.out.println("█-Blue_");
        call.delay(150); 
        System.out.println("█-cg");
        call.delay(500); 
        //we dont where we are,but we're here
        System.out.println("█BLUE_-existence..?");
        call.delay(150); 
        System.out.println("█rbi-we're here,that's what matters");
        call.delay(150); 
        System.out.println("█cg-we dont if we exist yet,this is the void here. nothing passes,nothing here,but we are something? aren't we?");
        call.delay(150); 
        System.out.println("█blue- we do not know");
        call.delay(150); 
        System.out.println("█rbi- the creators named me random,they were mentioning something about us destined to be together,or not. for they also metioned of me breaking random");
        call.delay(150); 
        System.out.println("█blue- i do not understand what they told of mine,they spoke of me running from everything,me running is the me staying");
        call.delay(150); 
        System.out.println("█cg- nothing,they told of mine");
        call.delay(150); 
        System.out.println("cg thinking,the creators had uttered something and she uttered null about it; either she didnt like what were told, or  she was cg. destined to feel a sense of not belonging anywhere,nothing can help her come out of it. she'd just feel better for breif with someone");
        call.delay(150); 
        System.out.println("blue meanwhile runs and runs and runs forever,trying to flee everything something we do not understand of,neither can he,running or staying. either way it makes him feel good. lies he amoungst nothing and something even in existence");
        call.delay(150); 
        System.out.println("rbi is someone we dont understand,does random things and lives,he does things thats him,no fate defines him but still lies in the line of existence. he exists,always has,always has,always will. he'll live when he dreams, a dream to be");
        call.delay(150);
        }
    
      void light(){
      System.out.println("there's a glow in the other end of the space do  you desire to walk through it?yes/no");
      String life;
       life=in.next();
       if(life= "yes"|| life ="y")
       call.existence();
       else{
      System.out.println("it drags you and your friends  in either way");
      call.existence();
      //you had no choice either way lol
      }
     }
    void dream(){
    //it ..which was a dream?
    System.out.println("you seem not know where you are,");
    System.out.println("this does feel like  memory");
    System.out.println("there is something in front of you,so similar");
    System.out.println("yet,you don't know what's that or this");
    System.out.println("dream it is called i assume");
    System.out.println("trees of oak and bamboo around,dream dream");
    System.out.println("amoungst there lied a school");
    System.out.println("we entered it,not knowing what there is");
    System.out.println("what people spoke,will speak,speaking nothing makes sense. they seem to know,but i do not");
    System.out.println("dream,dream awake me before i do understand here");
    System.out.println("                                                                                      ~blue_");
    System.out.println("evening fellow beings");
    call.delay(150);
    System.out.println("█blue- who's there");
    call.delay(150);
    System.out.println("someone you would'nt know");
    call.delay(150);
    System.out.println("█cg-speaks in riddles...");
    call.delay(150);
    System.out.println("█rbi- reminds me of the creator");
    call.delay(150);
    System.out.println("enough im bored,entertain me. do fight");
    }
}
