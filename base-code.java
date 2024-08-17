import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class im {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // birth of bro
        im call = new im();
        call.birth();
    }

    // there, there being born a hero
    void birth() {
        System.out.println("What is his name?");

        // Play audio in a separate thread during the delay
        new Thread(() -> playAudio("./birth.mp3")).start();

        try {
            Thread.sleep(7000); // Delay for 7 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("██████╗  █████╗ ███╗   ██╗██████╗  ██████╗ ███╗   ███╗");
        System.out.println("██╔══██╗██╔══██╗████╗  ██║██╔══██╗██╔═══██╗████╗ ████║");
        System.out.println("██████╔╝███████║██╔██╗ ██║██║  ██║██║   ██║██╔████╔██║");
        System.out.println("██╔══██╗██╔══██║██║╚██╗██║██║  ██║██║   ██║██║╚██╔╝██║");
        System.out.println("██║  ██║██║  ██║██║ ╚████║██████╔╝╚██████╔╝██║ ╚═╝ ██║");
        System.out.println("╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═════╝  ╚═════╝ ╚═╝     ╚═╝");
    }

    void playAudio(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
            audioClip.start();

            // Keep the thread alive to let the audio play in the background
            while (audioClip.isRunning()) {
                Thread.sleep(10);
            }
            audioClip.close();
            audioStream.close();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
  void controls(){
  //add delay of 2 seconds
  //add 3 cubes, white cube in between. red cube to the right side. left to be the blue cube.
  System.out.println("the white cube is you,the blue is Blue_ and the red is cg");
  System.out.println("traditional controls with wasd");//display down
  }
}
